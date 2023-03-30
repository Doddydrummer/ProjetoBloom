package com.projetobloom.tests;

import com.projetobloom.bases.TestBase;
import com.projetobloom.jsonObjects.AdressObject;
import com.projetobloom.jsonObjects.ContactObject;
import com.projetobloom.requests.PostCreateContactRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostCreateContactTests extends TestBase {

    @Test
    public void criarContatoComSucesso() {

        //region Arrange

        String name = "Joao da Silva";
        String email = "joao.silva@gmail.com";
        String phone = "11965789876";

        //region AdressObject
        String street = "Rua Teste";
        String number = "222";
        String neighborhood = "Bairro Teste";
        String city = "Teste";
        String state = "SP";
        String zipCode = "06162280";
        //endregion AdressObject

        String messageEsperado = "Contact saved successfully";
        int statusCodeEsperado = HttpStatus.SC_OK;

        //endregion

        AdressObject adressObject = new AdressObject(street, number, neighborhood, city, state, zipCode);

        ContactObject contactObject = new ContactObject(name, email, phone, adressObject);

        PostCreateContactRequest postCreateContactRequest = new PostCreateContactRequest();
        postCreateContactRequest.setJsonBody(contactObject);

        ValidatableResponse response = postCreateContactRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message", equalTo(messageEsperado));

        //endregion
    }

    @Test
    public void criarContatoComCepInvalido() {

        //region Arrange

        String name = "Joao da Silva";
        String email = "joao.silva@gmail.com";
        String phone = "11965789876";

        //region AdressObject
        String street = "Rua Teste";
        String number = "222";
        String neighborhood = "Bairro Teste";
        String city = "Cidade Teste";
        String state = "TS";
        String zipCode = "0616221180";
        //endregion AdressObject

        String messageEsperado = "The contact could not be saved. Check for errors";
        int statusCodeEsperado = HttpStatus.SC_BAD_REQUEST;

        //endregion

        AdressObject adressObject = new AdressObject(street, number, neighborhood, city, state, zipCode);

        ContactObject contactObject = new ContactObject(name, email, phone, adressObject);

        PostCreateContactRequest postCreateContactRequest = new PostCreateContactRequest();
        postCreateContactRequest.setJsonBody(contactObject);

        ValidatableResponse response = postCreateContactRequest.executeRequest();

        //endregion

        //region Assert

        response.statusCode(statusCodeEsperado);
        response.body("message", equalTo(messageEsperado));

        //endregion
    }
}
