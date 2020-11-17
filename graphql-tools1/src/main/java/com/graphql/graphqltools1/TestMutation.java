package com.graphql.graphqltools1;

import com.graphql.graphqltools1.engine.Producer;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TestMutation implements GraphQLMutationResolver {

    private static final Logger logger = LoggerFactory.getLogger(TestMutation.class);
    private static final String TOPIC = "users1";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Post createPost1(String text){
        Post post = new Post(new Random().nextLong());
        logger.info(String.format("#### -> Producing  graphql message -> %s with id %s", text,post.getId().toString()));

        post.setText(text);

        this.kafkaTemplate.send(TOPIC, post.getId().toString(),post.getText());


        return post;
    }
}
