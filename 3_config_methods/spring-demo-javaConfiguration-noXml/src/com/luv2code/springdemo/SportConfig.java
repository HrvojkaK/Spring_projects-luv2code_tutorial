package com.luv2code.springdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.luv2code.springdemo") //allows Spring to scan package to find beans (classes with @Component Java Annotations)
public class SportConfig {

}
