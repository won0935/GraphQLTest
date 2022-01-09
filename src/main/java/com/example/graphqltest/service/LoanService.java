package com.example.graphqltest.service;

import com.example.graphqltest.fegin.TestClient;
import com.example.graphqltest.model.LoanModel;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
@RequiredArgsConstructor
public class LoanService {

    private final TestClient testClient;

    @GraphQLQuery(name = "loans")
    public List<LoanModel> getLoans() {
        return testClient.loans();
    }

    //{
    //	post(id:1){
    //		id
    //		title
    //	}
    //}
    @GraphQLQuery(name = "loan")
    public LoanModel getLoanById(Long id) {
        return testClient.getLoanById(id);
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
    @GraphQLMutation(name = "saveLoan")
    public LoanModel saveLoan(LoanModel post) {
        return testClient.saveLoan(post);
    }

    //mutation{
    //	deletePost(id:1)
    //}
    @GraphQLMutation(name = "deleteLoan")
    public void deleteLoan(Long id) {
        testClient.deleteLoan(id);
    }

    //{
    //	posts{
    //		title
    //		isGood
    //	}
    //}
//    @Transactional
//    @GraphQLQuery(name = "isGood")
//    public boolean isGood(@GraphQLContext LoanModel entity) {
//        return !entity.getName().equals("title1");
//    }
}
