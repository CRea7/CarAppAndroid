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


public class CustomListview extends ArrayAdapter<Car>{


    private Context        context;
    public List<Car>        cars;

    public CustomListview(Context context, ArrayList<Car> cars) {
        super(context, R.layout.layout, cars);
        this.context = context;
        this.cars = cars;

    }
//    @Override
//    public int getCount() {
//        return cars.size();
//    }
//
//    @Override
//    public Car getItem(int position) {
//        return cars.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if(convertView==null)
//        {
//            convertView= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
//        }
//
//        TextView Cname = convertView.findViewById(R.id.textViewCar);
//        TextView Ccolour = convertView.findViewById(R.id.textViewColour);
//        TextView Cdes = convertView.findViewById(R.id.textViewDes);
//
//        final Car s= (Car) this.getItem(position);
//
//        Cname.setText(s.getCarname());
//        Ccolour.setText(s.getCarColour());
//        Cdes.setText(s.getDes());
//
//
//        return convertView;
//    }
//    public CustomListview(Context context, List<Car> cars)
//    {
//        super(context, R.layout.layout, cars);
//        this.context   = context;
//        this.cars = cars;
//    }
//
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent)
//    {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//        View     view       = inflater.inflate(R.layout.layout, parent, false);
//        Car car   = cars.get(position);
//        TextView nameView = view.findViewById(R.id.textViewCar);
//        TextView colourView = view.findViewById(R.id.textViewColour);
//        TextView desView = view.findViewById(R.id.textViewDes);
//        ImageView carImage = view.findViewById(R.id.imageViewList);
//
//
//        nameView.setText(car.getCarname());
//        colourView.setText(car.getCarColour());
//        desView.setText(car.getDes());
//
//        return view;
//    }
//
//    @Override
//    public int getCount()
//    {
//        return cars.size();
//    }
}

