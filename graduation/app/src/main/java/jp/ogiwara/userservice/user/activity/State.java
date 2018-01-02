package jp.ogiwara.userservice.user.activity;


import android.databinding.ObservableField;
import android.databinding.ObservableInt;

public class State implements jp.ogiwara.cycle.State {
    private ObservableField<String> name = new ObservableField<>();
    private ObservableInt like = new ObservableInt();

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableInt getLike() {
        return like;
    }
}
