package jp.ogiwara.userservice.user.view;


import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import jp.ogiwara.cycle.Action;
import jp.ogiwara.cycle.Store;
import jp.ogiwara.userservice.user.view.action.Destroy;
import jp.ogiwara.userservice.user.view.action.Load;
import jp.ogiwara.uservicerepository.UServiceRepositoryImpl;

public class Dispatcher implements jp.ogiwara.cycle.Dispatcher<State>{

    private Disposable disposable;

    @Override
    public void dispatch(Store<State> store, Action action, Context context) {
        if(action instanceof Load){
            Load load = (Load) action;
            State state = store.getState();

            disposable = UServiceRepositoryImpl.instance
                    .getUser(load.getUuid())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((e) -> {
                        state.getAge().set(e.getAge());
                        state.getName().set(e.getName());
                        state.getLike().set(e.getLike());
                    });
        }
        if(action instanceof Destroy){
            if(disposable != null){
                disposable.dispose();
            }
        }
    }
}
