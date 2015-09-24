package za.ac.cput.rugby_team_profiles.factory;

import za.ac.cput.rugby_team_profiles.domain.Fixtures;
import za.ac.cput.rugby_team_profiles.domain.Match_Results;
import za.ac.cput.rugby_team_profiles.domain.Venue;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
public class FixturesFactory {

    public static Fixtures getFixtures(Map<String, String> values, Venue venue, Match_Results result){
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
