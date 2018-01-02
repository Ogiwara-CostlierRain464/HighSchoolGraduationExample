package jp.ogiwara.userviceapi;

import java.util.List;

import io.reactivex.annotations.NonNull;
import jp.ogiwara.userviceapi.model.User;

public class UServerAPIImpl implements UServiceAPI{

    private UServiceMockServer server = new UServerMockServerImpl();

    @NonNull
    @Override
    public List<User> getUsers() {
        return server.getUsers();
    }

    @NonNull
    @Override
    public User getUser(int uuid) throws IndexOutOfBoundsException{
        return server.getUser(uuid);
    }

    @NonNull
    @Override
    public void postLike(int uuid) throws IndexOutOfBoundsException{
        getUser(uuid).addLike();
    }
}
