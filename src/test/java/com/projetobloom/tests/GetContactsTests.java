package com.projetobloom.tests;

import com.projetobloom.bases.TestBase;
import com.projetobloom.requests.GetContactsRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class GetContactsTests extends TestBase {

    @Test
    public void buscarTodosContatosComSucesso() {

        //region Arrange

        String messageEsperado = "records found for your search criteria";

        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        //region Act

        GetContactsRequest getContactsRequest = new GetContactsRequest();
        ValidatableResponse response = getContactsRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message", containsString(messageEsperado));

        //endregion
    }

    @Test
    public void buscarContatosPorNomeComSucesso() {

        //region Arrange

        String nomeContato = "Fabricio";
        String messageEsperado = "1 records found for your search criteria";

        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        //region Act

        GetContactsRequest getContactsRequest = new GetContactsRequest(nomeContato);
        ValidatableResponse response = getContactsRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("data.name[0]", equalTo(nomeContato),
                "message", equalTo(messageEsperado));

        //endregion
    }

    @Test
    public void buscarContatosPorNomeInexistente() {

        //region Arrange

        String nomeContato = "TSadsadad";

        int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;

        //endregion

        //region Act

        GetContactsRequest getContactsRequest = new GetContactsRequest(nomeContato);
        ValidatableResponse response = getContactsRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);

        //endregion
    }
}
