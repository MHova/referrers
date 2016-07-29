package com.mhova.core;

import java.net.URL;

import com.mhova.api.DomainSightings;
import com.mhova.api.Referrers;
import com.mhova.db.DomainsDAO;

public class ReferrerHandler {
    private final DomainsDAO domainsDAO;

    public ReferrerHandler(final DomainsDAO domainsDAO) {
        this.domainsDAO = domainsDAO;
    }

    public DomainSightings addReferrer(final URL url) {
        final String domain = url.getHost().toLowerCase();
        
        final int domainCount = domainsDAO.recordSighting(domain);
        
        return new DomainSightings(domain, domainCount);
    }

    public Referrers getTopThreeReferrers() {
        return new Referrers(domainsDAO.getTopThreeDomains());
    }
}
