package com.mhova.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Referrers {
    public final List<DomainSightings> referrers;

    @JsonCreator
    public Referrers(@JsonProperty("referrers") final List<DomainSightings> referrers) {
        this.referrers = referrers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((referrers == null) ? 0 : referrers.hashCode());
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
        Referrers other = (Referrers) obj;
        if (referrers == null) {
            if (other.referrers != null)
                return false;
        } else if (!referrers.equals(other.referrers))
            return false;
        return true;
    }
}
