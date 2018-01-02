package jp.ogiwara.uservicerepository;

import android.support.annotation.NonNull;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.realm.Realm;
import jp.ogiwara.userviceremote.model.User;

public interface UServiceRepository {

    Flowable<User> getUser(int uuid) throws IndexOutOfBoundsException;
    List<Integer> getUserUuids();

    void postLike(int uuid) throws IndexOutOfBoundsException;
}
