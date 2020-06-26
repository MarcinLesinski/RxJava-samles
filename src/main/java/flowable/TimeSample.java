package flowable;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

import static flowable.LogSubscriber.logSubscriber;

public class TimeSample
{
    public void timer()
    {
        System.out.println("");
        System.out.println("timer");
        Flowable
                .timer(2, TimeUnit.SECONDS)
                .subscribe(logSubscriber("sub"));
    }

    public void delay()
    {
        System.out.println("");
        System.out.println("delay");
        Flowable
                .range(1, 5)
                .delay(1, TimeUnit.SECONDS)
                .doOnNext(System.out::println)
                .subscribe(logSubscriber("sub"));
    }

    public void interval()
    {
        System.out.println("");
        System.out.println("interval");
        Flowable
                .interval(0, 1, TimeUnit.SECONDS)
                .subscribe(logSubscriber("sub"));
    }
}
