package flowable.sources;

import io.reactivex.Flowable;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Sources
{
    static public Flowable<Integer> numbers()
    {
        return numbers("src", 10);
    }

    static  public Flowable<Integer> numbers(String name, Integer to, long interval)
    {
        return Flowable
                .interval(interval, TimeUnit.SECONDS)
                .limit(to)
                .map(Long::intValue)
                .doOnNext(i -> System.out.println(name + " -> " + i));
    }

    static  public Flowable<Integer> numbers(String name, Integer to)
    {
        return numbers(name, to, 1);
    }

    static public Flowable<String> chars(String name, Integer count)
    {
        String[] chars = IntStream.rangeClosed('A', 'Z').limit(count).mapToObj(i -> Character.toString((char)i)).toArray(String[]::new);
        return Flowable
                .interval(1, TimeUnit.SECONDS)
                .map(n -> Character.toString((char) (n + 97)))
                .doOnNext(ch -> System.out.println(name + " -> " + ch));
    }
}
