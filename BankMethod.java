package com.company.bankApp;

import java.sql.SQLException;
import java.util.List;

public interface BankMethod {
    void logincust(String name, String pass) throws SQLException;
    void register(Customer cust) throws SQLException;

    void createCust(Customer cust) throws SQLException;

    boolean getbalance(int acno) throws SQLException;

    boolean deposit(int acno) throws SQLException;

    boolean withdraw(int acno) throws SQLException;


    List<Customer> displayall() throws SQLException;

    boolean transfermoney(int acno) throws SQLException;

    boolean getcustByempId(String id) throws SQLException;

}
