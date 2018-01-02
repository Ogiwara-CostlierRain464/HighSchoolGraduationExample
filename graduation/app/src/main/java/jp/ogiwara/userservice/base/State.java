package jp.ogiwara.userservice.base;


import android.databinding.ObservableArrayList;

public class State implements jp.ogiwara.cycle.State{
    private ObservableArrayList<Integer> list = new ObservableArrayList<>();

    public ObservableArrayList<Integer> getList() {
        return list;
    }
}
