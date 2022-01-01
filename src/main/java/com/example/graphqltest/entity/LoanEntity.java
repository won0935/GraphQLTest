package com.example.graphqltest.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "loan")
@Entity
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "loan", //주인은 'Many' 쪽에 있다
            cascade = CascadeType.ALL, //영속성 전이
            orphanRemoval = true) //자식은 자동으로 지워짐
    private List<LoanTagEntity> loanTagList = new ArrayList<>();
}
