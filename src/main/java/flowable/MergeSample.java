package flowable;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class MergeSample
{
    void one()
    {
        System.out.println("Parallel");
        Flowable<Integer> a = Flowable
                .range(1, 10)
                .doOnNext(integer -> System.out.println("a: " + integer))
                .doOnComplete(() -> System.out.println("a finished"))
                .subscribeOn(Schedulers.computation());

        Flowable<Integer> b = Flowable
                .range(1, 10)
                .doOnNext(integer -> System.out.println("b: " + integer))
                .doOnComplete(() -> System.out.println("b finished"))
                .subscribeOn(Schedulers.computation());

        Flowable<Integer> c = Flowable
                .range(1, 10)
                .doOnNext(integer -> System.out.println("c: " + integer))
                .doOnComplete(() -> System.out.println("c finished"))
                .subscribeOn(Schedulers.computation());

        List<Completable> abc = new ArrayList<>();
        abc.add(a.ignoreElements());
        abc.add(b.ignoreElements());
        abc.add(c.ignoreElements());
        Completable.merge(abc).doOnComplete(() -> System.out.println("all finished")).blockingAwait();
    }
}
