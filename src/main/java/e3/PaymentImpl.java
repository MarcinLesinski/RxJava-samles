package e3;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

public class PaymentImpl implements Payment
{
    @Override
    public Completable execute()
    {
        return Completable.create(new CompletableOnSubscribe()
        {
            @Override
            public void subscribe(CompletableEmitter completableEmitter) throws Exception
            {
                Thread.sleep(1500);
                completableEmitter.onComplete();
            }
        });
    }

    @Override
    public Completable confirmToUser()
    {
        return null;
    }
}
