package com.graphql.graphqltools1;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Mutation implements GraphQLMutationResolver {

  public Post createPost(String text){
    Post post = new Post(new Random().nextLong());
    post.setText(text);
    return post;
  }
}
