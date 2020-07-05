package com.balanced;

import com.balanced.Services.UsersService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BalancedmatchApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BalancedmatchApplication.class, args);

		UsersService usersService = context.getBean("usersService", UsersService.class);
		System.out.println(usersService.getUsersByGroupAndTeam("1decembrie","echipasmk"));

	}
}
