package com.mhova.handlers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.mhova.api.DomainSightings;
import com.mhova.db.ReferrersDAO;

public class ReferrerHandlerTest {
    private ReferrerHandler classUnderTest;

    @Mock
    private ReferrersDAO    dao;

    @Before
    public void setup() {
        initMocks(this);
        classUnderTest = new ReferrerHandler(dao);
    }

    @Test
    public void insert_and_count_domains() {
        final String url = "http://google.com/blahbitty/blah";
        final String domain = "google.com";
        
        when(dao.countDomains(domain)).thenReturn(10);

        final DomainSightings result = classUnderTest.addReferrer(makeURL(url));
        
        verify(dao).insert(url, domain);
        
        assertThat(result.domain, equalTo(domain));
        assertThat(result.sightings, equalTo(10));
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
