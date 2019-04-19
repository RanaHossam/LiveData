package gov.iti.livedata.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class DataModel {
    private MutableLiveData<Integer> liveCount;
    private int count;
    private static DataModel sharedInstance;

    private DataModel(){
            this.count = 0;
            liveCount= new MutableLiveData<>();
            liveCount.setValue(count);
    }

    public LiveData<Integer> getCount()
    {
        //the delay here doesn't affect the application since the observed data is actually changed
        //in the incrementCount method
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
      return  liveCount;
    }

    public void incrementCount() {
        //delay added in the increment as it wouldn't be effective in getCount
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        liveCount.setValue(count);

    }
    public static DataModel getInstance(){
        if(sharedInstance ==null){
            sharedInstance = new DataModel();
        }
        return sharedInstance;
    }






}
