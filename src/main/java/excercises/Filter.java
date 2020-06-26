package excercises;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class Filter
{

    public Subject<Integer> get()
    {
        PublishSubject<Integer> subject = PublishSubject.create();
        Observable
                .range(1, 10)
                .subscribe(subject);

        subject.subscribe(System.out::println);








        return subject;
    }

}
