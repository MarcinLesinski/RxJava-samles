package maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

public class BasicSample
{
    public void sample()
    {
        Maybe<String> scanner = Maybe.create(new MaybeOnSubscribe<String>()
        {
            @Override
            public void subscribe(MaybeEmitter<String> maybeEmitter) throws Exception
            {
                maybeEmitter.onSuccess("result");
                maybeEmitter.onComplete();
            }
        });

        scanner
                .doOnSuccess(new Consumer<String>()
                {
                    @Override
                    public void accept(String s) throws Exception
                    {
                        System.out.println("success: " + s);
                    }
                })
                .doOnComplete(new Action()
                {
                    @Override
                    public void run() throws Exception
                    {
                        System.out.println("complete");
                    }
                })
                .doOnError(new Consumer<Throwable>()
                {
                    @Override
                    public void accept(Throwable throwable) throws Exception
                    {
                        System.out.println("error");
                    }
                })
                .doOnEvent(new BiConsumer<String, Throwable>()
                {
                    @Override
                    public void accept(String s, Throwable throwable) throws Exception
                    {
                        System.out.println("event: " + s);
                    }
                })
                .doOnTerminate(new Action()
                {
                    @Override
                    public void run() throws Exception
                    {
                        System.out.println("terminate");
                    }
                })
                .doOnSubscribe(new Consumer<Disposable>()
                {
                    @Override
                    public void accept(Disposable disposable) throws Exception
                    {
                        System.out.println("subscribe");
                    }
                })
                .doOnDispose(new Action()
                {
                    @Override
                    public void run() throws Exception
                    {
                        System.out.println("dispose");
                    }
                })
                .subscribe();
    }

}
