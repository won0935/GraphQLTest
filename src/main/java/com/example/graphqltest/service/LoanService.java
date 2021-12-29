package com.example.graphqltest.service;

import com.example.graphqltest.repository.LoanEntity;
import com.example.graphqltest.repository.LoanRepository;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    @GraphQLQuery(name = "loans")
    public List<LoanEntity> getLoans() {
        return loanRepository.findAll();
    }

    //{
    //	post(id:1){
    //		id
    //		title
    //	}
    //}
    @GraphQLQuery(name = "loan")
    public Optional<LoanEntity> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    //mutation{
    //	savePost(post:{title:"title"}){
    //		id
    //		title
    //	}
    //}
    @GraphQLMutation(name = "saveLoan")
    public LoanEntity saveLoan(LoanEntity post) {
        return loanRepository.save(post);
    }

    //mutation{
    //	deletePost(id:1)
    //}
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
    @GraphQLQuery(name = "isGood")
    public boolean isGood(@GraphQLContext LoanEntity entity) {
        return !entity.getName().equals("title1");
    }

}
