package subject;

import io.reactivex.subjects.PublishSubject;
import observable.LogObserver;

import static observable.LogObserver.logObserver;

public class PublishSubjectSample
{

    public void sample()
    {
        PublishSubject<Integer> source = PublishSubject.create();
        LogObserver dst = logObserver("dst");

        source.subscribe(dst);
        source.onNext(1);
        source.onNext(2);
        source.onNext(3);

//        dst.dispose();
        source.subscribe(logObserver("dst2"));
        source.onNext(4);
        source.onNext(5);
        source.onNext(6);

        source.onComplete();

        source.subscribe(logObserver("dst3"));
        source.onNext(7);
        source.onNext(8);
        source.onNext(9);

    }

}
