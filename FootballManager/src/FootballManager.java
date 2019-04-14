public interface FootballManager {
    interface Player{
        public boolean equals(FootballManager.Player player);
    }

//    enum League{
//        English,Spanish,Ukrainian,Mexican;
//    }
//
//    enum Team {
//        Goalkeeper,
//        Cleaner,
//        CenterBack,//центральный защитник
//        RighthBack,
//        LiftBack,
//        DefensiveMidfielder, // полузащитник
//        Playmaker, //Плеймейкер
//        Attack, //Нападающий
//    }

    void addPlayer(Player player);
    Object pull();
    public String toString();
    public int size();
    void removePlayer(Player player);

    Player getPlayerByName(String name);

    Player[] getAllPlayers();

    Player[] getTeamPlayers(Team team);

    Player[] getLeaguePlayers(League league);

    void addScorePoints(String name, int points);
    /*...*/
}
