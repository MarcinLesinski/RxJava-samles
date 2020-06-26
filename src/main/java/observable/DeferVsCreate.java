package observable;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;

public class DeferVsCreate
{
    public void sample()
    {
        TestClass testClass = new TestClass();
        Observable<Integer> observableMadeByCreate = Observable.create(testClass.observable());
        testClass.setNumber(8);
        observableMadeByCreate.subscribe(System.out::println);

        TestClass testClass2 = new TestClass();
        Observable<Integer> observableMadeByDefer = Observable.defer(testClass2::observableSource);
        testClass2.setNumber(8);
        observableMadeByDefer.subscribe(System.out::println);
    }

}

class TestClass
{
    private int number = 0;

    public void setNumber(int value)
    {
        number = value;
    }

    public ObservableOnSubscribe<Integer> observable()
    {
        return (ObservableOnSubscribe<Integer>) Observable.just(number);
    }

    public ObservableSource<Integer> observableSource()
    {
        return observer -> {
            observer.onNext(number);
            observer.onComplete();
        };
    }

}