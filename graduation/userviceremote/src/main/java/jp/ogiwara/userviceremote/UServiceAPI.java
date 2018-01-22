package jp.ogiwara.userviceremote;

import android.support.annotation.NonNull;

import java.util.List;

import jp.ogiwara.userviceremote.model.User;

public interface UServiceAPI {
    List<User> getUsers();
    List<Integer> getUserUuids();
    User getUser(int uuid) throws IndexOutOfBoundsException;
    void postLike(int uuid) throws IndexOutOfBoundsException;

    @NonNull
    static UServiceAPI create(){
        return new UServiceAPIImpl();
    }
}