package com.mhova.api;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.jackson.Jackson;

public class DomainSightingsTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void serialization() throws IOException {
        final DomainSightings ds = new DomainSightings("steady as the beating drum", 88);
        
        final String expected = MAPPER.writeValueAsString(MAPPER.readValue(fixture("fixtures/domainSightings.json"), DomainSightings.class));
        
        assertThat(MAPPER.writeValueAsString(ds)).isEqualTo(expected);
    }
}
