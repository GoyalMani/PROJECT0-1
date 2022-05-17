package com.company.bankApp;




public class Customer {
    private int ac_no;
    private String c_name;
    private int bal;
    private String pwd;

    public Customer()
    {

    }
    public Customer(int ac_no,String c_name,int bal,String pwd)
    {
        this.ac_no=ac_no;
        this.c_name=c_name;
        this.bal=bal;
        this.pwd=pwd;

    }
    public Customer(int ac_no,int bal)
    {
        this.ac_no=ac_no;

        this.bal=bal;
    }

    public Customer(int ac_no) {
        this .ac_no=ac_no;
    }

    public Customer(int ac_no, String c_name, int bal) {
        this.ac_no = ac_no;
        this.c_name = c_name;
        this.bal = bal;
    }

    public int getAc_no() {
        return ac_no;
    }

    public void setAc_no(int ac_no) {
        this.ac_no = ac_no;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "ac_no=" + ac_no +
                ", c_name='" + c_name + '\'' +
                ", bal=" + bal +
                ", pwd='" + pwd + '\'' +
                '}';
    }

}
