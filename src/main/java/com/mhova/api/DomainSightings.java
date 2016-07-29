package com.mhova.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DomainSightings {
    
    public final String domain;

    public final int sightings;

    @JsonCreator
    public DomainSightings(@JsonProperty("domain") final String domain, @JsonProperty("sightings") final int sightings) {
        this.domain = domain;
        this.sightings = sightings;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((domain == null) ? 0 : domain.hashCode());
        result = prime * result + sightings;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DomainSightings other = (DomainSightings) obj;
        if (domain == null) {
            if (other.domain != null)
                return false;
        } else if (!domain.equals(other.domain))
            return false;
        if (sightings != other.sightings)
            return false;
        return true;
    }
}
