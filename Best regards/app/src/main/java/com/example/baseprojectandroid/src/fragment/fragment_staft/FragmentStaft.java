package com.example.baseprojectandroid.src.fragment.fragment_staft;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseprojectandroid.R;
import com.example.baseprojectandroid.compoments.toolbar.Toolbar;
import com.example.baseprojectandroid.models.callback.CallbackToolbar;
import com.example.baseprojectandroid.src.adapter.staft_adapter.StaftAdapter;
import com.example.baseprojectandroid.models.staft_models.StaftModels;
import com.example.baseprojectandroid.src.viewmodel.staft_viewmodel.StaftViewModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentStaft extends Fragment {
    private View mView;
    private RecyclerView mRecyclerStaft;
    private StaftViewModel mStaftViewModel;
    private StaftAdapter mAdapterStaft;
    private Toolbar mToolbar;
    
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_staft,container,false);

        initViewmodel();
        initView();
        init();
        return mView;
    }

    private void init() {
        //set recyclerview
        mRecyclerStaft.setHasFixedSize(true);
        mRecyclerStaft.setLayoutManager(new LinearLayoutManager(mView.getContext()));
        mAdapterStaft = new StaftAdapter(mView.getContext(),R.layout.layout_item_staft,(ArrayList) mStaftViewModel.getmArrayBill().getValue());
        mRecyclerStaft.setAdapter(mAdapterStaft);
        mAdapterStaft.notifyDataSetChanged();

        // add toolbar
        mToolbar = new Toolbar();
        getFragmentManager().beginTransaction().add(R.id.relative_staft,mToolbar,"toolbar_staft").commit();
        setCallbackToolbar(mToolbar);
    }

    private void setCallbackToolbar(CallbackToolbar callbackToolbar) {
        CallbackToolbar callbackToolbar1 = callbackToolbar;
        callbackToolbar1.onReceiveTitle(getString(R.string.lbl_staft));
    }

    //create viewmodel
    private void initViewmodel() {
        mStaftViewModel = ViewModelProviders.of(getActivity()).get(StaftViewModel.class);
        mStaftViewModel.initStaft();

        // lắng nghe quan sát sự thay đổi của dữ liệu
        mStaftViewModel.getmArrayBill().observe(getViewLifecycleOwner(), new Observer<List<StaftModels>>() {
            @Override
            public void onChanged(List<StaftModels> staftModels) {
                Log.d("11111", "onChange: "+staftModels.size());
                mAdapterStaft.notifyDataSetChanged();
            }
        });
    }

    // ánh xạ view
    private void initView() {
        mRecyclerStaft = mView.findViewById(R.id.recyclerStaft);
    }
}
