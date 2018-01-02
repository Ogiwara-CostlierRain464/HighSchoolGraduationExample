package jp.ogiwara.userservice.base;


import android.content.Context;
import android.databinding.ObservableArrayList;

import java.util.List;

import jp.ogiwara.cycle.Action;
import jp.ogiwara.cycle.Store;
import jp.ogiwara.userservice.base.action.Load;

public class Dispatcher implements jp.ogiwara.cycle.Dispatcher<State> {

    @Override
    public void dispatch(Store<State> store, Action action, Context context) {
        if(action instanceof Load){
            Load load = (Load) action;

            List list = load.getApp().getRepository().getUserUuids();
            store.getState().getList().addAll(list);
        }
    }
}
