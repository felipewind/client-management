package com.helesto.filters;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.helesto.exceptions.BusinessError;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

@Provider
public class ExceptionsFilter implements ExceptionMapper<Exception> {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionsFilter.class);

    @Override
    public Response toResponse(Exception e) {
        LOG.error("Exception", e);

        BusinessError error = new BusinessError(1, "System error");

        return Response.status(500).type(MediaType.APPLICATION_JSON_TYPE).entity(error).build();

        
    }
}
