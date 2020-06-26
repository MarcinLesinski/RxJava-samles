package flowable;

import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.numbers;

public class BufferSample
{
    public void one()
    {
        numbers("A", 12).buffer(3).subscribe(logSubscriber("dst"));
    }
}
