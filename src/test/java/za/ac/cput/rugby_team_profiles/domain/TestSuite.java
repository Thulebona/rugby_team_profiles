package za.ac.cput.rugby_team_profiles.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by THULEBONA on 2015-04-26.
 */
@RunWith(Suite.class )
@Suite.SuiteClasses({
        FixtureTest.class,
        Match_Results_Test.class,
        Player_profile_test.class,
        Player_record_test.class,
        Team_profile_test.class,
        Team_Record_test.class,
        Teams_logTest.class,
        VenueTest.class

})
public class TestSuite {
}
