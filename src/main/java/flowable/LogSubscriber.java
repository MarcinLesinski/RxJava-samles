package flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class LogSubscriber<T> implements Subscriber<T>
{
    private final String name;
    private Subscription subscription;

    public LogSubscriber(String name)
    {
        this.name = name;
    }

    public static LogSubscriber logSubscriber(String name)
    {
        return new LogSubscriber(name);
    }

    @Override
    public void onSubscribe(Subscription subscription)
    {
        this.subscription = subscription;
        subscription.request(1);
        System.out.println(name + " Start");
    }

    @Override
    public void onNext(T value)
    {
        this.subscription.request(1);
        System.out.println(name + " <- " + value);
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
}
