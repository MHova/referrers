package com.mhova.handlers;

import java.net.URL;

import com.mhova.api.DomainSightings;
import com.mhova.db.DomainsDAO;

public class ReferrerHandler {
    private final DomainsDAO domainsDAO;

    public ReferrerHandler(final DomainsDAO domainsDAO) {
        this.domainsDAO = domainsDAO;
    }

    public DomainSightings addReferrer(final URL url) {
        final String domain = url.getHost().toLowerCase();
        
        domainsDAO.insertOrIncrementCount(domain);
        final int domainCount = domainsDAO.getCount(domain);
        
        return new DomainSightings(domain, domainCount);
    }
}
