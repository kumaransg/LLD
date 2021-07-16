package io.abhishek.machinecoding.splitwise;

import io.abhishek.machinecoding.splitwise.expense.ExpenseType;
import io.abhishek.machinecoding.splitwise.model.EqualSplit;
import io.abhishek.machinecoding.splitwise.model.ExactSplit;
import io.abhishek.machinecoding.splitwise.model.PercentSplit;
import io.abhishek.machinecoding.splitwise.model.Split;
import io.abhishek.machinecoding.splitwise.model.User;
import io.abhishek.machinecoding.splitwise.service.ExpenseManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {
  static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) {
    ExpenseManager expenseManager = new ExpenseManager();

    expenseManager.addUser(new User("u1", "User1", "abhishek@gmail.com", 70051L));
    expenseManager.addUser(new User("u2", "User2", "shiv@gmail.com", 8285L));
    expenseManager.addUser(new User("u3", "User3", "shubh@gmail.com", 8789L));
    expenseManager.addUser(new User("u4", "User4", "knji@gmail.com", 8899L));


    while(true) {
      String command = sc.nextLine();
      String[] commands = command.split(" ");
      String commandType = commands[0];

      switch (commandType) {
        case "SHOW":
          if (commands.length == 1) {
            expenseManager.showBalances();
          } else {
            expenseManager.showBalance(commands[1]);
          }
          break;
        case "EXPENSE":
          String paidBy = commands[1];
          Double amount = Double.parseDouble(commands[2]);
          int noOfUsers = Integer.parseInt(commands[3]);
          List<Split> splits = new ArrayList<>();
          String expenseType = commands[4 + noOfUsers];
          switch (expenseType) {
            case "EQUAL":
              for(int i = 0;i < noOfUsers;i++) {
               splits.add(new EqualSplit(expenseManager.userMap.get(commands[4 + i])));
              }
              expenseManager.addExpense(ExpenseType.EQUAL, amount, paidBy, splits, null);
              break;
            case "EXACT":
              for(int i = 0;i < noOfUsers;i++) {
                splits.add(new ExactSplit(expenseManager.userMap.get(commands[4 + i]),
                    Double.parseDouble(commands[5 + noOfUsers + i])));
              }
              expenseManager.addExpense(ExpenseType.EXACT, amount, paidBy, splits, null);
              break;
            case "PERCENT" :
              for(int i = 0;i < noOfUsers;i++) {
                splits.add(new PercentSplit(expenseManager.userMap.get(commands[4 + i]),
                    Double.parseDouble(commands[5 + noOfUsers + i])));
              }
              expenseManager.addExpense(ExpenseType.PERCENT, amount, paidBy, splits, null);
              break;
          }
         break;
        default:
          break;
      }
    }



  }
}
