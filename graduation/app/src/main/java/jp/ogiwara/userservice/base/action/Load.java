package jp.ogiwara.userservice.base.action;

import java.util.function.Function;

import jp.ogiwara.cycle.Action;
import jp.ogiwara.userservice.App;

public class Load implements Action{

    private App app;

    public Load(App app) {
        this.app = app;
    }

    public App getApp() {
        return app;
    }
}
