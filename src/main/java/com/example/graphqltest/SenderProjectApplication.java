package com.example.graphqltest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // Feign Client를 사용할 것
@SpringBootApplication
public class SenderProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SenderProjectApplication.class, args);
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
