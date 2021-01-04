package com.graphql.graphqltools1.mappings;

import com.graphql.graphqltools1.NestedMutation2;
import com.graphql.graphqltools1.models.Comment2;
import com.graphql.graphqltools1.models.Post2;
import com.graphql.graphqltools1.resolvers.CreateCommentInput2;
import com.graphql.graphqltools1.resolvers.CreatePostInput2;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface Post2Mapper {
    Post2Mapper INSTANCE = Mappers.getMapper(Post2Mapper.class);
    Post2 post2Target(CreatePostInput2 postInput2);
    Comment2 comment2Target(CreateCommentInput2 commentInput2);

}
