package flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.numbers;

public class SwitchMapSample
{
    public void s1()
    {
//        numbers("A", 10)
//                .switchMap(integer -> Flowable.range(1, integer ))
//                .subscribe(logSubscriber("dst"));




        final List<String> items = Arrays.asList("a", "b", "c", "d", "e", "f", "z");

        Observable.fromIterable(items)
                .switchMap( s -> Observable.just(s + "x")
                        .delay(1, TimeUnit.SECONDS))
                .toList()
                .subscribe(System.out::println);


    }

}
