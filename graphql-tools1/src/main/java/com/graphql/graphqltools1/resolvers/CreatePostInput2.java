package com.graphql.graphqltools1.resolvers;

import com.graphql.graphqltools1.NestedMutation2;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class CreatePostInput2 {
    Long id;
    String text;
    ArrayList<CreateCommentInput2> comments;
}
