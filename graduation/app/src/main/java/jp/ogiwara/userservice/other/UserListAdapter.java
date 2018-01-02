package jp.ogiwara.userservice.other;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jp.ogiwara.userservice.user.view.UserView;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private List<Integer> list;

    //list of uuid
    public UserListAdapter(List<Integer> list){
        this.list = list;

        setHasStableIds(true);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ((UserView) holder.itemView ).setUuid(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(String.valueOf(position));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new UserView(parent.getContext()));
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View v){
            super(v);
        }
    }
}
