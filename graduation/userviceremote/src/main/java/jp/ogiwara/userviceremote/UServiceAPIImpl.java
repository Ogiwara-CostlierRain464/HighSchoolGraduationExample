package jp.ogiwara.userviceremote;


import java.util.List;
import java.util.function.Function;

import io.reactivex.annotations.NonNull;
import jp.ogiwara.userviceremote.model.User;

public class UServiceAPIImpl implements UServiceAPI{

    private UServiceMockServer server = UServiceMockServer.create();

    @NonNull
    @Override
    public List<User> getUsers() {
        return server.getUsers();
    }

    @Override
    public List<Integer> getUserUuids() {
        return server.getUserUuids();
    }

    @NonNull
    @Override
    public User getUser(int uuid) throws IndexOutOfBoundsException {
        return server.getUser(uuid);
    }

    @NonNull
    @Override
    public void postLike(int uuid) throws IndexOutOfBoundsException {
        getUser(uuid).addLike();
    }
}
