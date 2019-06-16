package com.howtobe.taskhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class TaskHandlerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskHandlerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String[] beans = ctx.getBeanDefinitionNames();
            Arrays.sort(beans);
            Arrays.stream(beans).forEach(log::info);
        };
    }
}