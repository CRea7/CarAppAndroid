package ie.app.carapp.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ie.app.carapp.R;
import ie.app.carapp.models.Car;

public class ListClickAdapter extends ArrayAdapter<Car> {

    private Context context;
    public List<Car> cars;

    public ListClickAdapter(Context context, ArrayList<Car> cars) {
        super(context, R.layout.layout, cars);
        this.context = context;
        this.cars = cars;

    }
    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Car getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        }

        TextView Cmodel = convertView.findViewById(R.id.ClickDisModel);
        TextView Ccolour = convertView.findViewById(R.id.ClickDisMake);
        TextView CYear = convertView.findViewById(R.id.ClickDisYear);
        TextView CMake = convertView.findViewById(R.id.ClickDisMake);
        TextView Cprice = convertView.findViewById(R.id.ClickDisPrice);
        TextView CDes = convertView.findViewById(R.id.ClickDisDes);

        final Car s= (Car) this.getItem(position);

        Cmodel.setText(s.getCarname());
        Ccolour.setText(s.getCarColour());
        CYear.setText(s.getCarYear());
        CMake.setText(s.getCarMake());
        CDes.setText(s.getDes());
        Cprice.setText(s.getCarPrice());


        return convertView;
    }
}
