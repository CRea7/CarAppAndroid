package ie.app.carapp.Activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import ie.app.carapp.R;

public class ListActivity extends AppCompatActivity{

    Toolbar mToolbar;
    TextView textView;


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

    }
}
