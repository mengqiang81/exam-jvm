package org.nofdev.transaction

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

/**
 * Created by Qiang on 1/13/15.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableTransactionManagement
class Application {
    static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
