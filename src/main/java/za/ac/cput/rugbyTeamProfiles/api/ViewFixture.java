package za.ac.cput.rugbyTeamProfiles.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.rugbyTeamProfiles.domain.Fixtures;
import za.ac.cput.rugbyTeamProfiles.domain.MatchResults;
import za.ac.cput.rugbyTeamProfiles.services.FixturesServices;

import java.util.List;

/**
 * Created by THULEBONA on 2015-05-20.
 */
@RestController
@RequestMapping(value = "/fixture/**")
public class ViewFixture {

    @Autowired
    FixturesServices services;

    @RequestMapping(value = "/fixtures",method = RequestMethod.GET)
    public List<Fixtures> getFixture() {
          return services.getFixtures();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public MatchResults getResults(@PathVariable Long id){
        return services.getResults(id);
    }

}
