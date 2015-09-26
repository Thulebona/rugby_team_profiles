package za.ac.cput.rugbyTeamProfiles.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;
import za.ac.cput.rugbyTeamProfiles.repository.TeamProfileRepository;
import za.ac.cput.rugbyTeamProfiles.services.TeamProfileService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thule on 2015/09/26.
 */
public class TeamProfileServiceImpl implements TeamProfileService {
    @Autowired
    TeamProfileRepository repository;

    @Override
    public TeamProfile findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public TeamProfile save(TeamProfile entity) {
        return repository.save(entity);
    }

    @Override
    public TeamProfile update(TeamProfile entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(TeamProfile entity) {
        repository.delete(entity);
    }

    @Override
    public List<TeamProfile> findAll() {

        List<TeamProfile> allTeams = new ArrayList<>();
        Iterable<TeamProfile> teams = repository.findAll();
        for (TeamProfile teamProfile : teams) {
            allTeams.add(teamProfile);
        }
        return allTeams;
    }
}
