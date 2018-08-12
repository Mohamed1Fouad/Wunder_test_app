package test.wunder.com.wundertestapp.utils;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class DataConverter {

    @TypeConverter
    public String fromCoordinatesList(double[] coordinates) {
        if (coordinates == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<double[]>() {
        }.getType();
        String json = gson.toJson(coordinates, type);
        return json;
    }

    @TypeConverter
    public double[] toCoordinatesList(String coordinatesString) {
        if (coordinatesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<double[]>() {
        }.getType();
        double[] coordinates = gson.fromJson(coordinatesString, type);
        return coordinates;
    }
}
