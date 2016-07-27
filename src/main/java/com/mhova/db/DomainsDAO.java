package com.mhova.db;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.mhova.api.DomainSightings;

@RegisterMapper(DomainSightingsMapper.class)
public interface DomainsDAO {
    @SqlUpdate("insert into domains as r (domain, count) values (:domain, 1)"
            + "on conflict (domain)"
            + "do update set count = r.count + 1"
            + "where r.domain = :domain")
    void insertOrIncrementCount(@Bind("domain") final String domain);

    @SqlQuery("select count from domains where domain = :domain")
    int getCount(@Bind("domain") final String domain);

    @SqlQuery("select domain, count from domains order by count desc limit 3")
    List<DomainSightings> getTopThreeDomains();
}
