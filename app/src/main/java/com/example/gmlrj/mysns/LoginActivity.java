package com.example.gmlrj.mysns;

import android.Manifest;
import android.app.AlertDialog;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText et_id = (EditText) findViewById(R.id.et_id);
        final EditText et_pw = (EditText) findViewById(R.id.et_pw);

         Button bt_login = (Button) findViewById(R.id.bt_login);
         Button bt_signup = (Button) findViewById(R.id.bt_signup);

        bt_signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent signupIntent = new Intent(LoginActivity.this, SignupActivity.class);
                LoginActivity.this.startActivity(signupIntent);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String userID = et_id.getText().toString();
                String userPW = et_pw.getText().toString();

                int permissionCheck = ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (permissionCheck == getPackageManager().PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(LoginActivity.this, new String[]{android.Manifest.permission.CAMERA}, 0);
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            int user_num = jsonResponse.getInt("user_num");
                            if(success) {
                                Intent intent = new Intent(LoginActivity.this, NaviActivity.class);
                                LoginActivity.this.startActivity(intent);

                                User_num un  = (User_num)getApplication();
                                un.setState(user_num);

                                Toast.makeText(getApplicationContext(),String.valueOf(un.getState()) , Toast.LENGTH_LONG).show();


                            }
                            else{
                                AlertDialog.Builder builer = new AlertDialog.Builder(LoginActivity.this);
                                builer.setMessage("로그인에 실패하였습니다.")
                                        .setNegativeButton("다시 시도",null)
                                        .create()
                                        .show();
                            }


                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPW, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}