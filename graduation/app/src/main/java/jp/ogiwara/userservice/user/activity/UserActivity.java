package jp.ogiwara.userservice.user.activity;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import jp.ogiwara.cycle.Store;
import jp.ogiwara.userservice.App;
import jp.ogiwara.userservice.R;
import jp.ogiwara.userservice.databinding.ActivityUserBinding;
import jp.ogiwara.userservice.user.activity.action.Destroy;
import jp.ogiwara.userservice.user.activity.action.Load;
import jp.ogiwara.userservice.user.activity.action.Touch;

public class UserActivity extends AppCompatActivity implements View.OnClickListener{

    public enum Extra{
        UUID("uuid");

        private String name;

        Extra(String name) {
            this.name = name;
        }
    }

    private int uuid;
    private Store<State> store;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        if(savedInstanceState != null){
            uuid = savedInstanceState.getInt(Extra.UUID.name());
        }else{
            Intent intent = getIntent();
            uuid = intent.getIntExtra(Extra.UUID.name() ,0);
        }
        store = new Store<>(new State(),new Dispatcher(), getApplicationContext());

        ActivityUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user);
        binding.setHandler(this);
        binding.setStore(store);

        store.dispatch(new Load(uuid, (App) getApplication()));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(Extra.UUID.name(),uuid);
    }

    @Override
    public void onClick(View view) {
        store.dispatch(new Touch((App) getApplication(), uuid));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        store.dispatch(new Destroy());
    }
}
