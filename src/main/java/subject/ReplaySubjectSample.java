package subject;

import io.reactivex.subjects.ReplaySubject;

import static observable.LogObserver.logObserver;

public class ReplaySubjectSample
{
    public void sample()
    {
        ReplaySubject<Object> source = ReplaySubject.create();

        source.subscribe(logObserver("dst"));

        source.onNext(1);
        source.onNext(2);
        source.onNext(3);

        source.subscribe(logObserver("dst2"));

        source.onNext(4);
        source.onNext(5);
        source.onNext(6);

        source.subscribe(logObserver("dst3"));

        source.onNext(7);
        source.onNext(8);
        source.onNext(9);


    }

}
