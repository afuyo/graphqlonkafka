package com.graphql.graphqltools1.engine;

import com.graphql.graphqltools1.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "avrousers3";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

 /*   public void sendMessage(Post post) {
        logger.info(String.format("#### -> Producing message -> %s", post.getId().toString()));
        this.kafkaTemplate.send(TOPIC, post.getId().toString(),post);

    }*/

   public void sendMessage(User user) {
        this.kafkaTemplate.send(this.TOPIC, user.getName(), user);
        logger.info(String.format("Produced user -> %s", user));
    }
}
