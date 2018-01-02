package jp.ogiwara.userviceapi;

import java.util.List;

import jp.ogiwara.userviceapi.model.User;

public interface UServiceAPI {
    List<User> getUsers();
    User getUser(int uuid) throws IndexOutOfBoundsException;
    void postLike(int uuid) throws IndexOutOfBoundsException;

    default UServiceAPI create(){
        return new UServerAPIImpl();
    }
}
