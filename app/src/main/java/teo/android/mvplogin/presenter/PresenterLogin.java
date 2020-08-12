package teo.android.mvplogin.presenter;

import teo.android.mvplogin.model.ModelListener;
import teo.android.mvplogin.model.ModelLogin;
import teo.android.mvplogin.view.ViewListener;

public class PresenterLogin implements ModelListener {

    private ModelLogin modelLogin;

    private ViewListener viewListener;

    public PresenterLogin(ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    public void presenter(String user, String password)
    {
        modelLogin = new ModelLogin(this);
        modelLogin.handle(user, password);
    }

    @Override
    public void modelSuccess() {
        viewListener.viewSuccess();
    }

    @Override
    public void modelFailed() {
        viewListener.viewFailed();
    }
}
