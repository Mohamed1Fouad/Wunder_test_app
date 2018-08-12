package test.wunder.com.wundertestapp.data.remote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import test.wunder.com.wundertestapp.data.model.Car;

public class DataResponse {
    @SerializedName("placemarks")
    private List<Car> placemarks;

    public List<Car> getCars(){
        return placemarks;
    }
 }
