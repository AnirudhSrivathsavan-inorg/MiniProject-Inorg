package com.inorg.miniproject;

import com.inorg.miniproject.model.Customer;
import com.inorg.miniproject.model.Orders;
import com.inorg.miniproject.repository.CustomerRepository;
import com.inorg.miniproject.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class MiniprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniprojectApplication.class, args);
	}
}
