import io.reactivex.*;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class E2 {
    public static void $do()
    {
        FlowableOnSubscribe<Integer> onSubscribe = new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception
            {
                for (int i = 0; i < 10; i++) {
                    System.out.println("generated: " + i);
                    emitter.onNext(i);
                }
                System.out.println("generated: completed");
                emitter.onComplete();
            }
        };

        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            Subscription sub;
            @Override
            public void onSubscribe(Subscription subscription)
            {
                sub = subscription;
                subscription.request(1);
                System.out.println("subscribe");
            }

            @Override
            public void onNext(Integer integer)
            {
                System.out.println(integer);
                sub.request(1);
            }

            @Override
            public void onError(Throwable throwable)
            {
                System.out.print("error");
            }

            @Override
            public void onComplete()
            {
                System.out.println("completed");
            }
        };

        Flowable<Integer> a = Flowable.create(onSubscribe, BackpressureStrategy.MISSING).subscribeOn(Schedulers.computation()).publish();
    }
}
