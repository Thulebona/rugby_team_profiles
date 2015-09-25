package za.ac.cput.rugbyTeamProfiles.factory;

import za.ac.cput.rugbyTeamProfiles.domain.TeamProfile;
import za.ac.cput.rugbyTeamProfiles.domain.TeamsLogRanking;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
public class TeamsLogFactory {
    public static TeamsLogRanking getTeams_log_ranking(TeamProfile team,Map<String,Integer> values){
              TeamsLogRanking ranking = new TeamsLogRanking.Builder(team)
                                   .gamasPlayed(values.get("played"))
                                   .win(values.get("win"))
                                   .lose(values.get("lose"))
                                   .draw(values.get("draw"))
                                   .pointFor(values.get("pointFor"))
                                   .pointAgainst(values.get("pointAgainst"))
                                 //  .pointDiff(values.get("pointDiff"))
                                   .bonusPoint(values.get("bonusPoint"))
                                 //  .total(values.get("total"))
                                   .build();
        return ranking;
    }
}
