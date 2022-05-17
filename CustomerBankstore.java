package com.company.bankApp;

import java.sql.SQLException;

public class CustomerBankstore {
public static BankMethod b1;

private CustomerBankstore()
{

}
public static BankMethod getBankMethod() throws SQLException {
    if (b1 == null)
        b1 = new BankMethodImpl();
    return b1;

}



}
