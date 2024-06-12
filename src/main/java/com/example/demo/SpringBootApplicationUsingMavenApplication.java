package com.example.demo;

import com.example.demo.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootApplicationUsingMavenApplication {

	public static void main(String[] args) {
        //here run() acts as IOC
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootApplicationUsingMavenApplication.class, args);
		//context.toString();
		//User u = new User((long) 1.00, "Shubham", "26",  "I am Java Developer");
		//u.toString();
		//System.out.println(u);
		//String userName = u.getUserName();
		//System.out.println(userName);

	}

}
