package subject;

import io.reactivex.subjects.BehaviorSubject;

import static observable.LogObserver.logObserver;

public class BehaviorSubjectSample
{
    public void sample()
    {
        BehaviorSubject<Object> source = BehaviorSubject.create();

        source.subscribe(logObserver("dst"));
        source.onNext(1);
        source.onNext(2);
        source.onNext(3);

        source.subscribe(logObserver("dst2"));
        source.onNext(4);
        source.onNext(5);
        source.onNext(6);

        source.subscribe(logObserver("dst3"));




    }
}
