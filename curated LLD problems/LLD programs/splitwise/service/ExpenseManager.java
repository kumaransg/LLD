package io.abhishek.machinecoding.splitwise.service;

import io.abhishek.machinecoding.splitwise.expense.Expense;
import io.abhishek.machinecoding.splitwise.expense.ExpenseMetaData;
import io.abhishek.machinecoding.splitwise.expense.ExpenseType;
import io.abhishek.machinecoding.splitwise.model.Split;
import io.abhishek.machinecoding.splitwise.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
  public Map<String, User> userMap;
  public Map<String, Map<String, Double>> balanceSheet;
  List<Expense> expenses;


  public ExpenseManager() {
    userMap = new HashMap<>();
    balanceSheet = new HashMap<String, Map<String, Double>>();
    expenses = new ArrayList<>();
  }
  public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits,
      ExpenseMetaData expenseMetaData) {
    Expense expense = ExpenseService.createExpense(expenseType, amount, userMap.get(paidBy), splits, expenseMetaData);
    expenses.add(expense);

    for(Split split : expense.getSplits()) {
      String paidTo = split.getUser().getId();
      Map<String, Double> balances = balanceSheet.get(paidBy);
      balances.put(paidTo, balances.getOrDefault(paidTo, 0.0) + split.getAmount());
      balances = balanceSheet.get(paidTo);
      balances.put(paidBy, balances.getOrDefault(paidBy, 0.0) - split.getAmount());
    }

  }
  public void addUser(User user) {
    userMap.put(user.getId(), user);
    balanceSheet.put(user.getId(), new HashMap<>());
  }

  public void showBalance(String userId) {
  boolean isEmpty = true;
  Map<String, Double> userBalance = balanceSheet.get(userId);
  for(Map.Entry<String, Double> individualBalance : userBalance.entrySet()) {
    if (individualBalance.getValue() != 0)
      isEmpty = false;
    printBalance(userId, individualBalance.getKey(), individualBalance.getValue());
  }
  if (isEmpty) {
    System.out.println("No Balance to show for " + userId);
  }
  }

  public void showBalances() {
    boolean isEmpty = true;
    for(Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
      for(Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
        if (userBalance.getValue() != 0)
        isEmpty = false;
        printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
      }
    }
   if (isEmpty) {
     System.out.println("No Balance to show");
   }
  }

  private void printBalance(String user1, String user2, Double amount) {
    String user1Name = userMap.get(user1).getName();
    String user2Name = userMap.get(user2).getName();
    if (amount > 0) {
      System.out.println(user2Name + " owes " + user1Name + " : " + Math.abs(amount));
    } else if (amount < 0) {
      System.out.println(user1Name + " owes " + user2Name + " : " + Math.abs(amount));
    }
  }


}
