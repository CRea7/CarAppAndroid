package ie.app.carapp.Activity;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ie.app.carapp.R;
import ie.app.carapp.models.Car;

public class AddActivity extends AppCompatActivity{

    Button addButton;
    EditText addCar;
    EditText addColour;
    EditText addDes;
    public List<Car> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcar);

        cars = new ArrayList<>();
        addButton = findViewById(R.id.AddButton);
        addCar = findViewById(R.id.AddName);
        addColour = findViewById(R.id.AddColour);
        addDes = findViewById(R.id.AddDes);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Cname = null;
                String Ccolour = null;
                String Cdes = null;
                if (addCar != null && addColour != null && addDes != null) {

                    Cname = addCar.getText().toString();
                    Ccolour = addColour.getText().toString();
                    Cdes = addDes.getText().toString();

                } else
                {

                }

                Car car = new Car(Cname, Ccolour, Cdes, 0);
                cars.add(car);
                Log.i("Cars", car.getCarname());
            }
        });
    }
}
