package jp.ogiwara.userservice.apply.view.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class User implements Parcelable {
    private int age;
    private int like;
    private String name;
    private int uuid;
    private List<User> follower;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.age);
        dest.writeInt(this.like);
        dest.writeString(this.name);
        dest.writeInt(this.uuid);
        dest.writeList(this.follower);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.age = in.readInt();
        this.like = in.readInt();
        this.name = in.readString();
        this.uuid = in.readInt();
        this.follower = new ArrayList<User>();
        in.readList(this.follower, User.class.getClassLoader());
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
