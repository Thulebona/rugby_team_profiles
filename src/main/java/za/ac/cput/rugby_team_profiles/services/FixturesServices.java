package za.ac.cput.rugby_team_profiles.services;

import za.ac.cput.rugby_team_profiles.domain.Fixtures;
import za.ac.cput.rugby_team_profiles.domain.Match_Results;

import java.util.List;

/**
 * Created by THULEBONA on 2015-05-20.
 */
public interface FixturesServices {
    List<Fixtures> getFixtures();
    Match_Results getResults(Long id);
}
