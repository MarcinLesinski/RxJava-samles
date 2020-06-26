package excercises;

import io.reactivex.*;

public class Chain2
{
    Object obj = new Object();

    public void sample()
    {
        Completable
                .create(new CompletableOnSubscribe()
                {
                    @Override
                    public void subscribe(CompletableEmitter completableEmitter) throws Exception
                    {
                        obj = new Object();
                        completableEmitter.onComplete();
                    }
                })
                .andThen(new ObservableSource<Object>()
                {
                    @Override
                    public void subscribe(Observer<? super Object> observer)
                    {
                        System.out.println(obj.toString());
                    }
                })
                .subscribe();
    }

}
