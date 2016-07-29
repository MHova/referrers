package com.mhova.db;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.mhova.api.DomainSightings;

public class DomainSightingsMapperTest {

    private DomainSightingsMapper classUnderTest;
    
    @Before
    public void setup() {
        classUnderTest = new DomainSightingsMapper();
    }
    
    @Test
    public void map() throws SQLException {
        final ResultSet rs = mock(ResultSet.class);
        final String domain = "should I marry Kokoum?";
        when(rs.getString("domain")).thenReturn(domain);
        final int sightings = 15;
        when(rs.getInt("count")).thenReturn(sightings);
        
        final DomainSightings result = classUnderTest.map(-1, rs, null);
        
        assertThat(result.domain, equalTo(domain));
        assertThat(result.sightings, equalTo(sightings));
    }

}
