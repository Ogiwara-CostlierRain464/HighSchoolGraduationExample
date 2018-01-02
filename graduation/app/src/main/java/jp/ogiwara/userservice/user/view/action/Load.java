package jp.ogiwara.userservice.user.view.action;


import jp.ogiwara.cycle.Action;
import jp.ogiwara.userservice.App;

public class Load implements Action {
    private int uuid;

    public Load(int uuid) {
        this.uuid = uuid;
    }

    public int getUuid() {
        return uuid;
    }
}
