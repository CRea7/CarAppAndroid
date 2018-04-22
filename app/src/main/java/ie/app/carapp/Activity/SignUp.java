package ie.app.carapp.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ie.app.carapp.R;
import ie.app.carapp.models.User;

public class SignUp extends AppCompatActivity {

    private EditText uEmail;
    private EditText uPass;
    private EditText uConfPass;
    private Button SignUp;

    private FirebaseDatabase db;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("Users");

        //all edit texts on signup page
        uEmail = findViewById(R.id.UpEmail);
        uPass = findViewById(R.id.UpPass);
        uConfPass = findViewById(R.id.UpPassConf);
        //Button on signup page
        SignUp = findViewById(R.id.UpButton);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final User user = new User(uEmail.getText().toString(),
                        uPass.getText().toString());

                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(user.getEmail()).exists()) {
                            Toast.makeText(SignUp.this, "This email is already registered!", Toast.LENGTH_LONG).show();
                        } else {
                            dbRef.child(user.getEmail()).setValue(user);
                            Toast.makeText(SignUp.this, "Registration was a success!", Toast.LENGTH_LONG).show();

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(SignUp.this, "Error...", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
