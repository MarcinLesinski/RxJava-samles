package e3;

import io.reactivex.Completable;

public interface Payment
{
    Completable execute();
    Completable confirmToUser();
}
