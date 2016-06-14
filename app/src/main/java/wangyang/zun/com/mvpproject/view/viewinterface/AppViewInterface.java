package wangyang.zun.com.mvpproject.view.viewinterface;

import android.content.pm.PackageInfo;

import java.util.List;

import wangyang.zun.com.mvpproject.presenter.Presenter;

/**
 * Created by pc on 2016/4/28.
 */
public interface AppViewInterface extends BaseViewInterface{
    void showAppList(List<PackageInfo> packageInfos);
}
