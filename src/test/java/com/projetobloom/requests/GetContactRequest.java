package com.projetobloom.requests;

import com.projetobloom.bases.RequestRestBase;
import io.restassured.http.Method;

public class GetContactRequest extends RequestRestBase {

    public GetContactRequest(String idContato) {

        requestService = "/contact/" + idContato;
        method = Method.GET;
    }
}
