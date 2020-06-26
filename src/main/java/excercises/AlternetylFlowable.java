package excercises;

import flowable.LogSubscriber;

import static flowable.sources.Sources.numbers;

public class AlternetylFlowable
{
    public void execute()
    {
        numbers("A", 10)
                .mergeWith(numbers("B", 10))
                .subscribe(LogSubscriber.logSubscriber("dst"));
    }
}
