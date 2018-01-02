package jp.ogiwara.userservice.other;


import android.content.Context;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class UserListView extends RecyclerView{

    private UserListAdapter adapter;

    public UserListView(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    //Resolve with Duck Typing
    public void setList(ObservableArrayList<Integer> list){
        if(adapter == null){
            adapter = new UserListAdapter(list);
            setAdapter(adapter);
        }

        adapter.notifyDataSetChanged();
    }

}
