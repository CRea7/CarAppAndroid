package ie.app.carapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
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
    private ArrayAdapter<String> adapter;
    Car car;

    private ArrayList<String> FirebaseCars = new ArrayList<>();
    private ArrayList<String> Keys = new ArrayList<>();
//    //authentication
//    private EditText mEmail;
//    private EditText mPass;
//    private Button mLog;
//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        car = new Car();
        list = new ArrayList<>();
        db = FirebaseDatabase.getInstance();
        mDatabase = db.getReference("Car");
        List = findViewById(R.id.listview);
        adapter = new ArrayAdapter<String>(this, R.layout.layout, R.id.textViewCar, list);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    car = ds.getValue(Car.class);
                    list.add("Car Name: " + car.getCarname().toString() + "  Car Colour: " + car.getCarColour().toString() + " Car Make: " + car.getCarMake().toString() + "  Car Year: " +
                            car.getCarYear().toString() + " Car Price :  €" + car.getCarPrice().toString() + " Description: " + car.getDes().toString());

                    String key = ds.getKey();
                }
                List.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        //sends data to the list activity so it can be displayed
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("Car Name", List.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });

//        //more authenticatio
//        mEmail = findViewById(R.id.SignEmail);
//        mPass = findViewById(R.id.SignPass);
//        mLog = findViewById(R.id.SignButton);
//        mAuth = FirebaseAuth.getInstance();
//
//        mLog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                SignIn();
//            }
//        });
//
//        mAuthListen = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//
//                if(firebaseAuth.getCurrentUser()== null){
//
//                    startActivity(new Intent(MainActivity.this, SearchActivity.class));
//
//                }
//            }
//        };
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        mAuth.addAuthStateListener(mAuthListen);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void remove(Car cars){

    }

//    private void SignIn() {
//
//        String email = mEmail.getText().toString();
//        String pass = mPass.getText().toString();
//
//        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {
//
//            Toast.makeText(MainActivity.this, "fields are empty", Toast.LENGTH_LONG).show();
//
//        }else
//            {
//
//            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//
//                    if (!task.isSuccessful()) {
//                        Toast.makeText(MainActivity.this, "Sign in Problem", Toast.LENGTH_LONG).show();
//                    }
//                }
//            });
//
//        }
//    }

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
        }
        return super.onOptionsItemSelected(item);
    }

}
