package za.ac.cput.rugbyTeamProfiles.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.rugbyTeamProfiles.domain.TeamsLogRanking;


/**
 * Created by student on 2015/04/18.
 */
public interface TeamsLogRankingRepository extends CrudRepository<TeamsLogRanking,Long> {
}