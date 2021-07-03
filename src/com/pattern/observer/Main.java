package com.pattern.observer;

import com.pattern.observer.model.Work;
import com.pattern.observer.publishers.CoursePublisher;
import com.pattern.observer.subscribers.StudentSubscriber;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
	    var work1 = new Work("Patterns Java", LocalDate.now().plusDays(10), 10);
        var work2 = new Work("Patterns Node", LocalDate.now().plusDays(15), 15);
        var work3 = new Work("Patterns Go", LocalDate.now().plusDays(20), 15);

        var modularityCourse = new CoursePublisher();
        var student1 = new StudentSubscriber<>("Student 1");
        var student2 = new StudentSubscriber<>("Student 2");

        modularityCourse.subscribe(student1);
        modularityCourse.subscribe(student2);
        System.out.println("NumberOfSubscribers: " + modularityCourse.getNumberOfSubscribers());

        modularityCourse.appendWork(work1);
        modularityCourse.appendWork(work2);
        modularityCourse.appendWork(work3);

        //Estudante que entrou na turma após a disponibilização de trabalhos
        //assim que se inscreve na turma, recebe a lista de atividades já criadas
        //e fica aguardando as próximas.
        var student3 = new StudentSubscriber<>("Student 3");
        modularityCourse.subscribe(student3);

        System.out.println("NumberOfSubscribers: " + modularityCourse.getNumberOfSubscribers());
    }
}
