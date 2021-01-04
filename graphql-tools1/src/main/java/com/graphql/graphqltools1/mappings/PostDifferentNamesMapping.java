package com.graphql.graphqltools1.mappings;

import com.graphql.graphqltools1.models.Post1;
import com.graphql.graphqltools1.resolvers.Types;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PostDifferentNamesMapping {

    @Mappings({
                  @Mapping(target = "id", source = "source.ident"),
                  @Mapping(target = "text", source = "source.svensktext")})

    Post1 post(Types.CreatePostInput3Input source);



}
