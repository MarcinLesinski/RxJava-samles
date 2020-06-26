package flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import observable.LogObserver;
import org.reactivestreams.Publisher;


import static flowable.LogSubscriber.logSubscriber;
import static flowable.sources.Sources.numbers;

public class GroupBySample
{
    public void s1()
    {
        Observable
            .range(1, 10)
            .groupBy(i -> i%2==0)
                .flatMap(new Function<GroupedObservable<Boolean, Integer>, ObservableSource<?>>()
                {
                    @Override
                    public ObservableSource<?> apply(GroupedObservable<Boolean, Integer> group) throws Exception
                    {
                        if (group.getKey())
                            return group.map(i -> "odd : " + i);
                        else
                            return group.map(i -> "even: " + i);
                    }
                })
                .forEach(System.out::println);
//            .subscribe(System.out::println);

//        numbers()
//                .groupBy(i -> i%2==0)
//                .flatMap(new Function<GroupedFlowable<Boolean, Integer>, Publisher<?>>()
//                {
//                    @Override
//                    public Publisher<?> apply(GroupedFlowable<Boolean, Integer> booleanIntegerGroupedFlowable) throws Exception
//                    {
//                        return
//                    }
//                })
//                .forEach(System.out::println);
//                .subscribe(logSubscriber("dst"));
    }
    
}
