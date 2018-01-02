package jp.ogiwara.userservice.user.activity.action;


import jp.ogiwara.cycle.Action;
import jp.ogiwara.userservice.App;

public class Load implements Action {
    private int uuid;
    private App app;

    public int getUuid() {
        return uuid;
    }

    public App getApp() {
        return app;
    }

    public Load(int uuid, App app) {

        this.uuid = uuid;
        this.app = app;
    }
}
