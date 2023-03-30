package com.projetobloom.jsonObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactObject {

    private String name;
    private String email;
    private String phone;

    AdressObject address;
}
