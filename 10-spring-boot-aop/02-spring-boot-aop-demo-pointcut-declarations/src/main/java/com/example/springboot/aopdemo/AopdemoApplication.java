package com.example.springboot.aopdemo;

import com.example.springboot.aopdemo.dao.AccountDAO;
import com.example.springboot.aopdemo.dao.MembershipDAO;
import com.example.springboot.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService trafficFortuneService
											   ){
		return runner -> {

//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
//			demoTheAfterReturningAdvice(theAccountDAO);

//			demoTheAfterThrowingAdvice(theAccountDAO);

//			demoTheAfterAdvice(theAccountDAO);
//			demoTheAroundAdvice(trafficFortuneService);

//			demoTheAroundAdviceHandleException(trafficFortuneService);

			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
		System.out.println("----");

		String data = trafficFortuneService.getFortune(true);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		System.out.println("----");

		String data = trafficFortuneService.getFortune(true);

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: AroundDemoApp");
		System.out.println("----");

		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}
	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = null;
		try {
			boolean tripWire = false; //set to true to simulate an exception
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception e){
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}

		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(theAccounts);
		System.out.println("\n");;

	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = null;
		try {
			boolean tripWire = true; //set to true to simulate an exception
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception e){
			System.out.println("\n\nMain Program ... caught exception: " + e);
		}

		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = theAccountDAO.findAccounts();

		System.out.println("\n\nMain Program: AfterReturningDemoApp");
		System.out.println("----");

		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
//		theAccountDAO.addAccount();
//		theMembershipDAO.addSillyMember();

		Account account = new Account("Madhu", "Platinum");
		theAccountDAO.addAccount(account, true);
		theMembershipDAO.addSillyMember();

		//call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		theAccountDAO.doWork();
		theMembershipDAO.goToSleep();
	}

}
