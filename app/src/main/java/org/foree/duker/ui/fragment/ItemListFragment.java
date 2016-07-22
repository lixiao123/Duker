package org.foree.duker.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikepenz.materialdrawer.Drawer;

import org.foree.duker.R;
import org.foree.duker.api.AbsApiFactory;
import org.foree.duker.api.AbsApiHelper;
import org.foree.duker.api.ApiFactory;
import org.foree.duker.api.FeedlyApiHelper;
import org.foree.duker.net.NetCallback;
import org.foree.duker.rssinfo.RssItem;

import java.util.List;

/**
 * Created by foree on 16-7-20.
 */
public class ItemListFragment extends Fragment{
    private static final String KEY_FEEDID = "feedId";

    private Drawer result;
    private RecyclerView mRecyclerView;
    private ItemListAdapter mAdapter;
    private AbsApiHelper mApiHelper;
    private List<RssItem> itemList;

    public ItemListFragment() {
        // Required empty public constructor
    }

    public static ItemListFragment newInstance(String feedId) {
        ItemListFragment f = new ItemListFragment();

        Bundle args = new Bundle();

        args.putString(KEY_FEEDID, feedId);
        f.setArguments(args);

        return (f);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.fragment_itemlist, container, false);

        TextView tv = (TextView)linearLayout.findViewById(R.id.tv_test_feed_id);
        tv.setText(getArguments().getString(KEY_FEEDID));

        mRecyclerView = (RecyclerView) linearLayout.findViewById(R.id.rv_item_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());


        // getItemList
        AbsApiFactory absApiFactory = new ApiFactory();
        mApiHelper = absApiFactory.createApiHelper(FeedlyApiHelper.class);

        mApiHelper.getStream("", getArguments().getString(KEY_FEEDID), new NetCallback<RssItem>() {
            @Override
            public void onSuccess(List<RssItem> data) {
                itemList = data;
                mAdapter = new ItemListAdapter(getActivity(),itemList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFail(String msg) {

            }
        });
        return linearLayout;
    }

    class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.MyViewHolder>{
        private LayoutInflater mLayoutInflater;
        private List<RssItem> mItemList;

        public ItemListAdapter(Context context, List<RssItem> itemList){
            mLayoutInflater = LayoutInflater.from(context);
            mItemList = itemList;
        }

        @Override
        public ItemListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(mLayoutInflater.inflate(R.layout.item_list_holder, parent, false));

            return holder;
        }

        @Override
        public void onBindViewHolder(ItemListAdapter.MyViewHolder holder, int position) {
            holder.tv.setText(mItemList.get(position).getTitle());
        }

        @Override
        public int getItemCount() {
            return mItemList.size();
        }


        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView tv;
            public MyViewHolder(View view){
                super(view);
                tv = (TextView)view.findViewById(R.id.tv_item);
            }
        }
    }
}
