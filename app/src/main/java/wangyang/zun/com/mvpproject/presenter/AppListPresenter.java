package wangyang.zun.com.mvpproject.presenter;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.Toast;

import java.util.List;

import wangyang.zun.com.mvpproject.service.AppClassLoader;
import wangyang.zun.com.mvpproject.view.viewinterface.ViewInterface;

/**
 * Created by pc on 2016/4/26.
 */
public class AppListPresenter implements Presenter, LoaderManager.LoaderCallbacks<List<PackageInfo>>{

    private ViewInterface viewInterface;
    private AppClassLoader appClassLoader;
    private LoaderManager loaderManager;

    private final int id = 0;


    public AppListPresenter(ViewInterface viewInterface, AppClassLoader appClassLoader, LoaderManager loaderManager) {
        this.viewInterface = viewInterface;
        this.appClassLoader = appClassLoader;
        this.loaderManager = loaderManager;
        viewInterface.setPresenter(this);
    }

    @Override
    public void loadInstallApps() {
        loaderManager.initLoader(id, null, this);
    }

    @Override
    public void start() {

    }

    @Override
    public void destory() {
        loaderManager.destroyLoader(id);
    }

    @Override
    public Loader<List<PackageInfo>> onCreateLoader(int id, Bundle args) {
        return appClassLoader;
    }

    @Override
    public void onLoadFinished(Loader<List<PackageInfo>> loader, List<PackageInfo> data) {
        viewInterface.showAppList(data);
    }

    @Override
    public void onLoaderReset(Loader<List<PackageInfo>> loader) {

    }

    @Override
    public void launchApp(PackageInfo packageInfo) {
        Intent intent = appClassLoader.queryLaunchIntent(packageInfo);
        if (intent != null)
            appClassLoader.getContext().startActivity(intent);
        else
            Toast.makeText(appClassLoader.getContext(), "Can not start the app", Toast.LENGTH_SHORT).show();
    }
}
