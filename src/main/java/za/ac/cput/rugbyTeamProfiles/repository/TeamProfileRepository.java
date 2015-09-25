package za.ac.cput.rugbyTeamProfiles.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;

/**
 * Created by THULEBONA on 2015-05-02.
 */
public interface TeamProfileRepository extends CrudRepository<TeamProfile,Long> {
}
