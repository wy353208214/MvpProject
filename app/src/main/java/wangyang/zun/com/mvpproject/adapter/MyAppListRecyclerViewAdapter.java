package wangyang.zun.com.mvpproject.adapter;

import android.content.pm.PackageInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import wangyang.zun.com.mvpproject.R;

public class MyAppListRecyclerViewAdapter extends RecyclerView.Adapter<MyAppListRecyclerViewAdapter.ViewHolder> {

    private final List<PackageInfo> mValues;


    public MyAppListRecyclerViewAdapter(List<PackageInfo> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_applist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(holder.mItem.applicationInfo.loadLabel(holder.mView.getContext().getPackageManager()));
        holder.packageView.setText(holder.mItem.applicationInfo.packageName);
        holder.mImageView.setImageDrawable(holder.mItem.applicationInfo.loadIcon(holder.mView.getContext().getPackageManager()));
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView packageView;
        public final ImageView mImageView;
        public PackageInfo mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            packageView = (TextView) view.findViewById(R.id.package_name);
            mImageView = (ImageView) view.findViewById(R.id.app_icon);
        }

    }
}
