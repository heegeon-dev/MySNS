package com.example.gmlrj.mysns;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class LoginRequest extends StringRequest {
    final static private String URL = "http://172.31.42.29/";
    private Map<String, String> parameters;

    public LoginRequest(String userID, String userPW, Response.Listener<String> listener) {
        super(Method.POST, URL+"Login.php", listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPW", userPW);

    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
