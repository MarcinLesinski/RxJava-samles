package flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import javafx.scene.control.SeparatorMenuItem;

import java.util.concurrent.Callable;

import static flowable.LogSubscriber.logSubscriber;

public class GenerateSample
{
    public void sample()
    {
        Flowable
                .generate(new Callable<Integer>()
                {
                    @Override
                    public Integer call() throws Exception
                    {
                        return 1;
                    }
                }, new BiFunction<Integer, Emitter<Object>, Integer>()
                {
                    @Override
                    public Integer apply(Integer a, Emitter<Object> emitter) throws Exception
                    {
                        Integer nextValue = ++a;
                        emitter.onNext(nextValue);
                        if (a == 10)
                            emitter.onComplete();
                        return nextValue;
                    }
                })
                .subscribe(logSubscriber("dst"));
    }

    public void sample2()
    {
        Flowable
                .generate(() -> 1, (a, emitter) -> {
                    Integer nextValue = ++a;
                    emitter.onNext(nextValue);
                    if (a == 10)
                        emitter.onComplete();
                    return nextValue;
                })
                .subscribe(logSubscriber("dst"));
    }
}
