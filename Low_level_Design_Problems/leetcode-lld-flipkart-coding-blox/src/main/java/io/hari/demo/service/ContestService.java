package io.hari.demo.service;

import io.hari.demo.config.AppConfig;
import io.hari.demo.constant.ContestStatus;
import io.hari.demo.constant.Level;
import io.hari.demo.dao.ContestDao;
import io.hari.demo.dao.QuestionDao;
import io.hari.demo.dao.UserDao;
import io.hari.demo.entity.Contest;
import io.hari.demo.entity.Question;
import io.hari.demo.entity.User;
import io.hari.demo.entity.helper.ContestQuestions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContestService {
    private final ContestDao contestDao;
    private final QuestionDao questionDao;
    private final UserDao userDao;
    private final AppConfig config;
    private final UserService userService;


    public Contest createContest(String contestName, Level contestLevel, User user) {
        final List<Long> questions = contestLevelWiseAllQuestions(contestLevel);

        final ContestQuestions contestQuestions = ContestQuestions.builder().questions(questions).build();
        final Contest newContest = Contest.builder().name(contestName)
                .userId(user.getId())
                .level(contestLevel)
                .status(ContestStatus.started)
                .contestQuestions(contestQuestions)
                .build();
        contestDao.save(newContest);
        setContestToUser(user, newContest);
        return newContest;
    }

    private void setContestToUser(User fetchedUser, Contest contest) {
        final Optional<User> optionalUser = userDao.findById(fetchedUser.getId());
        optionalUser.ifPresent(user -> {
            userService.setUserContestQuestion(user, contest);
            userDao.save(user);
        });
    }

    /**
     * Approach:
     * find all contest user
     * for each user get questions
     * calculate score & update
     * contest status ended
     */
    public void runContest(Contest contest) {
        validateContest(contest);
        final List<User> allContestUser = userService.findAllContestUser(contest.getId());
        log.info("allContestUser ------ = " + allContestUser.stream().map(i -> i.getUsername()).collect(Collectors.toList()));
        final String contestLevel = contest.getLevel().toString();
        final BigInteger scoreConstant = config.getScoreConstant().get(contestLevel);
        //for all user solve question and update score
        allContestUser.forEach(user -> {
            final List<Question> userQuestions = getUserQuestions(user, contest.getId());
            calculateUserNewScore(scoreConstant, user, userQuestions);
        });
        contest.setStatus(ContestStatus.ended);
        contestDao.save(contest);
    }

    private List<Question> getUserQuestions(User user, Long contestId) {
        final List<Long> questions = user.getUserContestQuestions().getContestQuestionsMap().get(contestId);
        log.info("User: {}", user.getUsername());
        if (questions == null) return new LinkedList<>();
        final List<Question> userQuestions = questions.stream().map(i -> questionDao.findById(i).get()).filter(Objects::nonNull)
                .collect(Collectors.toList());
        log.info("User questions: {}", userQuestions.stream().map(Question::getId).collect(Collectors.toList()));
        return userQuestions;
    }

    public User calculateUserNewScore(BigInteger scoreConstant, User user, List<Question> userQuestions) {
        final BigInteger calculatedScore = userQuestions.stream()
                .map(i -> i.getScore())
                .reduce(BigInteger::add).orElseGet(() -> BigInteger.ZERO);
        System.out.println("calculated score = " + calculatedScore);

        final BigInteger currentScore = user.getScore();
        System.out.println("currentScore user score = " + currentScore);
        final BigInteger newScore = currentScore.add(calculatedScore).subtract(scoreConstant);//todo
        System.out.println("newScore user score = " + newScore);
        user.setScore(newScore);
        return userDao.save(user);
    }

    private List<Long> contestLevelWiseAllQuestions(Level questionLevel) {
        final List<Question> questions = questionDao.findAllByLevelQuestions(questionLevel.toString());
        final List<Long> questionIds = questions.stream().map(i -> i.getId()).collect(Collectors.toList());
        return questionIds;
    }

    //bonus functionality : implementations not required
    public void withdrawContest(User user1, Contest contest) {
        if (contest.getStatus().equals(ContestStatus.ended)) {
            log.warn("user: [{}] , contest: [{}] ended not able to delete", user1.getUsername(), contest.getName());
            return;
        }
        final Map<Long, List<Long>> userContestQuestions = user1.getUserContestQuestions().getContestQuestionsMap();
        if (userContestQuestions.containsKey(contest.getId())) {
            userContestQuestions.remove(contest.getId());
            userDao.save(user1);
            log.info("user: [{}] , contest: [{}] , withdraw successful", user1.getUsername(), contest.getName());
        }
    }

    //bonus functionality : implementations not required
    public List<String> contestHistory(Contest contest) {
        final List<User> allContestUser = userService.findAllContestUser(contest.getId());
        log.info("contest: [{}],  user list: {}", contest.getName(), allContestUser.stream().map(User::getId).collect(Collectors.toList()));
        List<String> list = new LinkedList<>();
        final BigInteger scoreConstant = config.getScoreConstant().get(contest.getLevel().toString());
        allContestUser.forEach(user -> {
            final List<Question> userQuestions = getUserQuestions(user, contest.getId());

            final User user1 = calculateUserNewScore(scoreConstant, user, userQuestions);
            final List<Long> userQuestion1s = user1.getUserContestQuestions().getContestQuestionsMap().get(contest.getId());
            String userHistory = "username: " + user1.getUsername() + " score: " + user1.getScore() + " questions: " + userQuestion1s;
            list.add(userHistory);
        });
        return list;
    }

    private void validateContest(Contest contest) {
        if (contest.getStatus().equals(ContestStatus.in_progress)) {
            System.out.println("contest not started yet");
            throw new RuntimeException("contest not started yet");
        }
        if (contest.getStatus().equals(ContestStatus.ended)) {
            throw new RuntimeException("contest ended");
        }
    }
}
