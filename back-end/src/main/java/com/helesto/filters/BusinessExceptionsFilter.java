package com.helesto.filters;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.helesto.exceptions.BusinessError;
import com.helesto.exceptions.BusinessErrorException;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

@Provider
public class BusinessExceptionsFilter implements ExceptionMapper<BusinessErrorException> {

    private static final Logger LOG = LoggerFactory.getLogger(BusinessExceptionsFilter.class);

    @Override
    public Response toResponse(BusinessErrorException e) {
        LOG.debug("BusinessErrorException", e);

        BusinessError error = e.getBusinessError();

        return Response.status(422).type(MediaType.APPLICATION_JSON_TYPE).entity(error).build();

    }
}
