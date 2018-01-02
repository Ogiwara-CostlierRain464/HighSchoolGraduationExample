package jp.ogiwara.userviceapi;

import java.util.Arrays;
import java.util.List;

import io.reactivex.annotations.NonNull;
import jp.ogiwara.userviceapi.model.User;

class UServerMockServerImpl implements UServiceMockServer{
    private static final List<User> users = Arrays.asList(
            new User("ogiwara",18,1),
            new User("taro",31,320),
            new User("mike",12,-5)
    );

    @NonNull
    @Override
    public List<User> getUsers() {
        return users;
    }

    @NonNull
    @Override
    public User getUser(int uuid) throws IndexOutOfBoundsException{
        User result = users.get(uuid);
        if(result == null){
            throw new IndexOutOfBoundsException();
        }
        return result;
    }
}
