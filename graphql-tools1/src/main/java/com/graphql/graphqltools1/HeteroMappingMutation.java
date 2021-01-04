package com.graphql.graphqltools1;

import com.graphql.graphqltools1.mappings.Post2Mapper;
import com.graphql.graphqltools1.mappings.PostDifferentNamesMapping;
import com.graphql.graphqltools1.models.Comment2;
import com.graphql.graphqltools1.models.Post1;
import com.graphql.graphqltools1.models.Post2;
import com.graphql.graphqltools1.resolvers.CreateCommentInput2;
import com.graphql.graphqltools1.resolvers.CreatePostInput2;
import com.graphql.graphqltools1.resolvers.CreatePostInput3;
import com.graphql.graphqltools1.resolvers.Types;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;
//Heterogenous mapping

@Component
public class HeteroMappingMutation implements GraphQLMutationResolver {

    private static final Logger logger = LoggerFactory.getLogger(GraphQLMutationResolver.class);

 /*  @Autowired
    private KafkaTemplate<String, Post2> kafkaTemplatePost;

    @Autowired
    private KafkaTemplate<String, Comment3> kafkaTemplateComment;

    private static final String POST2TOPIC = "avropost2";
    private static final String COMMENT2TOPIC = "avrocomment2";*/

  public Post  createNestedPost3(Types.CreatePostInput3Input input)
  {
  /*   Post1 post1 = new Post1(input.getText(),new Random().nextLong());

      //kafkaTemplatePost.send(POSTTOPIC,String.valueOf(post1.getId()),post1);
      Comment1 comment = new Comment1(input.getComments().getDescription(),new Random().nextLong());



     // kafkaTemplateComment.send(COMMENTTOPIC,String.valueOf(comment.getId()),comment);
      logger.info("###################################"+input.getComments());*/
     /*
       Post2Mapper post2Mapper = Mappers.getMapper(Post2Mapper.class);
       Post2 post2 = post2Mapper.post2Target(input);
       kafkaTemplatePost.send(POST2TOPIC,String.valueOf(post2.getId()),post2);

      logger.info("####################################"+input.getId().toString());
      logger.info("####################################"+input.getComments().toString());
      ArrayList<CreateCommentInput2> comments = input.getComments();
      comments.stream().forEach(e->{
          logger.info("#######################"+e.getDescription());
          logger.info("#######################"+e.getId());
      });
*/


      PostDifferentNamesMapping postMapper = Mappers.getMapper(PostDifferentNamesMapping.class);
      Post1 post1 = postMapper.post(input);

     // logger.info("##############################"+input.getSvensktext());
      logger.info("##############################"+input.getSvensktext());
      logger.info("#########################"+post1.getText());
      Post post = new Post(new Random().nextLong());
      return post;
  }

}
