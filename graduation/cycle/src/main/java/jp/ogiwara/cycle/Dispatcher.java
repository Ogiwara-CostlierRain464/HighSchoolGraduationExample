package jp.ogiwara.cycle;

import android.content.Context;

public interface Dispatcher<S extends State>{
    void dispatch(Store<S> store, Action action, Context context);
}
