package test.wunder.com.wundertestapp.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.wunder.com.wundertestapp.R;
import test.wunder.com.wundertestapp.ui.adapter.ViewPagerAdapter;
import test.wunder.com.wundertestapp.data.local.db.CarsDatabase;
import test.wunder.com.wundertestapp.ui.fragment.CarListFragment;
import test.wunder.com.wundertestapp.ui.fragment.MapFragment;
import test.wunder.com.wundertestapp.data.remote.DataResponse;
import test.wunder.com.wundertestapp.data.remote.RetrofitService;
import test.wunder.com.wundertestapp.utils.Constants;
import test.wunder.com.wundertestapp.utils.Utils;

public class HomeActivity extends AppCompatActivity {

    RetrofitService retrofitService;
    CarsDatabase carsDatabase;
    MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chkData();

        mapFragment = MapFragment.newInstance();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(CarListFragment.newInstance(), getString(R.string.car_list));
        adapter.addFragment(mapFragment, getString(R.string.car_map));

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void chkData() {
        carsDatabase = CarsDatabase.getInMemoryDatabase(this);
        if (Utils.downloadFirstTime(this)) {
            retrofitService = Utils.getService();
            retrofitService.getData().enqueue(new Callback<DataResponse>() {
                @Override
                public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                    carsDatabase.carDao().insertAll(response.body().getCars());
                }

                @Override
                public void onFailure(Call<DataResponse> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == Constants.MY_PERMISSIONS_REQUEST_LOCATION) {
            mapFragment.onRequestPermissionsResult(requestCode, permissions, grantResults);
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
