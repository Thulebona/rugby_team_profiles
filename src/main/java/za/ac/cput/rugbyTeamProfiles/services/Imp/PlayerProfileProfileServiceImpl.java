package za.ac.cput.rugbyTeamProfiles.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.rugbyTeamProfiles.domain.PlayerProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;
import za.ac.cput.rugbyTeamProfiles.repository.PlayerProfileRepository;
import za.ac.cput.rugbyTeamProfiles.services.PlayerProfileService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thule on 2015/09/26.
 */
public class PlayerProfileProfileServiceImpl implements PlayerProfileService {

    @Autowired
    PlayerProfileRepository repository;

    @Override
    public PlayerProfile findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public PlayerProfile save(PlayerProfile entity) {
        return repository.save(entity);
    }

    @Override
    public PlayerProfile update(PlayerProfile entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(PlayerProfile entity) {
            repository.delete(entity);
    }

    @Override
    public List<PlayerProfile> findAll() {
        List<PlayerProfile> allPlayers = new ArrayList<>();
        Iterable<PlayerProfile> players = repository.findAll();
        for (PlayerProfile playerProfile : players) {
            allPlayers.add(playerProfile);
        }
        return allPlayers;
    }
}
