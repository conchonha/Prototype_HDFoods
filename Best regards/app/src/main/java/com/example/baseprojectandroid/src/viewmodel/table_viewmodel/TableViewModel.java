package com.example.baseprojectandroid.src.viewmodel.table_viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.baseprojectandroid.models.table_models.TableModels;
import com.example.baseprojectandroid.src.repositories.table_repositories.TableRepositories;

import java.util.List;

public class TableViewModel extends ViewModel {
    private MutableLiveData<List<TableModels>> mArrayTable;

    private TableRepositories tableRepositories;

    public void initTable(){
        if (mArrayTable != null){
            return;
        }
        tableRepositories = TableRepositories.getInstance();
        mArrayTable = tableRepositories.getListTable();
    }
    public MutableLiveData<List<TableModels>> getmArrayTable(){
        return mArrayTable;
    }

}
