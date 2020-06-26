package errors;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import utils.CompletableSubscriber;

import javax.sound.sampled.LineUnavailableException;
import java.nio.file.NotLinkException;

public class ErrorsHandling
{

    public void sample1()
    {
        Completable
                .error(new NotLinkException("pierwszy"))
                .doOnError(new Consumer<Throwable>()
                {
                    @Override
                    public void accept(Throwable throwable) throws Exception
                    {
                        LineUnavailableException lineUnavailableException = new LineUnavailableException("drugi");
                        lineUnavailableException.initCause(throwable);
                        throw lineUnavailableException;
                    }
                })
                .subscribe(new Action()
                           {
                               @Override
                               public void run() throws Exception
                               {
                                   System.out.println("koniec");
                               }
                           },
                        new Consumer<Throwable>()
                        {
                            @Override
                            public void accept(Throwable throwable) throws Exception
                            {
                                System.out.println(throwable.getMessage());
                            }
                        });


    }
}
