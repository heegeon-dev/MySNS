package com.example.gmlrj.mysns;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ChangePWRequest extends StringRequest {
    final static private String URL = "http://192.168.0.1/";
    private Map<String, String> parameters;

    public ChangePWRequest(String userPW, String newPW, String checkPW, Response.Listener<String> listener) {
        super(Method.POST, URL+"Change.php", listener, null);
        parameters = new HashMap<>();
        parameters.put("userPW", userPW);
        parameters.put("newPW", newPW);
        parameters.put("checkPW", checkPW);
    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
