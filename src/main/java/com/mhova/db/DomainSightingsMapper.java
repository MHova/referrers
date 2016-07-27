package com.mhova.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.mhova.api.DomainSightings;

public class DomainSightingsMapper implements ResultSetMapper<DomainSightings> {

    @Override
    public DomainSightings map(final int index, final ResultSet rs, final StatementContext ctx) throws SQLException {
        return new DomainSightings(rs.getString("domain"), rs.getInt("count"));
    }
}
