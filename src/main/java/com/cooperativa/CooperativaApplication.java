package com.cooperativa;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CooperativaApplication {
	static LocalTime time2;
	public static void main(String[] args) {
		SpringApplication.run(CooperativaApplication.class, args);
		
		LocalDateTime fromDateTime = LocalDateTime.of(2021, 06, 11, 16, 0, 0);
		LocalDateTime toDateTime = LocalDateTime.now();
	    Duration period = Duration.between(fromDateTime, toDateTime);
	    
	    System.out.println("hora:" + period.toHours() + "minutos:"+ period.toMinutes());
	       LocalTime.of(period.toHoursPart(),period.toMinutesPart(),period.toSecondsPart());
	       System.out.println(LocalTime.of(period.toHoursPart(),period.toMinutesPart(),period.toSecondsPart())
		);
		   
	}

}
