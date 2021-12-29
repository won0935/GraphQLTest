package com.example.graphqltest.repository;


import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name = "loan")
@Entity
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @GraphQLQuery(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    @GraphQLQuery(name = "name")
    private String name;
}