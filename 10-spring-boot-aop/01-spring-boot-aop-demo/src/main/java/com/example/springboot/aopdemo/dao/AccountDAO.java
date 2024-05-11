package com.example.springboot.aopdemo.dao;

import com.example.springboot.aopdemo.Account;

public interface AccountDAO {
//    void addAccount();
    void addAccount(Account account, boolean vipFlag);

    boolean doWork();
}
