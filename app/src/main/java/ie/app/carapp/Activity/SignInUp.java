package ie.app.carapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ie.app.carapp.R;

public class SignInUp extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPass;
    private Button mLog;
    private Button mUp;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListen;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinup);

        mEmail = findViewById(R.id.SignEmail);
        mPass = findViewById(R.id.SignPass);
        mLog = findViewById(R.id.SignButton);
        mAuth = FirebaseAuth.getInstance();
        mUp = findViewById(R.id.SignUpBtn);

       mUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               launchActivity();
           }
       });



        mLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SignIn();
            }
        });

        //checks to see if user is signed in if they are sends them to main page
        mAuthListen = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() != null){

                    startActivity(new Intent(SignInUp.this, MainActivity.class));

                }
            }
        };
    }

    private void launchActivity() {

        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListen);
    }

    private void SignIn() {

        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        //checks to see if fields have values in them.
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {

            Toast.makeText(SignInUp.this, "fields are empty", Toast.LENGTH_LONG).show();

        }else
        {
            //takes values from fields and signs the user in if it matches a registered user.
            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (!task.isSuccessful()) {
                        Toast.makeText(SignInUp.this, "Sign in Problem", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }
}