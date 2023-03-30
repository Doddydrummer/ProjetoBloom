package com.projetobloom.tests;

import com.projetobloom.bases.TestBase;
import com.projetobloom.requests.DeleteContactRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class DeleteContactTests extends TestBase {

    @Test
    public void deletarContatoComSucesso() {

        //region Arrange

        String idContato = "5fd7f8189e85ac0085638f4f";

        String messageEsperado = "Contact excluded successfully";
        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        //region Act

        DeleteContactRequest deleteContactRequest = new DeleteContactRequest(idContato);
        ValidatableResponse response = deleteContactRequest.executeRequest();

       //endregion

       //region Assert

       response.statusCode(statusCodeEsperado);
       response.body("message",  equalTo(messageEsperado));

       //endregion
    }

    @Test
    public void deletarContatoPorIdInexistente() {

        //region Arrange

        String idContato = "aaaaaaaaaa";

        String messageEsperado = "There was a problem deleting the contact";
        int statusCodeEsperado = HttpStatus.SC_BAD_REQUEST;

        //endregion

        //region Act

        DeleteContactRequest deleteContactRequest = new DeleteContactRequest(idContato);
        ValidatableResponse response = deleteContactRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message",  equalTo(messageEsperado));

        //endregion
    }
}
