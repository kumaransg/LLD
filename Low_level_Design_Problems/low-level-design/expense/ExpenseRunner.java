package expense;

import expense.data.ExpenseData;
import expense.data.UserData;
import expense.models.User;
import expense.service.ExpenseService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ExpenseRunner {
    public static void main(String[] args) {
        System.out.println("Running SplitWise");

        UserData userData = UserData.getInstance();
        ExpenseData expenseData = ExpenseData.getInstance();

        userData.addUser(new User("u1", "sss", "sss@gmail.com", "123"));
        userData.addUser(new User("u2", "sss", "sss@gmail.com", "123"));
        userData.addUser(new User("u3", "sss", "sss@gmail.com", "123"));
        userData.addUser(new User("u4", "sss", "sss@gmail.com", "123"));

        ExpenseService expenseService = new ExpenseService();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";

        input_loop: while(true){

            try{
                userInput = br.readLine();
            }
            catch(IOException e){
                System.out.println(e);
            }

            String[] splitInput = userInput.split(" ");

            switch(splitInput[0]){

                case "EXPENSE": System.out.println("Adding Expense");
                    expenseService.addExpense(splitInput);
                    expenseData.printExpenses();
                    break;
                case "SHOW": System.out.println("Show records");
                    if(splitInput.length > 1)
                        expenseService.getBalance(splitInput[1]);
                    else
                        expenseService.getBalance();
                    break;
                case "EXIT": System.out.println("Exiting");
                    break input_loop;

                default: System.out.println("Invalid Input");
            }
        }
    }
}