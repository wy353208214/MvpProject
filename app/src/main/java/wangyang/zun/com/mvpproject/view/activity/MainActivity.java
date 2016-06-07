package wangyang.zun.com.mvpproject.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import wangyang.zun.com.mvpproject.R;
import wangyang.zun.com.mvpproject.presenter.AppListPresenter;
import wangyang.zun.com.mvpproject.presenter.Presenter;
import wangyang.zun.com.mvpproject.service.AppClassLoader;
import wangyang.zun.com.mvpproject.view.fragment.AppListFragment;

public class MainActivity extends AppCompatActivity{

    private Presenter appListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        AppListFragment appListFragment = AppListFragment.newInstance();
        fragmentTransaction.add(R.id.fm, appListFragment);
        fragmentTransaction.commit();

        appListPresenter = new AppListPresenter(appListFragment, new AppClassLoader(getApplicationContext()), getSupportLoaderManager());
        appListPresenter.loadInstallApps();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_edit)
            appListPresenter.loadInstallApps();

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        appListPresenter.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appListPresenter.destory();
    }
}
