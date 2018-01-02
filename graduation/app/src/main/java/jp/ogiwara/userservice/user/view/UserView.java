package jp.ogiwara.userservice.user.view;


import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import jp.ogiwara.cycle.Store;
import jp.ogiwara.userservice.R;
import jp.ogiwara.userservice.databinding.ViewChatBinding;
import jp.ogiwara.userservice.user.activity.UserActivity;
import jp.ogiwara.userservice.user.view.action.Load;

public class UserView extends FrameLayout implements View.OnClickListener{

    public UserView(Context context){
        super(context);
    }

    public UserView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    private int uuid;

    private Store<State> store;

    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ViewChatBinding binding = DataBindingUtil.inflate(inflater, R.layout.view_chat, this, true);
        store = new Store<>(new State(), new Dispatcher(), getContext());

        binding.setStore(store);
        binding.setHandler(this);
    }

    public void setUuid(int uuid){
        this.uuid = uuid;
        store.dispatch(new Load(uuid));
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), UserActivity.class);
        intent.putExtra(UserActivity.Extra.UUID.name(), uuid);
        getContext().startActivity(intent);
    }
}
