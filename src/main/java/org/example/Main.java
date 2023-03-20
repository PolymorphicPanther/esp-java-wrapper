package org.example;

import org.example.authentication.BasicTokenCredentialAuthProvider;

import java.util.Arrays;

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

        var areasNearBy = client
                .area()
                .nearBy(-26.0269658, 28.0137339)
                .build()
                .get();

        System.out.println(Arrays.stream(areasNearBy.areas()));

        var areasSearch = client
                .area()
                .search("kokstad")
                .build()
                .get();

        System.out.println(areasSearch);

        var allowance = client
                .allowance()
                .check()
                .build()
                .get();

        System.out.println(allowance);


    }
}

