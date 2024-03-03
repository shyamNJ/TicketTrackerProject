package com.example.Week16GradedProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Week16GradedProject.model.TicketService;

@SpringBootApplication
public class Week16GradedProjectApplication {
	
	@Autowired
	TicketService tic;
	

	public static void main(String[] args) {
		SpringApplication.run(Week16GradedProjectApplication.class, args);
		
	}

}
