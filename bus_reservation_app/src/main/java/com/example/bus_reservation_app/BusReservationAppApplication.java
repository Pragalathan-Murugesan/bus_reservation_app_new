package com.example.bus_reservation_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class BusReservationAppApplication {

	public static Logger logger = LoggerFactory.getLogger(BusReservationAppApplication.class);
	public static void main(String[] args) {
		logger.info("main class stated");
		SpringApplication.run(BusReservationAppApplication.class, args);
	}
}
