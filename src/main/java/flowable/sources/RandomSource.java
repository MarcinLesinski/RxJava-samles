package flowable.sources;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomSource
{
    public static Flowable<Integer> get(Integer interval, Integer max)
    {
        Random random = new Random();
        return Flowable
                .interval(interval, TimeUnit.SECONDS)
                .map(i -> random.nextInt(max));
    }
}
