package ie.app.carapp.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ie.app.carapp.R;

public class ListActivity extends AppCompatActivity{

    Toolbar mToolbar;
    TextView textView;

    Button BtnDelete = findViewById(R.id.BtnDelete);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_listclick);
        textView = findViewById(R.id.listItem);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            textView.setText(bundle.getString("Car Name"));
        }


        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

//        BtnDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                deleteCar(CarId);
//            }
//        });

    }

//    private void deleteCar(String CarId){
//
//        DatabaseReference dbRed = FirebaseDatabase.getInstance().getReference("Car").child(CarId);
//
//        dbRed.removeValue();
//
//        Toast.makeText(this, "car is hopefully gone", Toast.LENGTH_LONG).show();
//    }
}
