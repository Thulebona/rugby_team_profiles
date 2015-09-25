package za.ac.cput.rugby_team_profiles.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.rugby_team_profiles.domain.Team_profile;

/**
 * Created by thule on 2015/09/24.
 */
@RestController
@RequestMapping(value = "/")
public class Landing_page {
    @RequestMapping(method= RequestMethod.GET)
    public Team_profile getTeam(){
        Team_profile team = new Team_profile
                .Builder("sharks")
                .league("Currie cup")
                .home_Ground("King shaka")
                .headCoach("John zulu")
                .build();
        return team;
    }
}
