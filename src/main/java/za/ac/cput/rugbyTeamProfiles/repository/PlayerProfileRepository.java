package za.ac.cput.rugbyTeamProfiles.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.rugbyTeamProfiles.domain.PlayerProfile;


/**
 * Created by student on 2015/04/18.
 */
public interface PlayerProfileRepository extends CrudRepository<PlayerProfile,Long> {

}
