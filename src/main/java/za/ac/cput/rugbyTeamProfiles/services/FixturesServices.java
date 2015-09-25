package za.ac.cput.rugbyTeamProfiles.services;

import za.ac.cput.rugbyTeamProfiles.domain.Fixtures;
import za.ac.cput.rugbyTeamProfiles.domain.MatchResults;

import java.util.List;

/**
 * Created by THULEBONA on 2015-05-20.
 */
public interface FixturesServices {
    List<Fixtures> getFixtures();
    MatchResults getResults(Long id);
}
