package jp.ogiwara.userservice.user.activity.action;


import jp.ogiwara.cycle.Action;
import jp.ogiwara.userservice.App;

public class Touch implements Action {
    private App app;
    private int uuid;

    public Touch(App app, int uuid) {
        this.app = app;
        this.uuid = uuid;
    }

    public App getApp() {
        return app;
    }

    public int getUuid() {
        return uuid;
    }
}
