package com.example.graphqltest;

import com.example.graphqltest.model.LoanModel;
import com.example.graphqltest.service.LoanService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class GraphQlTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQlTestApplication.class, args);
    }

//    @Bean
//    ApplicationRunner init(LoanService loanService) {
//        return args -> {
//            Stream.of("title1", "title2", "title3", "title4", "title5", "title6")
//                    .forEach(title -> {
//                        LoanModel loan = new LoanModel();
//                        loan.setName(title);
//                        loanService.saveLoan(loan);
//                    });
//            loanService.getLoans().forEach(System.out::println);
//        };
//    }
}
