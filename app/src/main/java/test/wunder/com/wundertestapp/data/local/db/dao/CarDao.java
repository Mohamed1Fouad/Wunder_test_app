package test.wunder.com.wundertestapp.data.local.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import test.wunder.com.wundertestapp.data.model.Car;


@Dao
public interface CarDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Car... car);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Car> cars);

    @Query("SELECT * FROM car")
    LiveData<List<Car>> getCars();
}
