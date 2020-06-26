package flowable;

import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.numbers;

public class MapSample
{
    public void map()
    {
        numbers("A", 10)
                .map(i -> i * 100)
                .subscribe(logSubscriber("dst"));
    }

}
