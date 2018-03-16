package ie.app.carapp.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import ie.app.carapp.R;

public class ListActivity extends AppCompatActivity{

    Toolbar mToolbar;
    TextView textView;
    TextView textColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_listclick);

//        textView = findViewById(R.id.textView3);
//        String TempHolder = getIntent().getStringExtra(test);
//        textView.setText(TempHolder);
//
//        textColour = findViewById(R.id.textView9);
//        String What = getIntent().getStringExtra("cars.carColour");
//        textColour.setText(What);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

    }
}
