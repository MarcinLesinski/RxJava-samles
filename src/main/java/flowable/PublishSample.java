package flowable;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;

import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.numbers;

public class PublishSample
{
    public void s1()
    {
        Flowable<Integer> a = numbers("A", 10).publish().refCount();
//        a.subscribe(logSubscriber("dst"));

    }

}
