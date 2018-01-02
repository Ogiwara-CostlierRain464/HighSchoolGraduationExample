package jp.ogiwara.userservice;


import android.app.Application;

import io.realm.Realm;
import jp.ogiwara.uservicerepository.UServiceRepository;
import jp.ogiwara.uservicerepository.UServiceRepositoryImpl;

public class App extends Application{

    private UServiceRepository repository = UServiceRepositoryImpl.instance;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
    }

    public UServiceRepository getRepository() {
        return repository;
    }
}
