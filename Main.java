package com.company.bankApp;


import com.sun.management.GarbageCollectionNotificationInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        BankMethod b1 = CustomerBankstore.getBankMethod();
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO MYBANK ONLINE APP");
        System.out.println("HOW DO YOU WANT TO CONNECT");
        System.out.println(" 1. USER");
        System.out.println(" 2. CUSTOMER");
        System.out.println(" 3. EMPLOYEE");
        System.out.println(" PLEASE ENTER YOUR CHOICE ");
        int l = sc.nextInt();
        switch (l) {
            case 1: {
                boolean flag2 = true;
                while (flag2) {
                    System.out.println("1. LOGIN");
                    System.out.println("2. REGISTER ");
                    System.out.println("3. LOGOUT");
                    System.out.println("SELECT YOUR CHOICE ");
                    int in = sc.nextInt();
                    switch (in) {
                        case 1: {
                            System.out.println("LOGIN");
                            System.out.println("ENTER USERNAME");
                            String n1 = sc.next();
                            System.out.println("ENTER PASS CODE");
                            String p1 = sc.next();
                            b1.logincust(n1, p1);
                            break;
                        }
                        case 2: {
                            System.out.println("ENTER ACCOUNT NO");
                            int a5 = sc.nextInt();
                            System.out.println("ENTER NAME");
                            String b5 = sc.next();
                            System.out.println("ENTER BAL");
                            int c5 = sc.nextInt();
                            System.out.println("ENTER PASSCODE");
                            String d5 = sc.next();
                            Customer cust11 = new Customer();
                            cust11.setAc_no(a5);
                            cust11.setC_name(b5);
                            cust11.setBal(c5);
                            cust11.setPwd(d5);
                            b1.register(cust11);
                            break;
                        }
                        case 3: {
                            System.out.println("LOGOUT");
                            System.out.println("THANK YOU FOR VISITING MYBANK ONLINE APP");

                            flag2 = false;
                            break;
                        }
                        default:
                            System.out.println("PLEASE ENTER VALID CHOICE");
                    }

                }
                break;
            }

            case 2: {

                boolean flag = true;
                while (flag) {

                    System.out.println("WHAT DO YOU WANT TO DO?");
                    System.out.println(" 1. CREATE ACCOUNT");
                    System.out.println(" 2. CHECK YOUR BALANCE");
                    System.out.println(" 3. DEPOSIT MONEY");
                    System.out.println(" 4. WITHDRAWAL MONEY");
                    System.out.println(" 5. TRANSFER MONEY");
                    System.out.println(" 6. LOGOUT");
                    System.out.println("PLEASE ENTER YOUR CHOICE");
                    int input = sc.nextInt();


                    switch (input) {

                        case 1: {
                            //create acct
                            System.out.println("ENTER ACCOUNT NO");
                            int a = sc.nextInt();
                            System.out.println("ENTER NAME");
                            String b = sc.next();
                            System.out.println("ENTER BAL");
                            int c = sc.nextInt();
                            System.out.println("ENTER PASSCODE");
                            String d = sc.next();
                            Customer cust1 = new Customer();
                            cust1.setAc_no(a);
                            cust1.setC_name(b);
                            cust1.setBal(c);
                            cust1.setPwd(d);
                            b1.createCust(cust1);


                            break;
                        }


                        case 2: {

                            System.out.println("ENTER ACCOUNT NUMBER TO CHECK THE BALANCE");
                            int ac1no = sc.nextInt();
                            b1.getbalance(ac1no);

                            break;
                        }
                        case 3: {

                            System.out.println("ENTER THE ACCOUNT NUMBER IN WHICH YOU WANT TO DEPOSIT");
                            int ac = sc.nextInt();

                            b1.deposit(ac);


                            break;
                        }

                        case 4: {

                            System.out.println("ENTER THE ACCOUNT NUMBER FROM WHICH YOU WANT TO WITHDRAW");
                            int ac = sc.nextInt();
                            b1.withdraw(ac);


                            break;
                        }
                        case 5: {

                            System.out.println("ENTER THE ACCOUNT NUMBER FROM WHICH YOU WANT TO TRANSFER");
                            int acn = sc.nextInt();
                            b1.transfermoney(acn);


                            break;
                        }

                        case 6: {

                            System.out.println("LOGOUT");
                            System.out.println("THANK YOU FOR USING MYBANK ONLINE APP");
                            flag = false;
                            break;
                        }

                        default:
                            System.out.println("PLEASE ENTER VALID CHOICE ");


                    }
                }
              break;
            }

            case 3: {
                boolean flag1 = true;
                while (flag1) {

                    System.out.println(" 1. DISPLAY SPECIFIC CUSTOMER RECORD");
                    System.out.println(" 2. DISPLAY ALL RECORD ");
                    System.out.println(" 3. LOGOUT");
                    System.out.println("PLEASE ENTER YOUR CHOICE");
                    int input1 = sc.nextInt();
                    switch (input1) {

                        case 1: {

                            System.out.println("PLEASE ENTER YOUR EMPLOYEE ID");
                            String h = sc.next();
                            b1.getcustByempId(h);

                            break;
                        }
                        case 2: {
                            b1.displayall();

                            break;
                        }
                        case 3: {
                            System.out.println("LOGOUT");
                            System.out.println("THANK YOU FOR USING MYBANK ONLINE APP");
                            flag1 = false;
                            break;
                        }
                        default:
                            System.out.println("PLEASE ENTER VALID CHOICE");

                    }


                }

                break;
            }

        }
    }
}
