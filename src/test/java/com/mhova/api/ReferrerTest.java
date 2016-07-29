package com.mhova.api;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;

public class ReferrerTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    
    @Test
    public void deserializesFromJSON() throws Exception {
        final Referrer referrer = new Referrer("some string");
        assertThat(MAPPER.readValue(fixture("fixtures/referrer.json"), Referrer.class)).isEqualTo(referrer);
    }
}
