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

    //authentication
    private EditText mEmail;
    private EditText mPass;
    private Button mLog;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListen;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinup);


        //more authenticatio
        mEmail = findViewById(R.id.SignEmail);
        mPass = findViewById(R.id.SignPass);
        mLog = findViewById(R.id.SignButton);
        mAuth = FirebaseAuth.getInstance();

        mLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SignIn();
            }
        });

        mAuthListen = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if(firebaseAuth.getCurrentUser() != null){

                    startActivity(new Intent(SignInUp.this, MainActivity.class));

                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthListen);
    }

    private void SignIn() {

        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pass)) {

            Toast.makeText(SignInUp.this, "fields are empty", Toast.LENGTH_LONG).show();

        }else
        {

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