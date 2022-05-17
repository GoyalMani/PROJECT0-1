package com.company.bankApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//all method body here
public class BankMethodImpl implements BankMethod {
    static Connection con = connection.getConnection();

    public BankMethodImpl() throws SQLException {
    }


    @Override

    public void logincust(String name, String pass) throws SQLException {


        Customer customer = new Customer();
        String sql = "(select acct_no,c_name,bal,pass_code from customer where c_name='" + name + "' and pass_code='" + pass + "')";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        //rs.next();
        if (rs.next()) {
            System.out.println("LOGIN SUCCESSFULLY");
            int acn = rs.getInt(1);
            String name1 = rs.getString(2);
            int bal1 = rs.getInt(3);
            String pass1 = rs.getString(4);
            customer = new Customer(acn, name1, bal1, pass1);
            System.out.println(customer);

        } else {
            System.out.println("LOGIN FAILED");
            System.out.println("INVALID USER NAME OR PASS CODE");
        }


    }

    @Override
    public void register(Customer cust) throws SQLException {
        String sql18 = "insert into customer(acct_no,c_name,bal,pass_code) values (?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql18);
        preparedStatement.setInt(1, cust.getAc_no());
        preparedStatement.setString(2, cust.getC_name());
        preparedStatement.setInt(3, cust.getBal());
        preparedStatement.setString(4, cust.getPwd());


        try {
            int check = preparedStatement.executeUpdate();
            if (check > 0) {
                System.out.println("REGISTERED SUCCESSFULLY");
            }
        } catch (Exception e) {

            System.out.println("REGISTERING ACCOUNT FAILED \n PLEASE CONTACT CUSTOMER SERVICE");
        }



    }

    @Override

    public void createCust(Customer cust) throws SQLException {


        String sql = "insert into customer(acct_no,c_name,bal,pass_code) values (?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, cust.getAc_no());
        preparedStatement.setString(2, cust.getC_name());
        preparedStatement.setInt(3, cust.getBal());
        preparedStatement.setString(4, cust.getPwd());


        try {
            int check = preparedStatement.executeUpdate();
            if (check > 0) {
                System.out.println("ACCOUNT CREATED SUCCESSFULLY");
            }
        } catch (Exception e) {

            System.out.println("PROBLEM IN CREATING ACCOUNT \n PLEASE CONTACT CUSTOMER SERVICE");
        }
    }

    @Override
    public boolean getbalance(int acno) throws SQLException {
        Customer cust = new Customer();
        String s = "select acct_no,bal from customer where acct_no=" + acno;
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(s);


        if (rs.next()) {
            int ac = rs.getInt(1);
            int bal = rs.getInt(2);
            cust = new Customer(ac, bal);
            System.out.println(" BALANCE IS:   " + bal);


        } else {
            System.out.println("CONTACT CUSTOMER SERVICE");
        }
        return true;

    }

    @Override

    public boolean deposit(int ac_no) throws SQLException {
        Customer customer1 = new Customer();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER AMOUNT WANT TO DEPOSIT");
        int amt = sc.nextInt();
        String s1 = "update customer set bal=bal+ ? where acct_no =?";
        PreparedStatement preparedStatement = con.prepareStatement(s1);
        preparedStatement.setInt(1, amt);
        preparedStatement.setInt(2, ac_no);


        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("DEPOSIT SUCCESSFULLY");
            System.out.println(getbalance(ac_no));
                    }
        else
            System.out.println("FAILED TO UPDATE");

        return true;
    }

    @Override
    public boolean withdraw(int acno) throws SQLException {


        Customer customer1 = new Customer();
        Scanner sc1 = new Scanner(System.in);
        int bal = 0;
        String s = "select bal from customer where acct_no=" + acno;
        Statement statement = con.createStatement();
        ResultSet r = statement.executeQuery(s);
        if (r.next()) {
            bal = r.getInt(1);
            customer1 = new Customer(bal);

        }

        System.out.println("ENTER AMOUNT TO WITHDRAW ");
        int amt = sc1.nextInt();
        if(amt<0.0) {
            System.out.println("CAN'T WITHDRAW NEGATIVE MONEY");
        }
        else {

            if (amt >= bal) {
                System.out.println("INSUFFICIENT FUND");
            } else {
                String s2 = "update customer set bal=bal-? where acct_no=? ";
                PreparedStatement preparedStatement1 = con.prepareStatement(s2);
                preparedStatement1.setInt(1, amt);
                preparedStatement1.setInt(2, acno);
                int count1 = preparedStatement1.executeUpdate();
                if (count1 > 0) {
                    System.out.println("SUCCESSFULLY WITHDRAWAL");
                    System.out.println(getbalance(acno));
                }
            }

        }

        return false;
    }


    @Override
    public List<Customer> displayall() throws SQLException {
        Bank bank = new Bank();
        Scanner sc7 = new Scanner(System.in);
         System.out.println(" ENTER EMPLOYEE ID");
         String empid = sc7.next();
        String s9 = "select emp_id from bank where emp_id='" + empid + "'";
        Statement statement = con.createStatement();
        ResultSet re = statement.executeQuery(s9);
        if (re.next()) {
            re.getString(1);
            System.out.println("VALID ID");
            bank = new Bank(empid);

            List<Customer> customerList = new ArrayList<>();
            String sql = "call p_cust()";
            Statement statement12 = con.createStatement();
            ResultSet rs = statement12.executeQuery(sql);
            while (rs.next()) {
                int acctno = rs.getInt(1);
                String name = rs.getString(2);
                int bal = rs.getInt(3);
                String p1 = rs.getString(4);
                Customer customer = new Customer(acctno, name, bal, p1);
                customerList.add(customer);
                System.out.println(customer);

            }
        }
        else {
            System.out.println("NOT A VALID ID");
            System.out.println("ACCESS DENIED");
        }

        return null;
    }

    @Override
    public boolean transfermoney(int acno) throws SQLException {
        Customer cust3 = new Customer();
        Scanner sc2 = new Scanner(System.in);
        int bal = 0;
        String s3 = "select acct_no, bal from customer where  acct_no=" + acno;
        Statement statement14 = con.createStatement();
        ResultSet r2 = statement14.executeQuery(s3);
        if (r2.next()) {
            int ac = r2.getInt(1);
            bal = r2.getInt(2);
            cust3 = new Customer(bal);

        }

        System.out.println("ENTER AMOUNT WANT TO TRANSFER");
        int amt = sc2.nextInt();
        if (amt >= bal) {
            System.out.println("INSUFFICIENT FUND");
        } else {
            String s4 = "update customer set bal=bal-? where acct_no=? ";
            PreparedStatement preparedStatement1 = con.prepareStatement(s4);
            preparedStatement1.setInt(1, amt);
            preparedStatement1.setInt(2, acno);
            int count1 = preparedStatement1.executeUpdate();
            if (count1 > 0) {
                System.out.println("MONEY TRANSFERRED ");
                System.out.println( getbalance(acno));

                            }

        }
        System.out.println("ENTER ACCOUNT NO TO WHICH WANT TO TRANSFER");
        int act = sc2.nextInt();
        String s5 = "update customer set bal=bal+? where acct_no=?";
        PreparedStatement preparedStatement = con.prepareStatement(s5);
        preparedStatement.setInt(1, amt);
        preparedStatement.setInt(2, act);
        int count4 = preparedStatement.executeUpdate();

        if (count4 > 0) {
            System.out.println("TRANSFERRED MONEY ACCEPTED");
            System.out.println( getbalance(act));
        }

        return true;
    }

    @Override
    public boolean getcustByempId(String id) throws SQLException {
        Bank bank5 = new Bank();
        Scanner sc15 = new Scanner(System.in);
        String s16 = "select emp_id from bank where emp_id='" + id + "'";
        Statement statement20 = con.createStatement();
        ResultSet re1 = statement20.executeQuery(s16);
        if (re1.next()) {
            re1.getString(1);
            System.out.println("VALID ID");
            bank5 = new Bank(id);
            Customer cust4 = new Customer();
            System.out.println("ENTER ACCOUNT NUMBER YOU WANT TO SEARCH");
            int ac8 = sc15.nextInt();

            String s10 = "select acct_no,c_name,bal,pass_code from customer where acct_no=" + ac8;
            Statement statement6 = con.createStatement();
            ResultSet r = statement6.executeQuery(s10);
            if (r.next()) {
                r.getInt(1);
                String n = r.getString(2);
                int b = r.getInt(3);
                String l=r.getString(4);
                cust4 = new Customer(ac8, n, b,l);
                System.out.println(cust4);
            } else {
                System.out.println("NOT A VALID ACCOUNT NUMBER");
            }
        } else {
            System.out.println(" NOT A VALID ID");
            System.out.println("ACCESS DENIED");
        }

        return false;

    }


}