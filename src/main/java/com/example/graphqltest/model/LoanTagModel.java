package com.example.graphqltest.model;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class LoanTagModel {

    private Long id;

    private String type;

    private String description;
}