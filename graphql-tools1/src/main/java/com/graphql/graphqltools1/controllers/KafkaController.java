package com.graphql.graphqltools1.controllers;


import com.graphql.graphqltools1.engine.Producer;
import com.graphql.graphqltools1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

   /* @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("id") String id, @RequestParam("text") String text) {
        this.producer.sendMessage(new Post);
    }
*/

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        this.producer.sendMessage(new User(name, age));
    }
}