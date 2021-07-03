package com.pattern.observer.publishers;

import com.pattern.observer.model.Work;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

public class CoursePublisher implements Flow.Publisher<Work> {

    private final List<Work> works;
    private CopyOnWriteArrayList<Subscriber<? super Work>> subscribers;

    public CoursePublisher() {
        this.works = new ArrayList<>();
        this.subscribers = new CopyOnWriteArrayList<>();
    }

    @Override
    public void subscribe(Subscriber<? super Work> subscriber) {
        this.works.forEach(subscriber::onNext);
        subscriber.onComplete();
        this.subscribers.add(subscriber);
    }

    public void appendWork(Work work){
        this.works.add(work);
        this.subscribers.forEach(subscriber -> subscriber.onNext(work));
    }

    public int getNumberOfSubscribers(){
        return this.subscribers.size();
    }

}
