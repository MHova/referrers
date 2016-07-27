package com.mhova.db;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface ReferrersDAO {
    @SqlUpdate("insert into referrers (url, domain) values (:url, :domain)")
    void insert(@Bind("url") final String url, @Bind("domain") final String domain);

    @SqlQuery("select sum(case when domain = :domain then 1 else 0 end) from referrers")
    int countDomains(@Bind("domain") final String domain);
}
