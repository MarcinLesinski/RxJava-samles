package flowable;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

import static flowable.sources.Sources.numbers;

public class DisposeSample
{
    public void dispose()
    {
        Disposable nums = numbers("A", 10)
                .subscribe(System.out::println);

        Completable
                .timer(3, TimeUnit.SECONDS)
                .subscribe(() -> nums.dispose());
    }

}
