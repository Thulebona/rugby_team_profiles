package za.ac.cput.rugby_team_profiles.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.rugby_team_profiles.domain.Fixtures;
import za.ac.cput.rugby_team_profiles.domain.Match_Results;
import za.ac.cput.rugby_team_profiles.repository.FixturesRepository;
import za.ac.cput.rugby_team_profiles.services.FixturesServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THULEBONA on 2015-05-20.
 */
@Service
public class FixturesServicesImpl implements FixturesServices {

    @Autowired
    FixturesRepository repository;
    @Override
    public List<Fixtures> getFixtures() {
        List<Fixtures> fixtures = new ArrayList<>();
        Iterable<Fixtures> fixture = repository.findAll();
        for (Fixtures fixt: fixture){
            fixtures.add(fixt);
        }
        return fixtures;
    }

    @Override
    public Match_Results getResults(Long id) {
        return repository.findOne(id).getResults();
    }
}
