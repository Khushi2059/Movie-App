package com.example.movieapp.ui.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.data.api.Resource;

public class BaseViewModel extends ViewModel {

    private MutableLiveData<Resource> loadingData;

    public BaseViewModel() {
        loadingData = new MutableLiveData<>();
    }

    public MutableLiveData<Resource> getLoadingData() {
        return loadingData;
    }

    public void setLoading(Resource resource) {
        if (resource != null)
            loadingData.setValue(resource);
    }
}
