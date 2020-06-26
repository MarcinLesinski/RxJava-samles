package excercises;

import flowable.sources.RandomSource;
import io.reactivex.*;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

import java.util.concurrent.TimeUnit;

import static flowable.LogSubscriber.logSubscriber;
import static observable.LogObserver.logObserver;

public class MostReliableSource
{
    public void execute()
    {
//        Flowable<Integer> source1 = RandomSource.get(1, 5);
//        Flowable source2 = RandomSource.get(2, 50);
//        Flowable source3 = RandomSource.get(3, 500);

//        source1.scan()

        Flowable<Sample> s1 = new Detector("s1", 1, 1000).get();
        Flowable<Sample> s2 = new Detector("s2", 2, 100).get();
        Flowable<Sample> s3 = new Detector("s3", 5, 10).get();

        Flowable
                .merge(s1, s2, s3)
                .subscribe(System.out::println);

//        ReplaySubject<Integer> subject = ReplaySubject.create();
//        source1.subscribe();

//        source1.scan((BiFunction) (o, o2) -> {
//            return o +o2;
//        }).subscribe(logSubscriber("dst"));

//        Flowable
//                .concat(source1, source2, source3)
//                .subscribe(System.out::println);



    }

}
