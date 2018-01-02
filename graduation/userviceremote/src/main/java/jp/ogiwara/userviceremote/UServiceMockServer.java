package jp.ogiwara.userviceremote;


import android.support.annotation.NonNull;

import java.util.List;

import jp.ogiwara.userviceremote.model.User;

public interface UServiceMockServer {
    List<User> getUsers();
    List<Integer> getUserUuids();
    User getUser(int uuid) throws IndexOutOfBoundsException;

    @NonNull
    static UServiceMockServer create(){
        return new UServiceMockServerImpl();
    }
}
