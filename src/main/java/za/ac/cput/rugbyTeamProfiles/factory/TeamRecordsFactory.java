package za.ac.cput.rugbyTeamProfiles.factory;

import za.ac.cput.rugbyTeamProfiles.domain.TeamRecords;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class TeamRecordsFactory {

    public static TeamRecords getTeam_Record( Map<String,String> value/*,TeamProfile team*/){
        TeamRecords teamProfile = new TeamRecords.Builder(value.get("recordDate"))
                                       //.recordDate(value.get("recordDate"))
                                       .recordDescription(value.get("recordDescription"))
                                       .build();
        return teamProfile;
    }
}
