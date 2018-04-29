package ie.app.carapp.Activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
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
    private Spinner addCar;
    private Spinner addColour;
    private EditText addDes;
    private Spinner addMake;
    private EditText addPrice;
    private Spinner addYear;
    public List<Car> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        //setting the dropdown menu up

        //adapter for car makes
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.CarMakes_array, android.R.layout.simple_spinner_dropdown_item);
        addMake.setAdapter(adapter);

        //adapter for Year
        ArrayAdapter<CharSequence> Year = ArrayAdapter.createFromResource(this, R.array.years_array, android.R.layout.simple_spinner_dropdown_item);
        addYear.setAdapter(Year);

        //adapter for colours
        ArrayAdapter<CharSequence> Colour = ArrayAdapter.createFromResource(this, R.array.Colours, android.R.layout.simple_spinner_dropdown_item);
        addColour.setAdapter(Colour);


        //changes model based on make
        addMake.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (addMake.getSelectedItem().toString()){

                    case "Alfa Romeo": ArrayAdapter<CharSequence> AlfaRomeo = ArrayAdapter.createFromResource(AddActivity.this,R.array.Alfa_Romeo,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(AlfaRomeo);
                        break;
                    case "Aston Martin": ArrayAdapter<CharSequence> AstonMartin = ArrayAdapter.createFromResource(AddActivity.this,R.array.Aston_Martin,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(AstonMartin);
                        break;
                    case "Audi": ArrayAdapter<CharSequence> Audi = ArrayAdapter.createFromResource(AddActivity.this,R.array.Audi,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Audi);
                        break;
                    case "Bentley": ArrayAdapter<CharSequence> Bentley = ArrayAdapter.createFromResource(AddActivity.this,R.array.Bentley,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Bentley);
                        break;
                    case "BMW": ArrayAdapter<CharSequence> BMW = ArrayAdapter.createFromResource(AddActivity.this,R.array.BMW,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(BMW);
                        break;
                    case "Chevrolet": ArrayAdapter<CharSequence> Chevrolet = ArrayAdapter.createFromResource(AddActivity.this,R.array.Chevrolet,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Chevrolet);
                        break;
                    case "Chrysler": ArrayAdapter<CharSequence> Chrysler = ArrayAdapter.createFromResource(AddActivity.this,R.array.Chrysler,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Chrysler);
                        break;
                    case "Citroen": ArrayAdapter<CharSequence> Citroen = ArrayAdapter.createFromResource(AddActivity.this,R.array.Citroen,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Citroen);
                        break;
                    case "Dodge": ArrayAdapter<CharSequence> Dodge = ArrayAdapter.createFromResource(AddActivity.this,R.array.Dodge,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Dodge);
                        break;
                    case "Ferrari": ArrayAdapter<CharSequence> Ferrari = ArrayAdapter.createFromResource(AddActivity.this,R.array.Ferrari,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Ferrari);
                        break;
                    case "Fiat": ArrayAdapter<CharSequence> Fiat = ArrayAdapter.createFromResource(AddActivity.this,R.array.Fiat,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Fiat);
                        break;
                    case "Ford": ArrayAdapter<CharSequence> Ford = ArrayAdapter.createFromResource(AddActivity.this,R.array.Ford,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Ford);
                        break;
                    case "Holden": ArrayAdapter<CharSequence> Holden = ArrayAdapter.createFromResource(AddActivity.this,R.array.Holden,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Holden);
                        break;
                    case "Honda": ArrayAdapter<CharSequence> Honda = ArrayAdapter.createFromResource(AddActivity.this,R.array.Honda,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Honda);
                        break;
                    case "Hyundai": ArrayAdapter<CharSequence> Hyundai = ArrayAdapter.createFromResource(AddActivity.this,R.array.Hyundai,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Hyundai);
                        break;
                    case "Jaguar": ArrayAdapter<CharSequence> Jaguar = ArrayAdapter.createFromResource(AddActivity.this,R.array.Jaguar,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Jaguar);
                        break;
                    case "Jeep": ArrayAdapter<CharSequence> Jeep = ArrayAdapter.createFromResource(AddActivity.this,R.array.Jeep,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Jeep);
                        break;
                    case "Kia": ArrayAdapter<CharSequence> Kia = ArrayAdapter.createFromResource(AddActivity.this,R.array.Kia,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Kia);
                        break;
                    case "Lamborghini": ArrayAdapter<CharSequence> Lamborghini = ArrayAdapter.createFromResource(AddActivity.this,R.array.Lamborghini,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Lamborghini);
                        break;
                    case "Land Rover": ArrayAdapter<CharSequence> LandRover = ArrayAdapter.createFromResource(AddActivity.this,R.array.LandRover,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(LandRover);
                        break;
                    case "Lexus": ArrayAdapter<CharSequence> Lexus = ArrayAdapter.createFromResource(AddActivity.this,R.array.Lexus,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Lexus);
                        break;
                    case "Lotus": ArrayAdapter<CharSequence> Lotus = ArrayAdapter.createFromResource(AddActivity.this,R.array.Lotus,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Lotus);
                        break;
                    case "Mazda": ArrayAdapter<CharSequence> Mazda = ArrayAdapter.createFromResource(AddActivity.this,R.array.Mazda,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Mazda);
                        break;
                    case "Mercedes-Benz": ArrayAdapter<CharSequence> MercdesBenz = ArrayAdapter.createFromResource(AddActivity.this,R.array.MercedesBenz,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(MercdesBenz);
                        break;
                    case "Mini": ArrayAdapter<CharSequence> Mini = ArrayAdapter.createFromResource(AddActivity.this,R.array.Mini,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Mini);
                        break;
                    case "Mitsubishi": ArrayAdapter<CharSequence> Mitsubishi = ArrayAdapter.createFromResource(AddActivity.this,R.array.Mitsubishi,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Mitsubishi);
                        break;
                    case "Nissan": ArrayAdapter<CharSequence> Nissan = ArrayAdapter.createFromResource(AddActivity.this,R.array.Nissan,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Nissan);
                        break;
                    case "Opel": ArrayAdapter<CharSequence> Opel = ArrayAdapter.createFromResource(AddActivity.this,R.array.Opel,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Opel);
                        break;
                    case "Peugeot": ArrayAdapter<CharSequence> Peugeot= ArrayAdapter.createFromResource(AddActivity.this,R.array.Peugeot,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Peugeot);
                        break;
                    case "Porsche": ArrayAdapter<CharSequence> Porsche = ArrayAdapter.createFromResource(AddActivity.this,R.array.Porsche,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Porsche);
                        break;
                    case "Renault": ArrayAdapter<CharSequence> Renault = ArrayAdapter.createFromResource(AddActivity.this,R.array.Renault,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Renault);
                        break;
                    case "Rolls-Royce": ArrayAdapter<CharSequence> RollsRoyce = ArrayAdapter.createFromResource(AddActivity.this,R.array.RollsRoyce,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(RollsRoyce);
                        break;
                    case "SAAB": ArrayAdapter<CharSequence> SAAB = ArrayAdapter.createFromResource(AddActivity.this,R.array.SAAB,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(SAAB);
                        break;
                    case "Subaru": ArrayAdapter<CharSequence> Subaru = ArrayAdapter.createFromResource(AddActivity.this,R.array.Subaru,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Subaru);
                        break;
                    case "Skoda": ArrayAdapter<CharSequence> Skoda = ArrayAdapter.createFromResource(AddActivity.this,R.array.SKoda,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Skoda);
                        break;
                    case "Suzuki": ArrayAdapter<CharSequence> Suzuki = ArrayAdapter.createFromResource(AddActivity.this,R.array.Suzuki,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Suzuki);
                        break;
                    case "Tesla": ArrayAdapter<CharSequence> Tesla = ArrayAdapter.createFromResource(AddActivity.this,R.array.Tesla,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Tesla);
                        break;
                    case "Toyota": ArrayAdapter<CharSequence> Toyota = ArrayAdapter.createFromResource(AddActivity.this,R.array.Toyota,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Toyota);
                        break;
                    case "Vauxhall": ArrayAdapter<CharSequence> Vauxhall = ArrayAdapter.createFromResource(AddActivity.this,R.array.Vauxhall,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Vauxhall);
                        break;
                    case "Volkswagen": ArrayAdapter<CharSequence> Volkswagen = ArrayAdapter.createFromResource(AddActivity.this,R.array.Volkswagen,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Volkswagen);
                        break;
                    case "Volvo": ArrayAdapter<CharSequence> Volvo = ArrayAdapter.createFromResource(AddActivity.this,R.array.Volvo,android.R.layout.simple_spinner_dropdown_item);
                        addCar.setAdapter(Volvo);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //when thew add button is pressed it checks to see if all fields are filled then if you are logged in if both are true it will add the car to the list and send you back to the main screen
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Create child in root object
                //assign a value to the child
                if (addCar.getSelectedItem().toString().isEmpty() || addColour.getSelectedItem().toString().isEmpty() || addMake.getSelectedItem().toString().isEmpty() || addYear.getSelectedItem().toString().isEmpty()
                        || addPrice.getText().toString().isEmpty() || addDes.getText().toString().isEmpty()) {
                    Toast.makeText(AddActivity.this, "Please fill in all fields...", Toast.LENGTH_LONG).show();
                } else
                    if (user == null) {

                        Toast.makeText(AddActivity.this, "Please Log in", Toast.LENGTH_LONG).show();

                }else

                {
                    String Cname = addCar.getSelectedItem().toString();
                String Ccolour = addColour.getSelectedItem().toString();
                String CMake = addMake.getSelectedItem().toString();
                String CYear = addYear.getSelectedItem().toString();
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



    //toolbar settings below
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_AddCar: startActivity (new Intent (this, AddActivity.class));
                break;
            case R.id.action_Home: startActivity(new Intent (this, MainActivity.class));
                break;
            case R.id.action_SignIn: startActivity (new Intent (this, SignInUp.class));
                break;
            case R.id.action_LogOut: FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(getIntent());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {
        super.onPrepareOptionsMenu(menu);

        MenuItem signIn = menu.findItem(R.id.action_SignIn);
        MenuItem logOut = menu.findItem(R.id.action_LogOut);
        MenuItem addCar = menu.findItem(R.id.action_AddCar);

        //check to see if there is a user signed in
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            //if user is signed in it wont show sign in option
            signIn.setEnabled(false);
            signIn.setVisible(false);

        }
        else
        {
            //if user is logged in will give them the option to log out
            logOut.setEnabled(false);
            logOut.setVisible(false);
        }

        return true;
    }
}
