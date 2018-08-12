package test.wunder.com.wundertestapp.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import test.wunder.com.wundertestapp.data.model.Car;
import test.wunder.com.wundertestapp.utils.DataConverter;
import test.wunder.com.wundertestapp.data.local.db.dao.CarDao;

@Database(entities = {Car.class},version = 1)
@TypeConverters(DataConverter.class)
public abstract class CarsDatabase  extends RoomDatabase {
    public static final String DATABASE_NAME = "cars-db";
    private static CarsDatabase INSTANCE;

    public abstract CarDao carDao();


    public static CarsDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), CarsDatabase.class, CarsDatabase.DATABASE_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
