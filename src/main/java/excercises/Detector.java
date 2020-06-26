package excercises;

import flowable.sources.RandomSource;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import lombok.ToString;
import org.apache.commons.collections4.queue.CircularFifoQueue;


public class Detector
{


    private final String name;
    CircularFifoQueue<Integer> diffsBuffered;
    Flowable<Integer> source;

    public Detector(String name, Integer interval, Integer randomSeed)
    {
        this.name = name;
        diffsBuffered = new CircularFifoQueue<>(3);
        source = RandomSource.get(interval, randomSeed);
    }

    public Flowable<Sample> get()
    {
        return source
                .scan((previous, current) ->
                {
                    diffsBuffered.add(Math.abs(previous - current));
                    return current;
                })
                .map(value -> new Sample(name, value, 1 /* power(diffsBuffered)*/ ));
    }

    private Integer power(CircularFifoQueue<Integer> diffsBuffered)
    {
        return diffsBuffered.stream().reduce((previous, current) -> previous + current).get();
    }
}


@ToString
class Sample
{
    public String detectorName;
    public Integer value;
    public Integer power;

    public Sample(String detectorName, Integer value, Integer power)
    {
        this.detectorName = detectorName;
        this.value = value;
        this.power = power;
    }
}