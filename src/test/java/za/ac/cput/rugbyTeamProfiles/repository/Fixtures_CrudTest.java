package za.ac.cput.rugbyTeamProfiles.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import za.ac.cput.rugbyTeamProfiles.App;
import za.ac.cput.rugbyTeamProfiles.domain.Fixtures;
import za.ac.cput.rugbyTeamProfiles.domain.MatchResults;
import za.ac.cput.rugbyTeamProfiles.domain.TeamsLogRanking;
import za.ac.cput.rugbyTeamProfiles.domain.Venue;
import za.ac.cput.rugbyTeamProfiles.factory.FixturesFactory;
import za.ac.cput.rugbyTeamProfiles.factory.MatchResultsFactory;
import za.ac.cput.rugbyTeamProfiles.factory.VenueFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class Fixtures_CrudTest extends AbstractTestNGSpringContextTests {

    private Fixtures fixtures;
    private Map<String,String> values;
    private Map<String,String> vValues;
    private Map<String,Integer> intValues;
    private Venue venue;
    private MatchResults result;
    private TeamsLogRanking log;
    private Map<String,Integer> logValue;

    private Long id;
    @Autowired
    FixturesRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        values = new HashMap<>();
        vValues = new HashMap<>();
        intValues = new HashMap<>();
        logValue = new HashMap<>();
    }

   // @Test
    public void testCreate() throws Exception {

        // fixture
        values.put("time","15:00PM");
        values.put("A", "Sharks");
        values.put("B", "Blue Bulls");
        values.put("date","01/06/2015");

        // Venue
        vValues.put("name", "Green point");
        vValues.put("location", "Cape town");

        // results
        intValues.put("teamAGoal",50);
        intValues.put("teamBGoal",40);

        result = MatchResultsFactory.getMatch_Result(intValues);
        venue = VenueFactory.getVenue(vValues, 55000);
        fixtures = FixturesFactory.getFixtures(values, venue, result);

        repository.save(fixtures);
        id = fixtures.getID();
        Assert.assertNotNull(id);
    }

    //@Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        fixtures = repository.findOne(id);
        Assert.assertEquals(50,fixtures.getResults().getTeamAGoal());
    }

    //@Test
    public void testUpdate() throws Exception {
        fixtures = repository.findOne(id);
        venue = VenueFactory.getVenue(vValues, 50000);
        Fixtures newFixture = new Fixtures.Builder(fixtures.getMatchDate())
                                   .copy(fixtures).matchTime("20:00PM").build();
        repository.save(newFixture);
        Assert.assertEquals("15:00PM", fixtures.getMatchTime());
        Assert.assertEquals("20:00PM",newFixture.getMatchTime());
    }

    //@Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        fixtures = repository.findOne(id);
        repository.delete(fixtures);
        Fixtures newF = repository.findOne(id);
        Assert.assertNull(newF);
    }
}
