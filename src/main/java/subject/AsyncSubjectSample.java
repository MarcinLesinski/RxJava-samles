package subject;

import io.reactivex.Completable;
import io.reactivex.subjects.AsyncSubject;

import java.util.concurrent.TimeUnit;

import static observable.LogObserver.logObserver;

public class AsyncSubjectSample
{
    public void sample()
    {
        AsyncSubject<Object> source = AsyncSubject.create();

        source.subscribe(logObserver("dst"));
        source.onNext(1);
        source.onNext(2);
        source.onNext(3);

//        dst.dispose();
        source.subscribe(logObserver("dst2"));
        source.onNext(4);
        source.onNext(5);
        source.onNext(6);


        source.subscribe(logObserver("dst3"));
        source.onNext(7);
        source.onNext(8);
        source.onNext(9);

        Completable
                .timer(10, TimeUnit.SECONDS)
                .subscribe(() -> source.onComplete());
    }


}
