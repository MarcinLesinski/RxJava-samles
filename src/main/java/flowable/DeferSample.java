package flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import org.reactivestreams.Publisher;

import static flowable.LogSubscriber.logSubscriber;

public class DeferSample
{
    public void defer()
    {

        TestClass testClass = new TestClass();
        Flowable<Integer> flowableMadeByCreate = Flowable.create(testClass.flowable(), BackpressureStrategy.MISSING);
        testClass.setNumber(8);
        flowableMadeByCreate.subscribe(logSubscriber("A"));

        TestClass testClass2 = new TestClass();
        Flowable<Integer> flowableMAdeByDefer = Flowable.defer(testClass2::publisher);
        testClass2.setNumber(8);
        flowableMAdeByDefer.subscribe(logSubscriber("B"));
    }

}

class TestClass
{
    private int number = 0;

    public void setNumber(int value)
    {
        number = value;
    }

    public Publisher<Integer> publisher() throws Exception
    {
        return Flowable.just(number);
    }

    public FlowableOnSubscribe<Integer> flowable()
    {
        return flowableEmitter -> {
            flowableEmitter.onNext(number);
            flowableEmitter.onComplete();
        };
    }

}
