package com.graphql.graphqltools1.publishers;


import com.graphql.graphqltools1.models.User;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.observables.ConnectableObservable;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserRxPublisher {

    private static final Logger LOG = LoggerFactory.getLogger(UserRxPublisher.class);

    private final Flowable<User> publisher;
    private final  Observable<User> userUpdateObservable;
    private  ObservableEmitter<User> userEmitter;

    public UserRxPublisher() {


        userUpdateObservable = Observable.create(emitter -> {
            userEmitter =emitter;

        });

        ConnectableObservable<User> connectableObservable = userUpdateObservable.share().publish();
        connectableObservable.connect();

        publisher = connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }


    private void emitUser(ObservableEmitter<User> emitter,User usr) {

        try {
                emitter.onNext(usr);


            } catch (RuntimeException e) {
                LOG.error("Cannot send StockUpdate", e);
        }
    }

    public Flowable<User> getPublisher() {
        return publisher;
    }

    private void onEvent(ConsumerRecord<String, User> record)
    {
        LOG.info(String.format("#### -> Consumed2 form RX message onEvent -> %s", record.value()));

            emitUser(userEmitter,record.value());


    }
    @KafkaListener(topics = "avrousers3", groupId = "group_id3")
    public String consume1(ConsumerRecord<String, User> record) throws IOException {
        LOG.info(String.format("#### -> Consumed2 form RX message -> %s", record.value()));
        onEvent(record);
        return record.value().getName();
    }

  /*  @KafkaListener(topics = "avrousers2", groupId = "group_id2")
    public String consume2(ConsumerRecord<String, User> record) throws IOException {
        LOG.info(String.format("#### -> Consumed2 form RX message -> %s", record.value()));
        //onEvent(record);
        return record.value().getName();
    }*/
}
