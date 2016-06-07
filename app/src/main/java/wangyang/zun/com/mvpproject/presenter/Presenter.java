package wangyang.zun.com.mvpproject.presenter;

import android.content.pm.PackageInfo;

/**
 * Created by pc on 2016/4/26.
 */
public interface Presenter extends BasePresenter{
    void loadInstallApps();

    void launchApp(PackageInfo packageInfo);
}
