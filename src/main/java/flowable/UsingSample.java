package flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.numbers;

public class UsingSample
{
    public void using()
    {
        Flowable
                .using(() -> 8,
                        (Function<Integer, Publisher<?>>) integer -> Flowable.range(1, 5),
                        integer -> System.out.println("consumed " + integer))
                .subscribe(logSubscriber("dst"));

    }
}
