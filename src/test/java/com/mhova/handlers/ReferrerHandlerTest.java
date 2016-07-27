package com.mhova.handlers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import com.mhova.api.DomainSightings;

public class ReferrerHandlerTest {
    private ReferrerHandler classUnderTest;
    
    @Before
    public void setup() {
        classUnderTest = new ReferrerHandler();
    }
    
    @Test
    public void just_a_stub() {
        final DomainSightings result = classUnderTest.addReferrer(makeURL("http://google.com/blahbitty/blah"));
        assertThat(result.domain, equalTo("google.com"));
        assertThat(result.sightings, equalTo(5));
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
