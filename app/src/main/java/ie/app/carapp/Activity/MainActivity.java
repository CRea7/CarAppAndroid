package ie.app.carapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ie.app.carapp.R;
import ie.app.carapp.models.Car;



public class MainActivity extends AppCompatActivity {

    private ListView List;
    public List<Car> cars;
    private DatabaseReference mDatabase;
    private FirebaseDatabase db;
    private ArrayList<String> list;
//    private ArrayAdapter<String> adapter;
    Car car;
    private FirebaseAuth.AuthStateListener mAuthListen;

    private ArrayList<String> FirebaseCars = new ArrayList<>();
    private ArrayList<String> Keys = new ArrayList<>();

    //testing recycler view
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        car = new Car();
//        list = new ArrayList<>();
//        db = FirebaseDatabase.getInstance();
//        mDatabase = db.getReference("Car");
//        List = findViewById(R.id.listview);
//        adapter = new ArrayAdapter<String>(this, R.layout.layout, R.id.textViewCar, list);
//
//        mDatabase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                for (DataSnapshot ds : dataSnapshot.getChildren()) {
//
//                    car = ds.getValue(Car.class);
//                    list.add("Car Name: " + car.getCarname().toString() + "  Car Colour: " + car.getCarColour().toString() + " Car Make: " + car.getCarMake().toString() + "  Car Year: " +
//                            car.getCarYear().toString() + " Car Price :  €" + car.getCarPrice().toString() + " Description: " + car.getDes().toString());
//
//                    String key = ds.getKey();
//                }
//                List.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cars = new ArrayList<>();

        for(int i = 0; i<=10; i++){
            Car car = new Car(
                    "Name " + (i+1),
                    "Make name test",
                    "year name test"
            );

            cars.add(car);
        }

        adapter = new RecycAdapt(cars, this);

        recyclerView.setAdapter(adapter);

        //sends data to the list activity so it can be displayed
//        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(MainActivity.this, ListActivity.class);
//                intent.putExtra("Car Name", List.getItemAtPosition(i).toString());
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //this is what allows the menu to work
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_Search : startActivity (new Intent(this, SearchActivity.class));
               break;
            case R.id.action_AddCar: startActivity (new Intent (this, AddActivity.class));
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
        MenuItem search = menu.findItem(R.id.action_Search);
        MenuItem setting = menu.findItem(R.id.action_settings);

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
