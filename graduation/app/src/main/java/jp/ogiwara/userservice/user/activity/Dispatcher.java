package jp.ogiwara.userservice.user.activity;


import android.content.Context;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import jp.ogiwara.cycle.Action;
import jp.ogiwara.cycle.Store;
import jp.ogiwara.userservice.user.activity.action.Destroy;
import jp.ogiwara.userservice.user.activity.action.Load;
import jp.ogiwara.userservice.user.activity.action.Touch;

public class Dispatcher implements jp.ogiwara.cycle.Dispatcher<State>{

    private Disposable disposable;

    @Override
    public void dispatch(Store<State> store, Action action, Context context) {
        if(action instanceof Load){
            Load load = (Load) action;
            State state = store.getState();
            disposable = load.getApp().getRepository()
                    .getUser(load.getUuid())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(e -> {
                        state.getName().set(e.getName());
                        state.getLike().set(e.getLike());
                    });
        }
        if(action instanceof Touch){
            Touch touch = (Touch) action;
            touch.getApp().getRepository().postLike(touch.getUuid());
        }
        if(action instanceof Destroy){
            if(disposable != null){
                disposable.dispose();
            }
        }
    }
}
