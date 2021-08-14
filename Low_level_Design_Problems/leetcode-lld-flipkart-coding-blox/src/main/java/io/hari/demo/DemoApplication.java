package io.hari.demo;

import io.hari.demo.config.AppConfig;
import io.hari.demo.constant.Level;
import io.hari.demo.dao.ContestDao;
import io.hari.demo.dao.QuestionDao;
import io.hari.demo.dao.UserDao;
import io.hari.demo.entity.Contest;
import io.hari.demo.entity.Question;
import io.hari.demo.entity.User;
import io.hari.demo.service.ContestService;
import io.hari.demo.service.QuestionService;
import io.hari.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {
    private final AppConfig config;
    private final UserDao userDao;
    private final UserService userService;
    private final QuestionDao questionDao;
    private final ContestDao contestDao;
    private final ContestService contestService;
    private final QuestionService questionService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //todo check config
        System.out.println("config = " + config);

        //todo : create user
        final User hariom = User.builder().username("hariom").build();
        final User chandan = User.builder().username("chandan").build();
        final User naveen = User.builder().username("naveen").build();
        final User omprakash = User.builder().username("omprakash").build();

        userService.createMultiUsers(Arrays.asList(hariom, chandan, naveen, omprakash));
        userDao.findAll().forEach(System.out::println);

        //todo : test username field : working
//        final User user2 = User.builder().username("hariom").build();
//        userService.create(user2);

        //todo : create questions
        final Question question1 = Question.builder().question("que 1").level(Level.low).score(BigInteger.valueOf(10)).build();
        final Question question2 = Question.builder().question("que 2").level(Level.low).score(BigInteger.valueOf(20)).build();
        final Question question3 = Question.builder().question("que 3").level(Level.medium).score(BigInteger.valueOf(20)).build();
        final Question question4 = Question.builder().question("que 4").level(Level.medium).score(BigInteger.valueOf(30)).build();
        final Question question5 = Question.builder().question("que 5").level(Level.high).score(BigInteger.valueOf(40)).build();
        final Question question6 = Question.builder().question("que 6").level(Level.high).score(BigInteger.valueOf(50)).build();
        questionDao.saveAll(Arrays.asList(question1, question2, question3, question4, question5, question6));
        final Question question7 = questionService.createQuestion("que 7", Level.low, 10);
        questionDao.findAll().forEach(System.out::println);

        //todo : get all question level wise
        final List<Question> lowLevelQuestions = questionService.getAllQuestionLevelWise(Level.low);
        System.out.println("lowLevelQuestions = " + lowLevelQuestions);
        final List<Question> mediumLevel = questionService.getAllQuestionLevelWise(Level.medium);
        System.out.println("mediumLevel = " + mediumLevel);
        final List<Question> highLevel = questionService.getAllQuestionLevelWise(Level.high);
        System.out.println("highLevel = " + highLevel);

        //todo : create contest
        final Contest contest1 = contestService.createContest("contest 1", Level.low, hariom);
        final Contest contest2 = contestService.createContest("contest 2", Level.medium, chandan);
        contestDao.findAll().forEach(System.out::println);

        //todo : find all contest by level
        final List<Contest> lowContest = contestDao.findAllContestByLevelSQL("low");
        lowContest.stream().forEach(i-> System.out.println("contest = " + i));

        //todo : user can register contest
        userService.assignContestToUser(chandan, contest1);
        userService.assignContestToUser(omprakash, contest2);
        userService.assignContestToUser(naveen, contest2);
        userService.assignContestToUser(naveen, contest1);

        //todo : user can solve contest questions
        contestService.runContest(contest1);

        //todo : leader board
        final List<User> leaderBoard = userDao.findLeaderBoard();
        System.out.println("leader board");
        leaderBoard.forEach(System.out::println);

        //todo : contest history
        System.out.println("\ncheck history");
        contestService.contestHistory(contest1).forEach(System.out::println);

        //todo : withdraw contest (not working)
//        contestService.withdrawContest(naveen, contest2);
    }
}
