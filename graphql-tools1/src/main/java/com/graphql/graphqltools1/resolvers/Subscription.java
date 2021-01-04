package com.graphql.graphqltools1.resolvers;


import com.graphql.graphqltools1.engine.Producer;
import com.graphql.graphqltools1.models.User;
import com.graphql.graphqltools1.publishers.UserRxPublisher;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class Subscription implements GraphQLSubscriptionResolver {

    private UserRxPublisher userRxPublisher;

    Subscription(UserRxPublisher userCreatePublisher) {
        this.userRxPublisher = userCreatePublisher;
    }

    Publisher<User> userSub(String name) {

        return userRxPublisher.getPublisher();
    }

}
