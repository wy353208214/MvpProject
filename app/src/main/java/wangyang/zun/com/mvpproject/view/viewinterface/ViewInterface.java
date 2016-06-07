package wangyang.zun.com.mvpproject.view.viewinterface;

import android.content.pm.PackageInfo;

import java.util.List;

import wangyang.zun.com.mvpproject.presenter.Presenter;

/**
 * Created by pc on 2016/4/28.
 */
public interface ViewInterface {

    void showAppList(List<PackageInfo> packageInfos);
    void setPresenter(Presenter presenter);
}
