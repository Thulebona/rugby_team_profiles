package za.ac.cput.rugbyTeamProfiles.services;

import za.ac.cput.rugbyTeamProfiles.domain.PlayerProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamsLogRanking;

import java.util.List;

/**
 * Created by THULEBONA on 2015-05-20.
 */
public interface LogRankingServices  {


    List<TeamsLogRanking> getAllTeams();
    TeamProfile getTeam(Long id);
    List<PlayerProfile> getPlayers(Long id);
    PlayerProfile getPlayer(Long id, Integer index);


}
