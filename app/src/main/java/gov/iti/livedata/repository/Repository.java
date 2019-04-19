package gov.iti.livedata.repository;

import androidx.lifecycle.LiveData;

public class Repository {

    //repo class should handle the different data sources

    DataModel model;

    public Repository(){

        model = DataModel.getInstance();

    }
    public LiveData<Integer> getCount(){

        return  model.getCount();
    }

    public void incrementCount() {
        model.incrementCount();

    }


}
