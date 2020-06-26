package excercises;

import flowable.LogSubscriber;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Chain1
{
    public void sample()
    {
        Completable.error(new NotImplementedException()) // geturl
                .andThen(Single.just(false)) // mam url loguje
                .flatMap(new Function<Boolean, SingleSource<String>>()
                {
                    @Override
                    public SingleSource<String> apply(Boolean aBoolean) throws Exception
                    {
                        System.out.println("wlazło");
                        if (aBoolean)
                            return Single.just("Zalogowano");
                        else
                            return Single.just("Nie zalogowano");
                    }
                })
                .onErrorReturn(new Function<Throwable, String>()
                {
                    @Override
                    public String apply(Throwable throwable) throws Exception
                    {
                        if (throwable instanceof NotImplementedException)
                            return "wuywaliło 1";
                        else
                            return "wywaliło 2";
                    }
                })
                .subscribe(new Consumer<String>()
                           {
                               @Override
                               public void accept(String o) throws Exception
                               {
                                   System.out.println(o);
                               }
                           }

                );
    }

}
