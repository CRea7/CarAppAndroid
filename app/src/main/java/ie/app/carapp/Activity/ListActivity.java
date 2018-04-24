package ie.app.carapp.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ie.app.carapp.R;
import ie.app.carapp.models.Car;

public class ListActivity extends AppCompatActivity{

    Toolbar mToolbar;
    TextView textView;
    private ListView List;
    private DatabaseReference mDatabase;
    private FirebaseDatabase db;

   // Button BtnDelete = findViewById(R.id.BtnDelete);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listclick);
        textView = findViewById(R.id.ClickDes);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        List = findViewById(R.id.clicklist);
        db = FirebaseDatabase.getInstance();
        mDatabase = db.getReference("Car");

        Bundle recievedData = getIntent().getExtras();
        String pos = recievedData.getString("name");


        final ArrayList<Car> cars = new ArrayList<Car>();
        final ListClickAdapter listClickAdapter = new ListClickAdapter(this, cars);




        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    Car value = ds.getValue(Car.class);
                    Car car = new Car();
                    String name = value.getCarname();
                    String make = value.getCarMake();
                    String year = value.getCarYear();
                    String Colour = value.getCarColour();
                    String Price = value.getCarPrice();
                    String Description = value.getDes();
                    car.setCarname(name);
                    car.setCarMake(make);
                    car.setCarYear(year);
                    car.setCarColour(Colour);
                    car.setCarPrice(Price);
                    car.setDes(Description);
                    cars.add(car);
                }
                //The adapter displays all the information from firebase
                List.setAdapter(listClickAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

       }
}
