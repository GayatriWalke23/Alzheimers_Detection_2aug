

//added images to firebase storage
package com.example.alzheimers_detection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.regex.Pattern;

public class Settings extends AppCompatActivity {
    ImageView usernamepencil,passwordpencil,firstnamepencil,lastnamepencil,soundbutton;
    ImageView profile,musicgif  ,tool,logininsideprofile,emailview,passwordsettings,birthdateview,namesettings;//set,login
    String urlnamesettings,urlprofile,urlpasswordsettings,urltool,urlbirthdateview,urlemailview,urllogininsideprofile,urlmusicgif,urllnamepencil,urlfnamepencil,urlusernamepencil,urlpasswordpencil;
    TextView soundstatus;
    EditText username,password,firstname,lastname;
    Button save;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    FirebaseAuth.AuthStateListener firebaseAuthListener;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference dbref;
    int flagPassword=0,soundflag=0,flagusername=0,flagfname=0,flaglname=0,count=0;
    String uid,fname,lname,pemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        usernamepencil=findViewById(R.id.usernamepencil);
        passwordpencil=findViewById(R.id.passwordpencil);
        firstnamepencil=findViewById(R.id.firstnamepencil);
        lastnamepencil=findViewById(R.id.lastnamepencil);
        soundbutton=findViewById(R.id.soundbutton);
        soundstatus=findViewById(R.id.soundstatus);
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        password=findViewById(R.id.password);
        username=findViewById(R.id.username);
        save=findViewById(R.id.save);
        profile=findViewById(R.id.profile);
        musicgif=findViewById(R.id.musicgif);
        logininsideprofile=findViewById(R.id.logininsideprofile);
        emailview=findViewById(R.id.emailview);
        passwordsettings=findViewById(R.id.passwordsettings);
        birthdateview=findViewById(R.id.birthdateview);
        namesettings=findViewById(R.id.namesettings);
        tool=findViewById(R.id.tool);

        lastname.setCursorVisible(false);

        firstname.setClickable(false);
        password.setClickable(false);
        username.setCursorVisible(false);



        urlbirthdateview="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/birthdate.jpg?alt=media&token=78199019-d0d0-42d2-84a0-98110c37f554";
        urlemailview="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/email.jpg?alt=media&token=15dc7155-dae7-4a86-bebf-e8deeeb7b75e";
        urlfnamepencil="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/pencil.jpg?alt=media&token=2fbe316b-82f2-4707-89ac-6334c55e32dd";
        urllnamepencil="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/pencil.jpg?alt=media&token=2fbe316b-82f2-4707-89ac-6334c55e32dd";
        urllogininsideprofile="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/login.gif?alt=media&token=4b42a379-423b-47ca-b4e8-cb1dbe8399ac";
        urlnamesettings="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/namesettings.jpg?alt=media&token=dac5ca5b-f4ad-4060-9487-4a6284b927f1";
        urltool="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/set.png?alt=media&token=23f6091b-ce66-4859-9800-7bc791cea179";
        urlprofile="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/profile1.gif?alt=media&token=7980781f-c900-4835-94a3-192652898578";
        urlpasswordsettings="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/passwordsettings.jpg?alt=media&token=f28ab569-ac95-4527-a87d-98e5eccb7021";
        urlmusicgif="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/gifmusic.gif?alt=media&token=bd95e3d7-e8aa-43f1-a7e9-7e5da807f377";
        urlusernamepencil="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/pencil.jpg?alt=media&token=2fbe316b-82f2-4707-89ac-6334c55e32dd";
        urlpasswordpencil="https://firebasestorage.googleapis.com/v0/b/alzheimers-detection.appspot.com/o/pencil.jpg?alt=media&token=2fbe316b-82f2-4707-89ac-6334c55e32dd";

        Picasso.with(this).load(urlbirthdateview).into(birthdateview);
        Picasso.with(this).load(urlemailview).into(emailview);
        Picasso.with(this).load(urlfnamepencil).into(firstnamepencil);
        Picasso.with(this).load(urllnamepencil).into(lastnamepencil);
        Picasso.with(this).load(urllogininsideprofile).into(logininsideprofile);
        Picasso.with(this).load(urlnamesettings).into(namesettings);
        Picasso.with(this).load(urltool).into(tool);
        Picasso.with(this).load(urlprofile).into(profile);
        Picasso.with(this).load(urlpasswordsettings).into(passwordsettings);
        Picasso.with(this).load(urlmusicgif).into(musicgif);
        Picasso.with(this).load(urlusernamepencil).into(usernamepencil);
        Picasso.with(this).load(urlpasswordpencil).into(passwordpencil);


        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        uid=firebaseAuth.getCurrentUser().getUid();
        user=firebaseAuth.getCurrentUser();

        dbref=firebaseDatabase.getInstance().getReference("Users/"+uid);
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User myuser=new User();
                Log.d("my uid",""+uid);
                myuser.setFirstname(dataSnapshot.child("firstname").getValue(String.class));
                myuser.setUsername(dataSnapshot.child("email").getValue(String.class));
                myuser.setLastname(dataSnapshot.child("lastname").getValue(String.class));
                fname=myuser.getFirstname();
                lname=myuser.getLastname();
                pemail=myuser.getUsername();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        firstname.setHint(fname);
        lastname.setHint(lname);
        password.setHint("");
        username.setHint(pemail);

        usernamepencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagusername==0) {
                    username.setClickable(true);
                    username.setCursorVisible(true);
                }
                else{
                    username.setClickable(false);
                    username.setCursorVisible(false);
                }
                flagusername=flagusername==0?1:0;

            }
        });


        soundbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (soundflag==0) {
                    //music stop
                    AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
                    soundstatus.setText("Off");
                    soundbutton.setImageResource(R.drawable.off);
                }
                else{
                    //music on
                    AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
                    amanager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
                    soundstatus.setText("Off");
                    soundbutton.setImageResource(R.drawable.on);
                }
                soundflag=soundflag==0?1:0;
            }
        });




        lastnamepencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flaglname==0) {
                    lastname.setClickable(true);
                    lastname.setCursorVisible(true);
                }
                else{
                    lastname.setClickable(false);
                    lastname.setCursorVisible(false);
                }
                flaglname=flaglname==0?1:0;
            }
        });

        firstnamepencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagfname==0) {
                    firstname.setClickable(true);
                    firstname.setCursorVisible(true);
                }
                else{
                    firstname.setClickable(false);
                    firstname.setCursorVisible(false);
                }
                flagfname=flagfname==0?1:0;
            }
        });

        passwordpencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagPassword==0) {
                    password.setClickable(true);
                    password.setCursorVisible(true);
                }
                else{
                    password.setClickable(false);
                    password.setCursorVisible(false);
                }
                flagPassword=flagPassword==0?1:0;
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=3;
                if (flagPassword==1)
                {
                    if(!(password.getText().toString().trim()==""))
                    {
                        if(password.getText().toString().trim().length()<6)
                        {
                            password.requestFocus();
                            password.setError("Password is too short.Must have 6 characters.");
                        }
                        else
                        {
                            user.updatePassword(password.getText().toString().trim());

                        }
                    }
                }

                if (flagusername==1)
                {
                    Pattern pattern = Patterns.EMAIL_ADDRESS;
                    if (username.getText().toString().trim()=="" ||pattern.matcher(username.getText().toString().trim()).matches()==false)
                    {
                        username.requestFocus();
                        username.setError("Please enter valid email!");
                        count--;
                    }

                }



                if(flagfname==1)
                {
                    if(firstname.getText().toString().trim()=="")
                    {
                        firstname.requestFocus();
                        firstname.setError("First name can't be blank!");
                        count--;
                    }

                }


                if(flaglname==1)
                {
                    if(lastname.getText().toString().trim()=="")
                    {
                        lastname.requestFocus();
                        lastname.setError("Last name can't be blank!");
                        count--;
                    }

                }

                if(count==3)
                {
                    saveallchanges();
                    Intent i=new Intent(getApplicationContext(),HomeScreen.class);
                    startActivity(i);
                }
            }
        });
    }
    public void saveallchanges()
    {
        dbref=firebaseDatabase.getInstance().getReference("Users/"+uid);
        if (flagfname==1)
            dbref.child("firstname").setValue(firstname.getText().toString().trim());
        Log.d("fname",""+firstname.getText().toString().trim());
        if (flaglname==1)
            dbref.child("lastname").setValue(lastname.getText().toString().trim());
        if(flagusername==1) {
            dbref.child("username").setValue(username.getText().toString().trim());
            user.updateEmail(username.getText().toString().trim());
        }
    }
}