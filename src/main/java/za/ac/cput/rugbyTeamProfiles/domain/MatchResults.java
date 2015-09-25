package za.ac.cput.rugbyTeamProfiles.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@Entity
public class MatchResults implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int teamAGoal;
    private int  teamBGoal;

    private MatchResults(){}

    public MatchResults(Builder builder) {
        teamAGoal = builder.teamAGoal;
        teamBGoal = builder.teamBGoal;
        id =builder.id;
    }

    public int  getTeamAGoal() {
        return teamAGoal;
    }
    public int  getTeamBGoal() {
        return teamBGoal;
    }
    public Long getId() {
        return id;
    }

    public static class Builder{

        private Long id;
        private int  teamAGoal;
        private int  teamBGoal;

        public Builder id(Long id){
            this.id =id;
            return this;
        }
        public Builder( int  val){
            this.teamAGoal = val;
        }
        public Builder teamBGoal( int  val){
            this.teamBGoal = val;
            return this;
        }
        public Builder copy(MatchResults results){
            teamAGoal = results.teamAGoal;
            teamBGoal = results.teamBGoal;
            id = results.id;
            return this;
        }
        public MatchResults build(){
            return new MatchResults(this);
        }

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResults that = (MatchResults) o;
        return !(id != null ? !id.equals(that.id) : that.id != null);
    }
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
