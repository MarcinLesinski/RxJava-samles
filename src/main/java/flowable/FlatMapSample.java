package flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.numbers;

public class FlatMapSample
{
    public void s1()
    {
        numbers("A", 10)
                .flatMap(i -> Flowable.just("A", "B", "C"))
                .subscribe(logSubscriber("dst"));
    }

    public void s2()
    {
        numbers("B", 5)
                .flatMap(new Function<Integer, Publisher<?>>()
                {
                    @Override
                    public Publisher<?> apply(Integer integer) throws Exception
                    {
                        if (integer == 3)
                            numbers("B", 10)
                                    .subscribe(logSubscriber("-----------------dst2"));
                        return Flowable.just(integer);
                    }
                })
                .subscribe(logSubscriber("dst"));
    }

}
