package com.example.graphqltest.service;

import com.example.graphqltest.mapper.LoanMapper;
import com.example.graphqltest.model.LoanModel;
import com.example.graphqltest.repository.LoanRepository;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@GraphQLApi
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    @Transactional
    @GraphQLQuery(name = "loans")
    public List<LoanModel> getLoans() {
        return loanMapper.toModel(loanRepository.findAll());
    }

    //{
    //	post(id:1){
    //		id
    //		title
    //	}
    //}
    @Transactional

    @GraphQLQuery(name = "loan")
    public LoanModel getLoanById(Long id) {
        return loanMapper.toModel(loanRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

//    mutation{
//        saveLoan(post:
//        {
//            id: 343
//            name :"sss",
//            loanTagList:[
//               {
//                        type: "test1",
//                        description :"xxx"
//                }
//                {
//                        type: "test2",
//                        description :"yyy"
//                }
//                {
//                        type: "test3",
//                        description :"zzz"
//                }
//            ]
//        })
//    }
    @Transactional
    @GraphQLMutation(name = "saveLoan")
    public LoanModel saveLoan(LoanModel post) {
        return loanMapper.toModel(loanRepository.save(loanMapper.toEntity(post)));
    }

    //mutation{
    //	deletePost(id:1)
    //}
    @Transactional
    @GraphQLMutation(name = "deleteLoan")
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    //{
    //	posts{
    //		title
    //		isGood
    //	}
    //}
    @Transactional
    @GraphQLQuery(name = "isGood")
    public boolean isGood(@GraphQLContext LoanModel entity) {
        return !entity.getName().equals("title1");
    }
}
