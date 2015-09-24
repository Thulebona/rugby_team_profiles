package za.ac.cput.rugby_team_profiles.factory;

import za.ac.cput.rugby_team_profiles.domain.Match_Results;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
public class Match_ResultsFactory {

    public static Match_Results getMatch_Result(Map<String,Integer> Values){
        Match_Results result = new Match_Results.Builder(Values.get("teamAGoal"))
                                    .teamBGoal(Values.get("teamBGoal")).build();
        return result;
    }
}
