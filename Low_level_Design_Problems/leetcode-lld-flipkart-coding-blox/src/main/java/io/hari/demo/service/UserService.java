package io.hari.demo.service;

import io.hari.demo.config.AppConfig;
import io.hari.demo.dao.ContestDao;
import io.hari.demo.dao.UserDao;
import io.hari.demo.entity.Contest;
import io.hari.demo.entity.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

import static io.hari.demo.config.AppConfig.ContestQuestionAssignment.all_questions;
import static io.hari.demo.config.AppConfig.ContestQuestionAssignment.random_questions;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    private final QuestionService questionService;
    private final ContestDao contestDao;
    private final AppConfig config;


    public User create(@NonNull final User user) {
        user.setScore(BigInteger.valueOf(1500));
        return userDao.save(user);
    }

    public List<User> createMultiUsers(final List<User> users) {
        users.stream().filter(Objects::nonNull)
                .forEach(user -> user.setScore(BigInteger.valueOf(1500)));
        return userDao.saveAll(users);
    }

    public void assignContestToUser(@NonNull final User user, @NonNull final Contest contest) {//low -> 20 , 1,2...20
        setUserContestQuestion(user, contest);
        userDao.save(user);
    }

    public void setUserContestQuestion(@NonNull final User user, @NonNull final Contest contest) {
        validateUserAndContest(user, contest);
        List<Long> contestQuestions = new LinkedList<>();
        if (config.getContestQuestionAssignment().equals(all_questions)) {
            contestQuestions = contest.getContestQuestions().getQuestions();
        } else if (config.getContestQuestionAssignment().equals(random_questions)) {
            contestQuestions = questionService.getContestQuestions(contest);
        }
        final Map<Long, List<Long>> fetchContestQuestions = user.getUserContestQuestions().getContestQuestionsMap();
        fetchContestQuestions.putIfAbsent(contest.getId(), contestQuestions);
    }

    public void validateUserAndContest(@NonNull final User user, @NonNull final Contest contest) {
        validateUser(user);
        validateContest(contest);
    }

    public void validateUser(@NonNull final User user) {
        final Optional<User> fetchedUser = userDao.findById(user.getId());
        if (fetchedUser == null) throw new RuntimeException("user not found");
    }

    private void validateContest(@NonNull final Contest contest) {
        final Contest fetchedContest = contestDao.findById(contest.getUserId()).get();
        if (fetchedContest == null) throw new RuntimeException("contest not found");
    }

    public List<User> findAllContestUser(@NonNull final Long contestId) {
        final List<User> users = new LinkedList<>();
        userDao.findAll().forEach(user -> {
            final Map<Long, List<Long>> contestQuestions = user.getUserContestQuestions().getContestQuestionsMap();
            if (contestQuestions.containsKey(contestId)) {
                users.add(user);
            }
        });
        return users;
    }
}
