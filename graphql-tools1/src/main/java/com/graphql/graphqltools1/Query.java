package com.graphql.graphqltools1;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
class Query implements GraphQLQueryResolver {

 /*   com.graphql.graphqltools1.models.Post getPost(Long id) {
        return new com.graphql.graphqltools1.models.Post("defalut",id);
    }
*/

    public String hello() {
        return "Hello world!";
    }

}
