package com.graphql.graphqltools1;

import com.graphql.graphqltools1.models.User;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Mutation implements GraphQLMutationResolver {

 public Post createPost(String text){
    Post post = new Post(new Random().nextLong());
    post.setText(text);
    return post;
  }
  private static final String TOPIC = "avrousers3";

  @Autowired
  private KafkaTemplate<String, User> kafkaTemplate;

  @Autowired
  private KafkaTemplate<String, User> kafkaTemplate2;

  public User createUser(String message) {
    User user = new User(message,33);
    this.kafkaTemplate.send(this.TOPIC, user.getName(), user);
    //  this.kafkaTemplate2.send(this.TOPIC2, user.getName(), user);

    return user;
  }

  /*public User createUser(User user) {

    this.kafkaTemplate.send(this.TOPIC, user.getName(), user);
    //  this.kafkaTemplate2.send(this.TOPIC2, user.getName(), user);

    return user;
  }*/

   /*public User createObject(Object user) {

    this.kafkaTemplate.send('InsuredObject', user.getName(), user);
    //  this.kafkaTemplate2.send(this.TOPIC2, user.getName(), user);

    return user;
  }*/
}
