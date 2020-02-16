package org.evil.mutants.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.evil.mutants.app","org.evil.mutants.config","org.evil.mutants.impl"})
public class EvilmutantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvilmutantsApplication.class, args);
	}

}
