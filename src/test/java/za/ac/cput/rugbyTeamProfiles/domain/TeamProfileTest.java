package za.ac.cput.rugbyTeamProfiles.domain;

import org.junit.Assert;
import org.junit.Before;
import za.ac.cput.rugbyTeamProfiles.factory.TeamProfileFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class TeamProfileTest {

    private List<PlayerProfile> player;
    private Map<String,String> val;
    private TeamRecords rec;
    private TeamProfile team;
    @Before
    public void setUp() throws Exception {
        val = new HashMap<String, String>();
        player = new ArrayList<PlayerProfile>();

        val.put("teamName","sharks");
        val.put("league", "ABSA Currie Cup");
    }

  //  @Test
    public void testProfile() throws Exception {

       // rec = new TeamRecords.Builder(player.getTeam_profile()).build();
        TeamProfile team = TeamProfileFactory.getTeamProfile(val, rec, player);
        Assert.assertEquals("ABSA Currie Cup",team.getLeague());
    }
    //@Test
    public void testProfileUpdate() throws Exception {

        team = TeamProfileFactory.getTeamProfile(val, rec, player);
        TeamProfile newTeam = new TeamProfile
                .Builder(team.getTeamName())
                .copy(team)
                .league("RFU Championship")
                .build();

        Assert.assertEquals(newTeam.getTeamName(),team.getTeamName());
        Assert.assertEquals("RFU Championship",newTeam.getLeague());
        Assert.assertEquals("ABSA Currie Cup",team.getLeague());
    }

}
