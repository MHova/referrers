package com.mhova.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.codahale.metrics.annotation.Timed;

@Path("/referrers")
public class ReferrersResource {
    @GET
    @Timed
    public String helloNurse() {
        return "Hello nurse!";
    }
}
