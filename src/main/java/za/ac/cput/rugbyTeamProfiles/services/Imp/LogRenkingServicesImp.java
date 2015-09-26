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
    TeamsLogRankingRepository repository;

    @Override
    public TeamsLogRanking findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public TeamsLogRanking save(TeamsLogRanking entity) {
        return repository.save(entity);
    }

    @Override
    public TeamsLogRanking update(TeamsLogRanking entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(TeamsLogRanking entity) {
        repository.delete(entity);
    }

    @Override
    public List<TeamsLogRanking> findAll() {
        List<TeamsLogRanking> log = new ArrayList<>();
        Iterable<TeamsLogRanking> allTeams = repository.findAll();
        for (TeamsLogRanking teams : allTeams) {
            log.add(teams);
        }
        return log;
    }
}
