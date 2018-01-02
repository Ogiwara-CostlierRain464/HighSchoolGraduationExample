package jp.ogiwara.userviceapi;

import java.util.Arrays;
import java.util.List;

import jp.ogiwara.userviceapi.model.User;

//User modelを発信するモックサーバー
interface UServiceMockServer {
    List<User> getUsers();
    User getUser(int uuid) throws IndexOutOfBoundsException;

    default UServiceMockServer create(){
        return new UServerMockServerImpl();
    }
}
