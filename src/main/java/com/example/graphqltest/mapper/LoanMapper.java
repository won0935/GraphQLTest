package com.example.graphqltest.mapper;


import com.example.graphqltest.entity.LoanEntity;
import com.example.graphqltest.model.LoanModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring") //spring 꼭 써줘야함
public interface LoanMapper {

    LoanEntity toEntity(LoanModel model);

    List<LoanEntity> toEntity(List<LoanModel> model);

    LoanModel toModel(LoanEntity entity);

    List<LoanModel> toModel(List<LoanEntity> entity);

    @AfterMapping
    default void after(@MappingTarget final LoanEntity entity, LoanModel model) {
        entity.getLoanTagList().forEach(loan -> loan.setLoan(entity));
    }
}
