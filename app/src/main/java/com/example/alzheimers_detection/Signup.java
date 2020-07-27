package com.example.alzheimers_detection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;


public class Signup extends AppCompatActivity {

    DatabaseReference dbUsers;
    String flag="email";

    RadioGroup radiogroup;
    TextView signupwithphonenumber;
    String username,password,confirmpassword,firstname,lastname,gender;
    RadioButton female,male,other;
    EditText usernameT,passwordT,firstnameT,lastnameT,confirmpasswordT;
    Button next;
    public FirebaseAuth mAuth;
    DatePicker birthdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        radiogroup=findViewById(R.id.radiogroup);
        other=findViewById(R.id.other);
        signupwithphonenumber=findViewById(R.id.signupwithphonenumber);
        female=findViewById(R.id.female);
        male=findViewById(R.id.male);
        usernameT=findViewById(R.id.username);
        passwordT=findViewById(R.id.password);
        firstnameT=findViewById(R.id.firstname);
        lastnameT=findViewById(R.id.lastname);
        confirmpasswordT=findViewById(R.id.confirmpassword);
        next=(Button)findViewById(R.id.next);
        birthdate=findViewById(R.id.birthdate);

        signupwithphonenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SignupPhone.class);
                startActivity(i);
            }
        });

        next.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                username=usernameT.getText().toString().trim();
                password=passwordT.getText().toString();
                confirmpassword=confirmpasswordT.getText().toString();
                firstname=firstnameT.getText().toString();
                if(username.isEmpty())
                {
                    usernameT.setError("Username is required!");
                    usernameT.requestFocus();
                }
                else if(password.isEmpty())
                {
                    passwordT.setError("Password id is required!");
                    passwordT.requestFocus();
                }
                else if(password.isEmpty() && username.isEmpty())
                {
                    passwordT.setError("Password id is required!");
                    passwordT.requestFocus();
                    usernameT.setError("Email id is required!");
                    usernameT.requestFocus();
                }
                else if(!password.equals(confirmpassword))
                {
                    confirmpasswordT.setError("Confirm password doesn't match!");
                    confirmpasswordT.requestFocus();
                }

                else {

                    Pattern pattern = Patterns.EMAIL_ADDRESS;
                    if(pattern.matcher(usernameT.getText().toString().trim()).matches()==true)
                    {
                        createAccount(username,password);
                    }
                    else
                    {
                        usernameT.requestFocus();
                        usernameT.setError("Please enter valid email address!");
                    }



                }
            }
        });
        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.


        //-------------------Firebase-----------------------
        mAuth = FirebaseAuth.getInstance();

    }
    public void createAccount(String email, String password)
    {
        Log.d("mytag","reached createaccount!!!!!!!!");
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    private static final String TAG = "Signup";

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser fuser;

                            fuser = mAuth.getCurrentUser();
                            //updateUI(user);
                            //-----------------------------------storing data in database
                            fuser.sendEmailVerification()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Log.d(TAG, "Email for verification sent.........");
                                                Toast.makeText(getApplicationContext(),"Signed up successfully! Please check your email for verification.",Toast.LENGTH_LONG).show();

                                            }
                                        }
                                    });
                            nextactivity(fuser);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Signup failed. User with same email address must already exist.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });


    }
    public void nextactivity(FirebaseUser fuser)
    {
        Log.d("mytag2","reached nextactivityyyyyyy!!!!!!!!");
        String QRC;
        QRC="0";
        dbUsers= FirebaseDatabase.getInstance().getReference("Users");
        String bdate=birthdate.getDayOfMonth()+"-"+birthdate.getMonth()+"-"+birthdate.getYear();

        User user1=new User(firstnameT.getText().toString().trim(),lastnameT.getText().toString().trim(),male.isSelected()?"Male":female.isSelected()?"Female":"Not mentionable",username,bdate,QRC);
        String id=fuser.getUid();
        dbUsers.child(id).setValue(user1);

        Intent i=new Intent(getApplicationContext(),FamilyHistory.class);
        i.putExtra("flag",flag);
        startActivity(i);
    }

}