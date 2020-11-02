package com.helesto.api;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title="Client Management",
                version = "0.1.0-SNAPSHOT",
                contact = @Contact(
                        name = "Client Management Github",
                        url = "https://github.com/felipewind/client-management"))
)
public class GeneralDefinition extends Application {}
