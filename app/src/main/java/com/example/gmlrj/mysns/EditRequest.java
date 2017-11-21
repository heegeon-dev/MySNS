package com.example.gmlrj.mysns;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class EditRequest extends StringRequest {
    final static private String URL = "http://172.31.42.158/";
    private Map<String, String> parameters;

    public EditRequest(String title, String text, Response.Listener<String> listener) {
        super(Method.POST, URL+"Edit.php", listener, null);
        parameters = new HashMap<>();
        parameters.put("title", title);
        parameters.put("text", text);

    }

    @Override
    public Map<String, String> getParams(){
        return parameters;
    }
}
