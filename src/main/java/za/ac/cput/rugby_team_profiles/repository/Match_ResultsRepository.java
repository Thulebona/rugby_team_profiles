package za.ac.cput.rugby_team_profiles.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.rugby_team_profiles.domain.Match_Results;


/**
 * Created by student on 2015/04/18.
 */
public interface Match_ResultsRepository extends CrudRepository<Match_Results,Long> {
}
