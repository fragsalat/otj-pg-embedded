package ness.db.postgres.junit;


import org.junit.Assert;
import org.junit.Rule;
import org.skife.jdbi.v2.DBI;

import com.google.common.io.Resources;

public class TestLocalPreparerDatabasePerMethod extends AbstractPreparerTests
{
    @Rule
    public final LocalPostgresPreparerTestRule database = PostgresRules.databasePreparerRule(Resources.getResource(PostgresRules.class, "/sql/"), "simple");

    @Override
    public DBI getDbi()
    {
        Assert.assertNotNull(database);
        final DBI dbi = database.getDbi();
        Assert.assertNotNull(dbi);
        return dbi;
    }
}
