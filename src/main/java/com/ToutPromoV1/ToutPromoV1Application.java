package com.ToutPromoV1;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.ToutPromoV1.properties.FileStorageProperties;


@SpringBootApplication

@EntityScan(basePackageClasses = {
		ToutPromoV1Application.class,
		Jsr310JpaConverters.class
})
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class ToutPromoV1Application {
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(ToutPromoV1Application.class, args);
	}

}
