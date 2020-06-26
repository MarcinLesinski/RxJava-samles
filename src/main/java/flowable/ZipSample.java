package flowable;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;

import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.chars;
import static flowable.sources.Sources.numbers;

public class ZipSample
{
    public void one()
    {
        Flowable
                .zip(
                        numbers("A", 5),
                        numbers("B", 5, 5),
                        Integer::sum)
                .delay(1, TimeUnit.SECONDS)
                .subscribe(logSubscriber("dst"));
    }

    public void two()
    {
        numbers("A", 10)
                .zipWith(numbers("B", 10), (a, b) -> a + b)
                .subscribe(logSubscriber("dst"));
    }

    public void three()
    {
        numbers("A", 5)
                .zipWith(chars("B", 5), (n, c) -> c)
                .subscribe(logSubscriber("dst"));
    }


}
