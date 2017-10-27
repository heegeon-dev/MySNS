package com.example.gmlrj.mysns;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;


public class SignupActivity extends AppCompatActivity {

    EditText et_id, et_pw, et_pw_chk;
    String sId, sPw, sPw_chk;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        final EditText et_id = (EditText) findViewById(R.id.et_id);
        final EditText et_pw = (EditText) findViewById(R.id.et_pw);
        final EditText et_pw_chk = (EditText) findViewById(R.id.et_pw_chk);

        Button bt_join = (Button) findViewById(R.id.bt_Join);

        bt_join.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String userID = et_id.getText().toString();
                String userPW = et_pw.getText().toString();
                String userPWchk = et_pw_chk.getText().toString();

                if (userPW.equals(userPWchk)) {

                    Response.Listener<String> responseListener = new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success) {
                                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(SignupActivity.this);
                                    builder.setMessage("회원 등록에 성공했습니다.")
                                            .setPositiveButton("확인", null)
                                            .create()
                                            .show();

                                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                    SignupActivity.this.startActivity(intent);
                                } else {
                                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(SignupActivity.this);
                                    builder.setMessage("회원 등록에 실패했습니다.")
                                            .setNegativeButton("다시 시도", null)
                                            .create()
                                            .show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    SignupRequest signupRequest = new SignupRequest(userID, userPW, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(SignupActivity.this);
                    queue.add(signupRequest);
                }
                else
                {
                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(SignupActivity.this);
                    builder.setMessage("비밀번호를 확인하시오.")
                            .setPositiveButton("확인", null)
                            .create()
                            .show();
                }
            }

        });
    }
}

