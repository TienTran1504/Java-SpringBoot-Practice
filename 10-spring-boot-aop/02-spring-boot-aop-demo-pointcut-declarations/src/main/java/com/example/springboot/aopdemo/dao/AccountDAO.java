package com.example.springboot.aopdemo.dao;

import com.example.springboot.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
//    void addAccount();
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
    String getName();
    void setName(String name);
    String getServiceCode();
    void setServiceCode(String serviceCode);
}
