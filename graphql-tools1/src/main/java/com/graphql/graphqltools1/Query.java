package com.graphql.graphqltools1;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
class Query implements GraphQLQueryResolver {

   Post getPost(Long id) {
        return new Post(id);
    }

}
