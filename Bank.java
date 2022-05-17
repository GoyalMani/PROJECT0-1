package com.company.bankApp;

public class Bank {
  private int acct_no;
  private String emp_id;
  private char c_name;

  public Bank(){

  }

    public Bank(String emp_id) {
        this.emp_id = emp_id;
    }



    public int getAcct_no() {
        return acct_no;
    }

    public void setAcct_no(int acct_no) {
        this.acct_no = acct_no;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public char getC_name() {
        return c_name;
    }

    public void setC_name(char c_name) {
        this.c_name = c_name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "acct_no=" + acct_no +
                ", emp_id='" + emp_id + '\'' +
                ", c_name=" + c_name +
                '}';
    }
}
