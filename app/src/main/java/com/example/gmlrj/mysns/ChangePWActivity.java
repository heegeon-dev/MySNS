package com.example.gmlrj.mysns;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ChangePWActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pw);

        final EditText et_pw = (EditText) findViewById(R.id.et_pw);
        final EditText et_new = (EditText) findViewById(R.id.et_new);
        final EditText et_check = (EditText) findViewById(R.id.et_check);

        Button bt_ok = (Button) findViewById(R.id.bt_ok);

        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userPW = et_pw.getText().toString();
                String newPW = et_new.getText().toString();
                String checkPW = et_check.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(ChangePWActivity.this, SettingFragment.class);
                                ChangePWActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builer = new AlertDialog.Builder(ChangePWActivity.this);
                                builer.setMessage("비밀번호 바꾸기에 실패하였습니다.")
                                        .setNegativeButton("다시 시도", null)
                                        .create()
                                        .show();
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                ChangePWRequest changePWRequest = new ChangePWRequest(userPW, newPW, checkPW, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ChangePWActivity.this);
                queue.add(changePWRequest);
            }
        });
    }
}
