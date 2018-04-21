package ie.app.carapp.Activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ie.app.carapp.R;
import ie.app.carapp.models.Car;

public class AddActivity extends AppCompatActivity{

    private DatabaseReference mDatabase;
    private Button addButton;
    private EditText addCar;
    private EditText addColour;
    private EditText addDes;
    private EditText addMake;
    private EditText addPrice;
    private EditText addYear;
    public List<Car> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcar);

        cars = new ArrayList<>();
        addButton = findViewById(R.id.AddButton);
        addCar = findViewById(R.id.addCar);
        addColour = findViewById(R.id.addColour);
        addDes = findViewById(R.id.addDes);
        addMake = findViewById(R.id.addMake);
        addPrice = findViewById(R.id.addPrice);
        addYear = findViewById(R.id.addYear);

        final Intent intent = new Intent(this, MainActivity.class);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Car");
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Create child in root object
                //assign a value to the child
                if (addCar.getText().toString().isEmpty() || addColour.getText().toString().isEmpty() || addMake.getText().toString().isEmpty() || addYear.getText().toString().isEmpty()
                        || addPrice.getText().toString().isEmpty() || addDes.getText().toString().isEmpty()) {
                    Toast.makeText(AddActivity.this, "Please fill in all fields...", Toast.LENGTH_LONG).show();
                } else
                    if (user == null) {

                        Toast.makeText(AddActivity.this, "Please Log in", Toast.LENGTH_LONG).show();

                }else

                {
                    String Cname = addCar.getText().toString();
                String Ccolour = addColour.getText().toString();
                String CMake = addMake.getText().toString();
                String CYear = addYear.getText().toString();
                String CPrice = addPrice.getText().toString();
                String CDes = addDes.getText().toString();

                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("carname", Cname);
                dataMap.put("carColour", Ccolour);
                dataMap.put("carMake", CMake);
                dataMap.put("carYear", CYear);
                dataMap.put("carPrice", CPrice);
                dataMap.put("des", CDes);

                mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    //this lets the user know if the data has been added correctly.
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(AddActivity.this, "Car added successfully...", Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        } else {
                            Toast.makeText(AddActivity.this, "Error...", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
            }
        });
    }
}
