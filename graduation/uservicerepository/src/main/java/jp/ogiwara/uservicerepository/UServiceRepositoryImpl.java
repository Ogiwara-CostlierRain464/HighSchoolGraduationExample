package jp.ogiwara.uservicerepository;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.realm.Realm;
import io.realm.RealmResults;
import jp.ogiwara.userviceremote.UServiceAPI;
import jp.ogiwara.userviceremote.model.User;

public class UServiceRepositoryImpl implements UServiceRepository{

    private UServiceAPI api = UServiceAPI.create();

    private UServiceRepositoryImpl(){}

    public static UServiceRepository instance = new UServiceRepositoryImpl();

    @Override
    public Flowable<User> getUser(int uuid) throws IndexOutOfBoundsException {
        //means no cache
        //pull
        User user = api.getUser(uuid);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        User result = realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();

        //push
        return result.asFlowable();

    }

    private void reFresh(){

    }

    @Override
    public List<Integer> getUserUuids() {
        return api.getUserUuids();
    }

    @Override
    public void postLike(int uuid) throws IndexOutOfBoundsException {
        api.postLike(uuid);
    }
}
