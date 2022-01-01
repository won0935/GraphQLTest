package com.example.graphqltest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class LoanModel {

    private Long id;

    private String name;

    private List<LoanTagModel> loanTagList;
}