package com.mhova.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DomainSightings {
    @JsonProperty
    public final String domain;

    @JsonProperty
    public final int sightings;

    public DomainSightings(final String domain, final int sightings) {
        this.domain = domain;
        this.sightings = sightings;
    }
}
