package org.improving.tag;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Scanner;

@Configuration
@ComponentScan("org.improving.tag")
@ComponentScan("org.")
public class SpringContext {
    @Bean
    public Scanner getScanner() { return new Scanner(System.in);}

    @Bean
    public DataSource createDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/tag?serverTimezone=UTC");
        dataSource.setUsername("taylorlocal");
        dataSource.setPassword("supertopsecretpassw0rd");
        return dataSource;
    }


}
