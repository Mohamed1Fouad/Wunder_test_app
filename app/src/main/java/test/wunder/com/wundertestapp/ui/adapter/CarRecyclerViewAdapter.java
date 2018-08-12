package test.wunder.com.wundertestapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test.wunder.com.wundertestapp.R;
import test.wunder.com.wundertestapp.data.model.Car;


public class CarRecyclerViewAdapter extends RecyclerView.Adapter<CarRecyclerViewAdapter.ViewHolder> {

    private final List<Car> cars;
    public CarRecyclerViewAdapter(List<Car> cars) {
        this.cars = cars;
     }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.car = cars.get(position);
        holder.textViewName.setText(cars.get(position).getName());
        holder.textViewEngine.setText(cars.get(position).getEngineType());
        holder.textViewAddress.setText(cars.get(position).getAddress());
        holder.textViewInterior.setText(cars.get(position).getInterior());
        holder.textViewExterior.setText(cars.get(position).getExterior());
        holder.textViewFuel.setText(String.valueOf(cars.get(position).getFuel()));
        holder.textViewVin.setText(cars.get(position).getVin());

    }

    @Override
    public int getItemCount() {
         return cars.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView textViewName;
        public final TextView textViewEngine;
        public final TextView textViewAddress;
        public final TextView textViewExterior;
        public final TextView textViewInterior;
        public final TextView textViewFuel;
        public final TextView textViewVin;

        public Car car;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            textViewName = (TextView) view.findViewById(R.id.tv_item_name);
            textViewEngine= (TextView) view.findViewById(R.id.tv_item_engine);
            textViewAddress = (TextView) view.findViewById(R.id.tv_item_address);
            textViewExterior = (TextView) view.findViewById(R.id.tv_item_exterior);
            textViewInterior = (TextView) view.findViewById(R.id.tv_item_interior);
            textViewFuel = (TextView) view.findViewById(R.id.tv_item_fuel);
            textViewVin = (TextView) view.findViewById(R.id.tv_item_vin);

        }


    }
}
