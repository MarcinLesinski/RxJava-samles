package flowable;

import static flowable.sources.Sources.numbers;

public class BasicSample
{
    public void demo()
    {
        numbers("src", 10)
                .subscribe(new LogSubscriber("dst"));
    }

}
