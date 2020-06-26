package observable;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LogObserver<T> implements Observer<T>
{
    private String name;
    private Disposable disposable;

    public static LogObserver logObserver(String name)
    {
        return new LogObserver(name);
    }

    public LogObserver(String name)
    {
        this.name = name;
    }

    @Override
    public void onSubscribe(Disposable disposable)
    {
        this.disposable = disposable;
        System.out.println(name + " Start");
    }

    @Override
    public void onNext(T t)
    {
        System.out.println(name + " <- " + t);
    }

    @Override
    public void onError(Throwable throwable)
    {
        System.out.println(name + " Error");
    }

    @Override
    public void onComplete()
    {
        System.out.println(name + " Finish");
    }

    public void dispose()
    {
        disposable.dispose();
    }
}
