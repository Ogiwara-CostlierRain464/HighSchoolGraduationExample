package jp.ogiwara.cycle;

import android.content.Context;

public class Store<S extends State>{

    private S state;
    private Dispatcher<S> dispatcher;
    private Context context;

    public Store(S state, Dispatcher<S> dispatcher, Context context){
        this.state = state;
        this.dispatcher = dispatcher;
        this.context = context;
    }

    public void dispatch(Action action){
        dispatcher.dispatch(this,action,context);
    }

    public S getState(){
        return state;
    }
}
