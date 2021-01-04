package com.graphql.graphqltools1.demomodels;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class Post {
    String id;
    String text;
    //List<Comment> comments;
    public Post(){}
}