package jp.ogiwara.userservice.base;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.function.Function;

import jp.ogiwara.cycle.Action;
import jp.ogiwara.cycle.Store;
import jp.ogiwara.userservice.App;
import jp.ogiwara.userservice.R;
import jp.ogiwara.userservice.base.action.Load;
import jp.ogiwara.userservice.databinding.ActivityMainBinding;

//user一覧を表示
public class MainActivity extends AppCompatActivity {

    private Store<State> store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        store = new Store<>(new State(), new Dispatcher(), getApplicationContext());

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setStore(store);

        Action action = new Load((App) getApplication());

        store.dispatch(action);
    }
}
