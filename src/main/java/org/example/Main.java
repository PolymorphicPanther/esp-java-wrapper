package org.example;

import org.example.authentication.BasicTokenCredentialAuthProvider;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        var authProvider = new BasicTokenCredentialAuthProvider("xxxx-xxxx-xxxx");

        var client = new EspClient.Builder()
                .authenticationProvider(authProvider)
                .build();


        var areaInfo = client
                .area()
                .info("eskde-10-fourwaysext10cityofjohannesburggauteng")
                .build()
                .get();


        System.out.println(areaInfo);


    }
}

