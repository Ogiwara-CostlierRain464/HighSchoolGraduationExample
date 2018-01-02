package jp.ogiwara.userviceremote;


import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.annotations.NonNull;
import jp.ogiwara.userviceremote.model.User;

public class UServiceMockServerImpl implements UServiceMockServer{

    private static final List<User> users = Arrays.asList(
            User.apply("ogiwara",18,1),
            User.apply("taro",31,320),
            User.apply("mike",12,-5)
    );

    @NonNull
    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public List<Integer> getUserUuids() {
        return users.stream().map(User::getUuid).collect(Collectors.toList());
    }

    @NonNull
    @Override
    public User getUser(int uuid) throws IndexOutOfBoundsException {
        User result = users.get(uuid);
        if(result == null){
            throw new IndexOutOfBoundsException();
        }
        return result;
    }
}
