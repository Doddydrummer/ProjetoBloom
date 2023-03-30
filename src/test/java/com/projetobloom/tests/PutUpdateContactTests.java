package com.projetobloom.tests;

import com.projetobloom.bases.TestBase;
import com.projetobloom.jsonObjects.UpdateContactObject;
import com.projetobloom.requests.PutUpdateContactRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class PutUpdateContactTests extends TestBase {

    @Test
    public void atualizarContatoComSucesso() {

        //region Arrange

        String idContato = "5fd7f1b0591c23002f91972b";

        String phone = "11988778787";

        String messageEsperado = "Contact updated successfully";
        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        //region Act

        UpdateContactObject updateContactObject = new UpdateContactObject(phone);

        PutUpdateContactRequest putUpdateContactRequest = new PutUpdateContactRequest(idContato);
        putUpdateContactRequest.setJsonBody(updateContactObject);

        ValidatableResponse response = putUpdateContactRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message", equalTo(messageEsperado));

        //enbdregion
    }

    @Test
    public void atualizarContatoPorIdInexistente() {

        //region Arrange

        String idContato = "aaaaaaaaaaa";

        String phone = "11988778787";

        String messageEsperado = "There was a problem updating the contact";
        int statusCodeEsperado = HttpStatus.SC_BAD_REQUEST;

        //endregion

        //region Act

        UpdateContactObject updateContactObject = new UpdateContactObject(phone);

        PutUpdateContactRequest putUpdateContactRequest = new PutUpdateContactRequest(idContato);
        putUpdateContactRequest.setJsonBody(updateContactObject);

        ValidatableResponse response = putUpdateContactRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message", equalTo(messageEsperado));

        //enbdregion
    }
}
