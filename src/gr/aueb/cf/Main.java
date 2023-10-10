package gr.aueb.cf;

import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;
import gr.aueb.cf.model.Account;
import gr.aueb.cf.model.OverdraftAccount;
import gr.aueb.cf.model.OverdraftJointAccount;
import gr.aueb.cf.model.User;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("Fil", "dim", "12345");
        User anna = new User("Anna", "G", "56789");

        Account account = new Account(user1, "GR12345", 100);

        Account over = new OverdraftAccount(user1, "GR23456", 50);

        Account overJointAccount = new OverdraftJointAccount(user1, "GR256789", 200, anna);

        try {


            System.out.println("Account: \n" + account);

            System.out.println("Overdraft account: \n" + over);

            overJointAccount.deposit(100);
            overJointAccount.withdraw(50, "56789");

            System.out.println("Joint Account: \n" + overJointAccount);

        } catch (NegativeAmountException | InsufficientBalanceException | SsnNotValidException e) {

            System.out.println(e.getMessage());
        }

    }
}
