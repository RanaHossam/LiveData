package gov.iti.livedata.viewmodel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import gov.iti.livedata.repository.Repository;

public class MyViewModel extends ViewModel {
    Repository repo;
    public MyViewModel() {
        repo = new Repository();
    }
    public LiveData<Integer> getCount(){
        return  repo.getCount();
    }

    public void incrementCount() {
        repo.incrementCount();

    }


}
