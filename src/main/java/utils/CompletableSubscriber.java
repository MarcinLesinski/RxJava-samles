package utils;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;

public class CompletableSubscriber implements CompletableObserver
{
    private final String name;

    public CompletableSubscriber(String name)
    {
        this.name = name;
    }

    @Override
    public void onSubscribe(Disposable disposable)
    {
        System.out.println(name + " Start" + "  (completable)");
    }

    @Override
    public void onComplete()
    {
        System.out.println(name + " Finish" + "  (completable)");
    }

    @Override
    public void onError(Throwable throwable)
    {
        System.out.println(name + " Error" + "  (completable)");
    }
}
