package com.mhova.resources;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

@Path("/referrers")
public class ReferrersResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    public DomainSightings addReferrer() {
        return new DomainSightings("helloNurse", 5);
    }
}
