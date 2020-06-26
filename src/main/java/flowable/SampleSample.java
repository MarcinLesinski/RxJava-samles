package flowable;

import java.util.concurrent.TimeUnit;

import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.numbers;

public class SampleSample
{
    public void sample()
    {
        numbers("A", 10, 1)
                .sample(3, TimeUnit.SECONDS)
                .subscribe(logSubscriber("dst"));

    }

}
