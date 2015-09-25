package za.ac.cput.rugbyTeamProfiles.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by THULEBONA on 2015-04-26.
 */
@RunWith(Suite.class )
@Suite.SuiteClasses({
        FixtureTest.class,
        MatchResultsTest.class,
        PlayerProfileTest.class,
        PlayerRecordTest.class,
        TeamProfileTest.class,
        TeamRecordTest.class,
        TeamsLogTest.class,
        VenueTest.class

})
public class TestSuite {
}
