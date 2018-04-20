package ie.app.carapp.Activity;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ie.app.carapp.R;
import ie.app.carapp.models.Car;

public class RecycAdapt extends RecyclerView.Adapter<RecycAdapt.ViewHolder>{

    private List<Car> CarList;
    private Context context;

    public RecycAdapt(List<Car> carList, Context context) {
        CarList = carList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

            Car car = CarList.get(position);

            holder.textViewName.setText(car.getCarname());
            holder.textViewMake.setText(car.getCarMake());
            holder.textViewYear.setText(car.getCarYear());
    }

    @Override
    public int getItemCount() {
        return CarList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView textViewName;
        public TextView textViewMake;
        public TextView textViewYear;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.RecName);
            textViewMake = itemView.findViewById(R.id.RecMake);
            textViewYear = itemView.findViewById(R.id.RecYear);
        }
    }
}

