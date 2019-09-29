package org.improving.tag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("org.improving.tag")
public class SpringContext {
    @Bean
    public Scanner getScanner() { return new Scanner(System.in);}
}
