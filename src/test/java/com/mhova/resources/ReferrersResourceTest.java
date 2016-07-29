package com.mhova.resources;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.ClassRule;
import org.junit.Test;

import com.mhova.api.DomainSightings;
import com.mhova.api.Referrer;
import com.mhova.api.Referrers;
import com.mhova.core.ReferrerHandler;

import io.dropwizard.testing.junit.ResourceTestRule;

public class ReferrersResourceTest {

    private static final ReferrerHandler handler   = mock(ReferrerHandler.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new ReferrersResource(handler))
            .build();

    @After
    public void tearDown() {
        reset(handler);
    }

    @Test
    public void top_three() {
        final List<DomainSightings> domainSightings = new LinkedList<>();
        domainSightings.add(new DomainSightings("the thing I love about rivers is", 9));
        final Referrers referrers = new Referrers(domainSightings);
        when(handler.getTopThreeReferrers()).thenReturn(referrers);

        assertThat(resources.client().target("/referrers/top-three").request().get(Referrers.class))
                .isEqualTo(referrers);
    }

    @Test
    public void add_referrer() throws MalformedURLException {
        final String url = "http://www.example.com/hooray";

        final DomainSightings domainSightings = new DomainSightings("asdf", 88);
        when(handler.addReferrer(new URL(url))).thenReturn(domainSightings);

        final Response response = resources.client().target("/referrers").request().post(Entity.json(new Referrer(url)));

        assertThat(response.getStatus()).isEqualTo(200);
        assertThat(response.readEntity(DomainSightings.class)).isEqualTo(domainSightings);
    }

    @Test
    public void add_referrer_bad_url() {
        final String url = "you never step in the same river twice";

        final Response response = resources.client().target("/referrers").request().post(Entity.json(new Referrer(url)));

        assertThat(response.getStatus()).isEqualTo(400);

        verifyZeroInteractions(handler);
    }
}
