package test.wunder.com.wundertestapp.ui.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import test.wunder.com.wundertestapp.R;
import test.wunder.com.wundertestapp.ui.ListCarViewModel;
import test.wunder.com.wundertestapp.ui.adapter.CarRecyclerViewAdapter;
import test.wunder.com.wundertestapp.data.model.Car;


public class CarListFragment extends Fragment {



    private RecyclerView recyclerView;
    private ListCarViewModel listCarViewModel;

    public static CarListFragment newInstance() {
        CarListFragment fragment = new CarListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_car_list, container, false);

        if (view instanceof RecyclerView) {
             recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

              listCarViewModel = ViewModelProviders.of(this).get(ListCarViewModel.class);
            listCarViewModel.getCars().observe(this, new Observer<List<Car>>() {
                @Override
                public void onChanged(@Nullable List<Car> cars) {
                    recyclerView.setAdapter(new CarRecyclerViewAdapter(cars));

                }
            });
        }
        return view;
    }




}
