package ie.app.carapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import ie.app.carapp.Activity.CustomListview;
import ie.app.carapp.Activity.SearchActivity;
import ie.app.carapp.R;
import ie.app.carapp.models.Car;



public class MainActivity extends AppCompatActivity {

    ListView List;
    private Button searchButton;
    public List<Car> cars;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();


   // ArrayAdapter<String> adapter;
    //ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        cars = new ArrayList<>();
        Car test = new Car("nissan", "testColour", "TestDes", 1);
        Car test2 = new Car("Chevy", "testColour2", "TestDes2", 2);
        Log.i("Cars", test.getCarname());
        cars.add(test);
        cars.add(test2);


        List = findViewById(R.id.listview);
        CustomListview adapter = new CustomListview(this, cars);
        List.setAdapter(adapter);
        List.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Car car = cars.get(i);
                String test = car.getCarname();
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra(test, List.getItemAtPosition(i).toString());
                intent.putExtra("cars.carColour", List.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });
    }

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
            case R.id.action_Search : startActivity (new Intent(this, SearchActivity.class));
               break;
            case R.id.action_AddCar: startActivity (new Intent (this, AddActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart(){
        super.onStart();

        DatabaseReference carRef = mRootRef.child("");
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
