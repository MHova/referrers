package com.mhova.handlers;

import java.net.URL;

import com.mhova.api.DomainSightings;
import com.mhova.db.ReferrersDAO;

public class ReferrerHandler {
    private final ReferrersDAO referrersDAO;

    public ReferrerHandler(final ReferrersDAO referrersDAO) {
        this.referrersDAO = referrersDAO;
    }

    public DomainSightings addReferrer(final URL url) {
        final String domain = url.getHost();
        
        referrersDAO.insert(url.toString(), domain);
        final int domainCount = referrersDAO.countDomains(domain);
        
        return new DomainSightings(domain, domainCount);
    }
}
