package test.wunder.com.wundertestapp.data.remote;

import retrofit2.Call;
import retrofit2.http.GET;
import test.wunder.com.wundertestapp.utils.Constants;

public interface RetrofitService {

    @GET(Constants.JSON_URL)
    Call<DataResponse> getData();

}
