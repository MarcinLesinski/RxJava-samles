package flowable;

import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.numbers;

public class ConcatSample
{
    public void one()
    {
        numbers("A", 5).concatWith(numbers("B", 15)).subscribe(logSubscriber("dst"));
    }
}
