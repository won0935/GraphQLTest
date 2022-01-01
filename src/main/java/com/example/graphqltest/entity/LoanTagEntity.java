package com.example.graphqltest.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "loan_tag")
public class LoanTagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column( nullable = false, length = 50)
    private String type;

    @Column( nullable = false, length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "loan_id") //외래키를 명명
    private LoanEntity loan;
}