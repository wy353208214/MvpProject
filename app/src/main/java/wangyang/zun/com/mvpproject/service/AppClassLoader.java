package wangyang.zun.com.mvpproject.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.List;

/**
 * Created by pc on 2016/4/28.
 */
public class AppClassLoader extends AsyncTaskLoader<List<PackageInfo>> {

    private PackageManager packageManager;

    public AppClassLoader(Context context) {
        super(context);
    }

    @Override
    public List<PackageInfo> loadInBackground() {
        Log.d(getClass().getCanonicalName(), "loadInBackground: ");
        packageManager = getContext().getPackageManager();
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        return  packageInfos;
    }

    @Override
    public void deliverResult(List<PackageInfo> data) {
        super.deliverResult(data);
        Log.d(getClass().getCanonicalName(), "deliverResult: ");
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        Log.d(getClass().getCanonicalName(), "onStartLoading: ");
        forceLoad();
    }

    public Intent queryLaunchIntent(PackageInfo packageInfo) {
        return packageManager.getLaunchIntentForPackage(packageInfo.packageName);
    }

}
