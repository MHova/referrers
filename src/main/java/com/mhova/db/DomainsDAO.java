package com.mhova.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface DomainsDAO {
    @SqlUpdate("insert into domains as r (domain, count) values (:domain, 1)"
            + "on conflict (domain)"
            + "do update set count = r.count + 1"
            + "where r.domain = :domain")
    void insertOrIncrementCount(@Bind("domain") final String domain);

    @SqlQuery("select count from domains where domain = :domain")
    int getCount(@Bind("domain") final String domain);
}
