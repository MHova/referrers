package com.mhova.resources;

import java.net.MalformedURLException;
import java.net.URL;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.codahale.metrics.annotation.Timed;
import com.mhova.api.Referrer;
import com.mhova.api.Referrers;
import com.mhova.core.ReferrerHandler;

@Path("/referrers")
public class ReferrersResource {
    private final ReferrerHandler referrerHandler;

    public ReferrersResource(ReferrerHandler referrerHandler) {
        this.referrerHandler = referrerHandler;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Timed
    public Response addReferrer(@NotNull @Valid final Referrer referrer) {
        URL url = null;

        try {
            url = new URL(referrer.url);
        } catch (final MalformedURLException e) {
            return Response.status(Status.BAD_REQUEST).entity(referrer.url + " is not a valid url").build();
        }

        return Response.ok(referrerHandler.addReferrer(url)).build();
    }

    @GET
    @Path("/top-three")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public Referrers topThreeReferrers() {
        return referrerHandler.getTopThreeReferrers();
    }
}
