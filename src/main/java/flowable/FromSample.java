package flowable;

import io.reactivex.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.IntStream;

import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.numbers;

public class FromSample
{
    public void fromArray()
    {
        Flowable
                .fromArray(new Integer[]{1, 2, 3, 4})
                .subscribe(logSubscriber("dst"));
    }

    public void fromIterable()
    {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Flowable
                .fromIterable(list)
                .subscribe(logSubscriber("dst2"));
    }

    public void fromCallable()
    {
        Flowable
                .fromCallable(() -> 1)
                .subscribe(logSubscriber("dst3"));
    }

    public void fromPublisher()
    {
       Publisher<Integer> publisher = subscriber ->
       {
            subscriber.onSubscribe(new Subscription()
            {
                @Override
                public void request(long l)
                {
                    IntStream.rangeClosed(1, 10).forEach(subscriber::onNext);
                }

                @Override
                public void cancel()
                {

                }
            });
            subscriber.onComplete();
        };

        Flowable
                .fromPublisher(publisher)
                .subscribe(logSubscriber("dst4"));
    }

    public void fromFuture()
    {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(3000);
            return 8;
        });

        Flowable
                .fromFuture(future)
                .subscribe(logSubscriber("dst5"));
    }
}
