package flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.concurrent.TimeUnit;

import static flowable.sources.Sources.numbers;

public class DebounceSample
{
    public void debounce()
    {
        Flowable
                .interval(100, TimeUnit.MILLISECONDS)
                .takeWhile(l -> l != 5)
                .doOnNext(System.out::println)
                .debounce(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);

    }

}
