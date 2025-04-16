package org.ahmet.wiremock;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WireMockExample {

    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(8080);
        wireMockServer.start();

        wireMockServer.stubFor(get(urlEqualTo("/hello"))
            .willReturn(aResponse()
                .withBody("Hello, WireMock!")));

        System.out.println("WireMock server running on port 8080");
    }
}