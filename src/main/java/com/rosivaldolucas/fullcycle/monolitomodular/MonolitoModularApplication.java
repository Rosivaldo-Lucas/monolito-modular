package com.rosivaldolucas.fullcycle.monolitomodular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

@SpringBootApplication
public class MonolitoModularApplication {

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "development");

		SpringApplication.run(MonolitoModularApplication.class, args);
	}

}
