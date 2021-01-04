package com.graphql.graphqltools1.mappings;

import com.graphql.graphqltools1.demomodels.CreatePostInput;
import com.graphql.graphqltools1.demomodels.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostCreatePostInputMapper {
    PostCreatePostInputMapper INSTANCE = Mappers.getMapper(PostCreatePostInputMapper.class);
    Post postMyTarget(CreatePostInput postInputSource);
}
