package com.mhova.handlers;

import java.net.URL;

import com.mhova.api.DomainSightings;

public class ReferrerHandler {
    public DomainSightings addReferrer(final URL url) {
        return new DomainSightings(url.getHost(), 5);
    }
}
