package com.sample.graphql.datafetcher;

import com.netflix.dgs.codgen.generated.types.Address;
import com.netflix.dgs.codgen.generated.types.Teacher;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RequiredArgsConstructor
@DgsComponent
public class TeacherDataFetcher {

    @DgsQuery(field = "teacher")
    public CompletableFuture<Teacher> teachers(@InputArgument("name") String name, DgsDataFetchingEnvironment dfe) {
        Teacher teacher = Teacher.newBuilder()
                .name(name)
                .age(99)
                .phone("+7xxxxxxxxxx")
                .address(Address.newBuilder()
                        .zipcode(420003)
                        .city("Some City")
                        .street("Unknown street")
                        .build())
                .build();
        return CompletableFuture.completedFuture(teacher);
    }
}
