package com.mhova.handlers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.mhova.api.DomainSightings;
import com.mhova.api.Referrers;
import com.mhova.db.DomainsDAO;

public class ReferrerHandlerTest {
    private ReferrerHandler classUnderTest;

    @Mock
    private DomainsDAO      dao;

    @Before
    public void setup() {
        initMocks(this);
        classUnderTest = new ReferrerHandler(dao);
    }

    @Test
    public void insert_and_count_domains() {
        final String domain = "google.com";
        final String url = "http://" + domain + "/blahbitty/blah";

        when(dao.recordSighting(domain)).thenReturn(10);

        final DomainSightings result = classUnderTest.addReferrer(makeURL(url));
        
        assertThat(result.domain).isEqualTo(domain);
        assertThat(result.sightings).isEqualTo(10);
    }

    @Test
    public void domain_names_are_case_insensitive() {
        final String domain = "WwW.GooGLE.cOm";
        final String url = "http://" + domain + "/blahbitty/blah";

        classUnderTest.addReferrer(makeURL(url));

        verify(dao).recordSighting(domain.toLowerCase());
    }
    
    @Test
    public void get_top_three_referrers() {
        final List<DomainSightings> list = new LinkedList<>();
        list.add(new DomainSightings("blah", 10));
        list.add(new DomainSightings("whee", 44));
        list.add(new DomainSightings("yay", 3));
        
        when(dao.getTopThreeDomains()).thenReturn(list);
        
        final Referrers result = classUnderTest.getTopThreeReferrers();
        
        assertThat(result.referrers).isEqualTo(list);
    }

    private URL makeURL(final String s) {
        try {
            return new URL(s);
        } catch (final MalformedURLException e) {
            // wat
            throw new RuntimeException(e);
        }
    }
}
