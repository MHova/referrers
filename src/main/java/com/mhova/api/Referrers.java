package com.mhova.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Referrers {
    @JsonProperty
    public final List<DomainSightings> referrers;

    public Referrers(final List<DomainSightings> referrers) {
        this.referrers = referrers;
    }
}
