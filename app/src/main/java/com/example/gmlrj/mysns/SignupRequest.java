package com.example.gmlrj.mysns;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class SignupRequest extends StringRequest {
    final static private String URL = "http://172.30.1.41/Join.php";
    private Map<String, String> parameters;

    public SignupRequest(String userID, String userPW, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPW", userPW);

    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
