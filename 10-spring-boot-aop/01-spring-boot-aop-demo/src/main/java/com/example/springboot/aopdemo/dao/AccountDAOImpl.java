package com.example.springboot.aopdemo.dao;

import com.example.springboot.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
//    @Override
//    public void addAccount() {
//        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
//    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
