package test.wunder.com.wundertestapp.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import test.wunder.com.wundertestapp.data.local.db.CarsDatabase;
import test.wunder.com.wundertestapp.data.model.Car;

public class ListCarViewModel extends AndroidViewModel {
     private LiveData<List<Car>>cars ;

    public ListCarViewModel(Application application){
        super(application);
        cars = CarsDatabase.getInMemoryDatabase(application).carDao().getCars();
    }
    public LiveData<List<Car>> getCars() {
        return cars;
    }

}
