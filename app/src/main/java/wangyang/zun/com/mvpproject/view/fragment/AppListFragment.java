package wangyang.zun.com.mvpproject.view.fragment;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import wangyang.zun.com.mvpproject.R;
import wangyang.zun.com.mvpproject.adapter.MyAppListRecyclerViewAdapter;
import wangyang.zun.com.mvpproject.adapter.RecyleItemDecoration;
import wangyang.zun.com.mvpproject.presenter.Presenter;
import wangyang.zun.com.mvpproject.view.RecycleOnItemClickListener;
import wangyang.zun.com.mvpproject.view.viewinterface.ViewInterface;


public class AppListFragment extends Fragment implements ViewInterface {

    private Presenter presenter;

    private List<PackageInfo> packageInfoList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAppListRecyclerViewAdapter myAppListRecyclerViewAdapter;


    private AppListFragment() {

    }


    public static AppListFragment newInstance() {
        AppListFragment fragment = new AppListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_applist_list, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.addItemDecoration(new RecyleItemDecoration());
            myAppListRecyclerViewAdapter = new MyAppListRecyclerViewAdapter(packageInfoList);
            recyclerView.setAdapter(myAppListRecyclerViewAdapter);
            recyclerView.addOnItemTouchListener(new RecycleOnItemClickListener(recyclerView) {
                @Override
                public void onItemClick(RecyclerView.ViewHolder viewHolder) {
                    MyAppListRecyclerViewAdapter.ViewHolder holder = (MyAppListRecyclerViewAdapter.ViewHolder) viewHolder;
                    presenter.launchApp(holder.mItem);
                }
            });
        }
        return view;
    }

    @Override
    public void showAppList(List<PackageInfo> packageInfos) {
        if (packageInfos.isEmpty())
            return;
        packageInfoList.clear();
        packageInfoList.addAll(packageInfos);
        myAppListRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
