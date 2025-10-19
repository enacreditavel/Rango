package com.unifacisa.ads.rango;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RangoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RangoApplication.class, args);
	}

}
