package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.crm.dao.CrmRepository;


@SpringBootApplication
@ComponentScan(basePackages = "com.crm")
@EnableJpaRepositories("com.crm.dao")
@EntityScan("com.crm")
public class CrmApplication {

	public static void main(String[] args) {
        ApplicationContext ctx =  SpringApplication.run(CrmApplication.class, args);
		
		CrmRepository CrmRepository = ctx.getBean(CrmRepository.class);
		
	}
	

}
