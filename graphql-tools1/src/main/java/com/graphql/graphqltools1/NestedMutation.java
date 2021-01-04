package com.graphql.graphqltools1;

import com.graphql.graphqltools1.models.Comment1;
import com.graphql.graphqltools1.models.Post1;
import com.graphql.graphqltools1.models.User;
//import com.graphql.graphqltools1.models.Post;
//import com.graphql.graphqltools1.models.Comment;
import com.graphql.graphqltools1.publishers.UserRxPublisher;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NestedMutation implements GraphQLMutationResolver {

    private static final Logger logger = LoggerFactory.getLogger(GraphQLMutationResolver.class);

    @Autowired
    private KafkaTemplate<String, com.graphql.graphqltools1.models.Post1> kafkaTemplatePost;

    @Autowired
    private KafkaTemplate<String, com.graphql.graphqltools1.models.Comment1> kafkaTemplateComment;

    private static final String POSTTOPIC = "avropost";
    private static final String COMMENTTOPIC = "avrocomment";

  public Post  createNestedPost(CreatePostInput input)
  {
     Post1 post1 = new Post1(input.getText(),new Random().nextLong());

      //kafkaTemplatePost.send(POSTTOPIC,String.valueOf(post1.getId()),post1);
      Comment1 comment = new Comment1(input.getComments().getDescription(),new Random().nextLong());

     // kafkaTemplateComment.send(COMMENTTOPIC,String.valueOf(comment.getId()),comment);
      logger.info("###################################"+input.getComments());

      Post post = new Post(new Random().nextLong());
      return post;
  }
   static class CreatePostInput{
        Long id;

        public Long getId() {
            return id;
        }

        public String getText() {
            return text;
        }



        public CreateCommentInput getComments() {
            return comments;
        }

        public void setComments(CreateCommentInput comments) {
            this.comments = comments;
        }

        String text;
      CreateCommentInput comments;

    }


    static class CreateCommentInput {
        Long id;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        String  description;
    }
}
