package za.ac.cput.rugby_team_profiles.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.rugby_team_profiles.domain.Team_profile;

/**
 * Created by THULEBONA on 2015-05-02.
 */
public interface Team_profileRepository extends CrudRepository<Team_profile,Long> {
}
