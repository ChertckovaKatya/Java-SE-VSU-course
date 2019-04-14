public class Player implements Comparable<Player>, FootballManager.Player {
   League league;
   Team team;
   public String name;
   Integer points;


    Player (League league, Team team, String name){
        this.league = league;
        this.team = team;
        this.name = name;
    }

    Player (String name){
        this.name = name;
    }

    String getName(){return name;}

    public int compareTo(Player p){

        return name.compareTo(p.getName());
    }

    @Override
    public String toString() {
        return "Player [name=" + name
                + ", league=" + league
                + ", team=" + team+"]";
    }


    @Override
    public boolean equals(FootballManager.Player player) {
        if (this == player) return true;
        if (player == null) return false;
        //if (!(player instanceof Player)) return false;
        if (getClass() != player.getClass()) return false;
        Player object = (Player) player;
        if (name!=null && league!=null && team!=null) {
            return name.equals(object.name) && league.equals((object.league)) && team.equals(object.team);
        }
        else {
            if (name != null && league != null) {
                return name.equals(object.name) && league.equals((object.league));
            }
            else {
                if (name != null && team != null){
                    return name.equals(object.name) && team.equals((object.team));
                }
                else {
                    if (name!=null){
                        return name.equals(object.name);

                    }
                }
            }
        }
        return false;
    }
}


