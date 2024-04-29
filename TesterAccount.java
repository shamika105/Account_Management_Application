package com.test;

import java.sql.SQLException;
import java.util.List;

import java.util.Scanner;

import com.Dao.AccountDao;
import com.pojo.Accounts;
import com.pojo.Accounts;

public class TesterAccount {

    public static void main(String[] args) throws SQLException {
        System.out.println("Welcome to Account Management Application.......");

        System.out.println("Menus are:" + "\n" + "1. Add Account\n2. Edit Account\n3. Remove Account\n4. Get all Account\n5. Get Account by Id\n6. Exit");
        int a;
        Scanner sc = new Scanner(System.in);

        AccountDao Dao = new AccountDao();
        do {
            System.out.println("Enter your choice:");
            a = sc.nextInt();

            switch (a) {
                case 1:
                	System.out.println("Add new Account:");
                	System.out.println("Enter Accno, Accname, Balance, Username, Password:");

                	int id = sc.nextInt();
                	String name = sc.next();
                	Double ba = sc.nextDouble();
                	String user = sc.next();
                	String pw = sc.next();

                	Accounts act = new Accounts(id, name, ba, user, pw); // Assuming Account class has a constructor that takes (int, String, Double, String, String)
                	Dao.insertAcc(act);
                	System.out.println("Rows inserted.....");
                	break;

                    
                case 2:
                    System.out.println("Enter Account Id:");
                    System.out.println("Enter accno, accname, pwd");

                    id = sc.nextInt();
                    name = sc.next();
                    pw = sc.next();

                    Accounts actToUpdate = new Accounts(id, name, pw);
                    Dao.editAcc(actToUpdate);
                    break;

                case 3:
                    System.out.println("Enter acc Id:");

                    int id1 = sc.nextInt();
                    Dao.deleteAcc(id1);

                    System.out.println("Deleted account.....");
                    break;

                case 4:
                    System.out.println("All Account Details.......");
                    List<Accounts> listact = Dao.getAllAccounts();

                    for (Accounts acc : listact) {
                        System.out.println(acc);
                    }
                    break;

                case 5:
                    System.out.println("Enter Account Id:");

                    Accounts accobj = Dao.getAccountById(sc.nextInt());

                    if (accobj != null) {
                        System.out.println(accobj);
                    }
                    break;

                case 6:
                    System.out.println("Exiting Application.......");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
                    break;
            }

        } while (a != 6);
        System.out.println("Thanks for Using this Application.......");
        sc.close();
    }

}
