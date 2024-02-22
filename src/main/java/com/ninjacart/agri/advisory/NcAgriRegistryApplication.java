package com.ninjacart.agri.advisory;

import com.ninjacart.agri.advisory.crop.dto.CropRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.function.Consumer;
import java.util.function.Function;


@EnableJpaRepositories(basePackages = "com.ninjacart.agri.advisory.refdata.repository")
@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
public class NcAgriRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NcAgriRegistryApplication.class, args);
	}
	@Bean
	public Function<Message<CropRecord>,Message<CropRecord>> processorBinding(){
		return message -> {
			CropRecord crop = message.getPayload();
			return message; // Return with modified Person object
		};
	}

	@Bean
	public Consumer<Message<CropRecord>> consumerBinding() {
		return message -> {
			//Crop crop = message.getPayload();
			System.out.println("_________RECEIVED CREATED CROP_________: " + message.getPayload());
		};
	}
}
