package com.projetobloom.requests;

import com.projetobloom.bases.RequestRestBase;
import io.restassured.http.Method;

public class PutUpdateContactRequest extends RequestRestBase {

    public PutUpdateContactRequest(String idContato) {

        requestService = "/contact/" + idContato;
        method = Method.PUT;
    }
    public void setJsonBody(Object object){this.jsonBody = object;}
}
