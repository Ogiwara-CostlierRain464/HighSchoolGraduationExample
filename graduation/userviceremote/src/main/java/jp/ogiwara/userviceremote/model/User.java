package jp.ogiwara.userviceremote.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject{
    private static int count = 0;

    public static User apply(String name, int age, int like){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setLike(like);

        return user;
    }

    private String name;
    private int age;
    private int like;
    @PrimaryKey
    private int uuid;

    {
        uuid = count++;
    }

    public int getUuid(){
        return uuid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getLike() {
        return like;
    }

    public int addLike(){
        return this.like++;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }
}
