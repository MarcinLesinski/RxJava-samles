package excercises;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.numbers;

public class DoSmthgWhen
{
    public void execute()
    {
        numbers("A", 5)
                .flatMap(new Function<Integer, Publisher<String>>()
                {
                    @Override
                    public Publisher<String> apply(Integer integer) throws Exception
                    {
                        if (integer == 3)
                            return Flowable.just("Three found");
                        else
                            return Flowable.never();
                    }
                })
                .subscribe(logSubscriber("dst"));
    }

    public void execute2()
    {
        Disposable nums = numbers("A", 5)
                .flatMapCompletable(i -> i == 3 ? CompletableObserver::onComplete : Completable.never())
                .subscribe();

    }

}
