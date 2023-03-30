package com.projetobloom.requests;

import com.projetobloom.bases.RequestRestBase;
import io.restassured.http.Method;

public class DeleteContactRequest extends RequestRestBase {

    public DeleteContactRequest(String idContato) {

        requestService = "/contact/" + idContato;
        method = Method.DELETE;
    }
}
