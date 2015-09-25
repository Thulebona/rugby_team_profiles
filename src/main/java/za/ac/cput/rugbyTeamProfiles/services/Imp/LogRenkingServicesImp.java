package za.ac.cput.rugbyTeamProfiles.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.rugbyTeamProfiles.services.LogRankingServices;
import za.ac.cput.rugbyTeamProfiles.domain.PlayerProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamsLogRanking;
import za.ac.cput.rugbyTeamProfiles.repository.TeamsLogRankingRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THULEBONA on 2015-05-20.
 */
@Service
public class LogRenkingServicesImp implements LogRankingServices {
    @Autowired
    TeamsLogRankingRepository logRankingRepository;
    @Override
    public List<TeamsLogRanking> getAllTeams() {

        List<TeamsLogRanking> ranking = new ArrayList<>();
        Iterable<TeamsLogRanking> teams_log = logRankingRepository.findAll();
        for (TeamsLogRanking rank: teams_log)
        {
         ranking.add(rank);
        }
        return ranking;
    }


    @Override
    public TeamProfile getTeam(Long id) {
        return logRankingRepository.findOne(id).getTeam();
    }

    @Override
    public List<PlayerProfile> getPlayers(Long id) {
        return logRankingRepository.findOne(id).getTeam().getPlayers();
    }

    @Override
    public PlayerProfile getPlayer(Long id,Integer index) {
        return logRankingRepository.findOne(id).getTeam().getPlayers().get(index.intValue());
    }
}
