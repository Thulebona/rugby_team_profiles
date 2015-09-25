package za.ac.cput.rugbyTeamProfiles.factory;

import za.ac.cput.rugbyTeamProfiles.domain.MatchResults;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
public class MatchResultsFactory {

    public static MatchResults getMatch_Result(Map<String,Integer> Values){
        MatchResults result = new MatchResults.Builder(Values.get("teamAGoal"))
                                    .teamBGoal(Values.get("teamBGoal")).build();
        return result;
    }
}
