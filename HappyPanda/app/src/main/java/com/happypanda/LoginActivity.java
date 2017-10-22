package com.happypanda;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private String MyPREFERENCES = "MyPrefs";
    private TextView mEmail;
    private TextView mPassword;
    private Button mSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (TextView)findViewById(R.id.login_email);
        mPassword = (TextView)findViewById(R.id.login_password);
        mSignIn = (Button)findViewById(R.id.login_sign_in);

        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDetails();
            }
        });

    }

    /*
    Function to verify textedit details
     */
    void checkDetails(){

        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();

        if(email!= null){
            doSignIn(email,password);
        }

    }

    /*
    Function to connect to internet and check for login details valid or not
     */
    private void doSignIn(String email,String password) {
        Toast.makeText(getApplicationContext(),"signing in" + email,Toast.LENGTH_SHORT).show();
        if(email.equals("abc@abc.com")){
            SharedPreferences.Editor editor = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE).edit();
            editor.putString("Login", "yes");
            editor.apply();

            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
