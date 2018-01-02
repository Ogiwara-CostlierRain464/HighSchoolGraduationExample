package jp.ogiwara.userviceapi.model;

public class User{
    private static int count;

    public User(String name, int age, int like) {
        this.name = name;
        this.age = age;
        this.like = like;

        uuid = count++;
    }

    private String name;
    private int age;
    private int like;
    private int uuid;

    public int getUuid() {
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

    public void addLike(){
        this.like++;
    }
}
