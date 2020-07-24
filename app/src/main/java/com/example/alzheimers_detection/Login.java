package com.example.alzheimers_detection;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.concurrent.TimeUnit;

public class Login extends AppCompatActivity {
ImageView tootpimage,loginimage;
String urlloginimage;
    DatabaseReference dbUsers;
EditText usernameT;int flag=0;
    String email,password,verificationId;
    EditText passwordT;
    TextView forgotp;
    Button login;
    TextView signup;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        askPermissions();
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        loginimage=findViewById(R.id.loginimage);
        urlloginimage="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/body.jpeg?alt=media&token=a4407877-110d-48d9-b42f-9f424c9b5028";
        Picasso.with(this).load(urlloginimage).into(loginimage);

        tootpimage=findViewById(R.id.tootpimage);
        usernameT=(EditText) findViewById(R.id.usernameT);
        passwordT=(EditText)findViewById(R.id.passwordT);
forgotp=findViewById(R.id.forgotp);
        login=(Button)findViewById(R.id.login);
        signup=findViewById(R.id.signup);

        usernameT.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                String MobilePattern = "[0-9]+";
                if (usernameT.getText().toString().trim().matches(MobilePattern))
                {
                    tootpimage.setVisibility(View.INVISIBLE);
                    passwordT.setVisibility(View.INVISIBLE);
                    forgotp.setAlpha(0);
                    flag=1;
                }
                else
                {
                    forgotp.setAlpha(1);
                    tootpimage.setVisibility(View.VISIBLE);
                    passwordT.setVisibility(View.VISIBLE);
                    flag=0;
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==0) {
                    loginToAccount();
                }
                else
                {
                    loginToAccountbyPhone();
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Signup.class);
                startActivity(i);




            }
        });






       /* forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */


    }

    public  void loginToAccountbyPhone()
    {
        String MobilePattern = "[0-9]{10}";
        if(!(usernameT.getText().toString().trim().matches(MobilePattern)))
        {
            usernameT.requestFocus();
            usernameT.setError("Please enter valid phone number!");
        }
        else
        {
            Intent i=new Intent(getApplicationContext(),LoginOtpByPhone.class);
            i.putExtra("tophonenumber",""+usernameT.getText().toString().trim());
            startActivity(i);


        }


    }

    public void loginToAccount()
    {
        email=usernameT.getText().toString().trim();
        password=passwordT.getText().toString().trim();
        if(email.isEmpty())
        {
            usernameT.setError("Email id is required!");
            usernameT.requestFocus();
        }
        else if(password.isEmpty())
        {
            passwordT.setError("Email id is required!");
            passwordT.requestFocus();
        }
        else if(password.isEmpty() && email.isEmpty())
        {
            passwordT.setError("Email id is required!");
            passwordT.requestFocus();
            usernameT.setError("Email id is required!");
            usernameT.requestFocus();
        }
        else if(!password.isEmpty() && !email.isEmpty()){
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        private static final String TAG = "Login";
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                if(mAuth.getCurrentUser().isEmailVerified()) {

                                    nextActivity();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(), "Please check your email for verification!",Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(), "No such User exists. Please check username and password.",
                                        Toast.LENGTH_LONG).show();

                            }

                        }
                    });

        }
    }
    public void nextActivity()
    {
        Intent ii=new Intent(getApplicationContext(),HomeScreen.class);
        startActivity(ii);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void requestRecordAudioPermission() {

        String requiredPermission = Manifest.permission.RECORD_AUDIO;

        // If the user previously denied this permission then show a message explaining why
        // this permission is needed
        if (getApplicationContext().checkCallingOrSelfPermission(requiredPermission) == PackageManager.PERMISSION_GRANTED) {

        } else {

            Toast.makeText(getApplicationContext(), "This app needs to record audio through the microphone....", Toast.LENGTH_SHORT).show();
            requestPermissions(new String[]{requiredPermission}, 101);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == 101 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // This method is called when the  permissions are given
        }
    }


    private void askPermissions(){
        String[] permissions = new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.RECORD_AUDIO};
        if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions(this, permissions, 101);
        }
    }
}