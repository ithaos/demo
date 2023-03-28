package haos.demo.springEventDemo.config;//package com.h.springEventDemo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.SimpleApplicationEventMulticaster;
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//import org.springframework.scheduling.annotation.EnableAsync;
//
//@Configuration
//@ComponentScan("com.h.springEventDemo")
//@EnableAsync
//public class EventConfig {
//
//    @Bean
//    public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
//        return new SimpleAsyncTaskExecutor();
//    }
//
//    @Bean
//    public SimpleApplicationEventMulticaster applicationEventMulticaster() {
//        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
//        simpleApplicationEventMulticaster.setTaskExecutor(simpleAsyncTaskExecutor());
//        return simpleApplicationEventMulticaster;
//    }
//}
//
