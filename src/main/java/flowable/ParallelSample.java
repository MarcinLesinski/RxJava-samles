package flowable;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import static flowable.LogSubscriber.logSubscriber;

public class ParallelSample
{
    public void one()
    {
        Flowable
                .range(1, 10)
                .parallel()
                .runOn(Schedulers.io())
                .sequential()
                .subscribe(logSubscriber("dst"));
    }
}
