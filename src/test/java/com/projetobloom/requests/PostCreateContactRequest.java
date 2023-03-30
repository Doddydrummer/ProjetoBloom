package com.projetobloom.requests;

import com.projetobloom.bases.RequestRestBase;
import io.restassured.http.Method;

public class PostCreateContactRequest extends RequestRestBase {

    public PostCreateContactRequest() {

        requestService = "/contact";
        method = Method.POST;
    }
    public void setJsonBody(Object object){this.jsonBody = object;}
}
