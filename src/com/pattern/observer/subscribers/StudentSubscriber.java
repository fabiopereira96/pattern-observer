package com.pattern.observer.subscribers;

import com.pattern.observer.model.Work;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Flow;

public class StudentSubscriber<WORK extends Work> implements Flow.Subscriber<WORK> {

    private final String name;
    public List<Work> pendingWorks = new LinkedList<>();

    public StudentSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {}

    @Override
    public void onNext(Work work) {
        System.out.println("Hi " + name);
        System.out.println("New work available: " + work);
        pendingWorks.add(work);
        System.out.println("Total pending works: " + pendingWorks.size());
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println(this.name + " - Waiting for new Works!");
    }
}
