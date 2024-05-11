package com.example.springboot.aopdemo;

import com.example.springboot.aopdemo.dao.AccountDAO;
import com.example.springboot.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		return runner -> {

			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
//		theAccountDAO.addAccount();
//		theMembershipDAO.addSillyMember();

		Account account = new Account();
		theAccountDAO.addAccount(account, true);
		theMembershipDAO.addSillyMember();

		theAccountDAO.doWork();
		theMembershipDAO.goToSleep();
	}

}
