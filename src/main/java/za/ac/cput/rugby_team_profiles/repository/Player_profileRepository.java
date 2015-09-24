package za.ac.cput.rugby_team_profiles.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.rugby_team_profiles.domain.Player_profile;


/**
 * Created by student on 2015/04/18.
 */
public interface Player_profileRepository extends CrudRepository<Player_profile,Long> {

}
