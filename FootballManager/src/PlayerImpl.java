import java.util.Objects;

public class PlayerImpl implements FootballManager.Player, Comparable<PlayerImpl> {
    public String name;
    League league;
    Team team;
    Integer points;
    FootballManager.Player next;


    PlayerImpl(League league, Team team, String name) {
        this.league = league;
        this.team = team;
        this.name = name;
    }

    PlayerImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Team getTeam(){
        return team;
    }

    public League getLeague(){
        return league;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public int compareTo(PlayerImpl p) {

        return name.compareTo(p.getName());
    }

    @Override
    public String toString() {
        return "Игрок [ФИО:" + name
                + ", Лига:" + league
                + ", Позиция: " + team
                + ", Кол-во забитых голов = " + points+ "]";
    }

    public FootballManager.Player getNext() {
        return next;
    }

    public void setNext(FootballManager.Player next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerImpl playerImpl = (PlayerImpl) o;
        if (getClass() != playerImpl.getClass()) return false;
        if (name != null && league != null && team != null) {
            return name.equals(playerImpl.name) && league.equals((playerImpl.league)) && team.equals(playerImpl.team);
        } else {
            if (name != null && league != null) {
                return name.equals(playerImpl.name) && league.equals((playerImpl.league));
            } else {
                if (name != null && team != null) {
                    return name.equals(playerImpl.name) && team.equals((playerImpl.team));
                } else {
                    if (name != null) {
                        return name.equals(playerImpl.name);

                    }
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, league, team, points);
    }
}


