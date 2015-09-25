package za.ac.cput.rugbyTeamProfiles.domain;

import org.junit.Assert;
import org.junit.Before;
import za.ac.cput.rugbyTeamProfiles.factory.TeamsLogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
public class TeamsLogTest {
    private Map<String,Integer> value;
    private TeamsLogRanking log;
    private TeamProfile team;
    @Before
    public void setUp() throws Exception {
        value = new HashMap<>();

    }

  //  @Test
    public void testLog() throws Exception {
        value.put("played",2);
        value.put("win",2);
        value.put("lose",0);
        value.put("draw",0);
        value.put("pointFor",90);
        value.put("pointAgainst",20);
     //   value.put("pointDiff",70);
        value.put("bonusPoint",4);
      //  value.put("total",12);
        team = new TeamProfile.Builder("Blue Bull").build();
        log = TeamsLogFactory.getTeams_log_ranking(team, value);
        Assert.assertEquals(12,log.getTotal());
    }
    //@Test
    public void testLogUpdate() throws Exception {

        value.put("played",2);
        value.put("win",2);
        value.put("lose",0);
        value.put("draw",0);
        value.put("pointFor",90);
        value.put("pointAgainst",20);
        //   value.put("pointDiff",70);
        value.put("bonusPoint",4);
        //  value.put("total",12);
        team = new TeamProfile.Builder("Blue Bull").build();
        log = TeamsLogFactory.getTeams_log_ranking(team, value);

        TeamsLogRanking log_ranking = new TeamsLogRanking.Builder(log.getTeam())
                                        .copy(log)
                                        .gamasPlayed(4)
                                        .draw(1)
                                        .win(3)
                                        .bonusPoint(5)
                                        .pointAgainst(60)
                                        .pointFor(100).build();

        Assert.assertEquals(18,log_ranking.getTotal());
        Assert.assertEquals(40,log_ranking.getPointDiff());
        Assert.assertEquals(0,log.getLose());
        Assert.assertEquals(2,log.getGamesPlayed());
        Assert.assertEquals(4,log_ranking.getGamesPlayed());

    }
}
