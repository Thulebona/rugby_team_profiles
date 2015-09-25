package za.ac.cput.rugbyTeamProfiles.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;

/**
 * Created by thule on 2015/09/24.
 */
@RestController
@RequestMapping(value = "/")
public class LandingPage {
    @RequestMapping(method= RequestMethod.GET)
    public TeamProfile getTeam(){
        TeamProfile team = new TeamProfile
                .Builder("sharks")
                .league("Currie cup")
                .home_Ground("King shaka")
                .headCoach("John zulu")
                .build();
        return team;
    }
}
