package com.example.graphqltest.fegin;


import com.example.graphqltest.model.LoanModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "feign", url = "http://localhost:8070")
public interface TestClient {

    @GetMapping("/loans")
    List<LoanModel> loans();

    @GetMapping("/loan/{id}")
    LoanModel getLoanById(@PathVariable Long id);

    @PostMapping("/loan")
    LoanModel saveLoan(LoanModel post);

    @PostMapping("/delete-loan")
    void deleteLoan(Long id);
}