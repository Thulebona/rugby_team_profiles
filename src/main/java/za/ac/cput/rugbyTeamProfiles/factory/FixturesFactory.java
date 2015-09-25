package za.ac.cput.rugbyTeamProfiles.factory;

import za.ac.cput.rugbyTeamProfiles.domain.Fixtures;
import za.ac.cput.rugbyTeamProfiles.domain.Venue;
import za.ac.cput.rugbyTeamProfiles.domain.MatchResults;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
public class FixturesFactory {

    public static Fixtures getFixtures(Map<String, String> values, Venue venue, MatchResults result){
        Fixtures fixtures = new Fixtures.Builder(values.get("date"))
                            .matchTime(values.get("time"))
                            .teamAName(values.get("A"))
                            .teamBName(values.get("B"))
                            .results(result)
                            .matchVenue(venue)
                            .build();
        return fixtures;
    }
}
