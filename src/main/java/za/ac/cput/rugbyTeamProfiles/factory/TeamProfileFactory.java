package za.ac.cput.rugbyTeamProfiles.factory;

import za.ac.cput.rugbyTeamProfiles.domain.PlayerProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamRecords;

import java.util.List;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class TeamProfileFactory {

    public static TeamProfile getTeamProfile( Map<String,String> val,
                                         TeamRecords team_rec,
                                               List<PlayerProfile> player){
        TeamProfile team = new TeamProfile
                           .Builder(val.get("teamName"))
                           .league(val.get("league"))
                           .home_Ground(val.get("home_Ground"))
                           .headCoach(val.get("headCoach"))
                           .records(team_rec)
                           .players(player)
                           .build();

        return team;
    }
}
