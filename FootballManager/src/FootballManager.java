public interface FootballManager {
    void addPlayer(Player player);

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

    Object pull();

    String toString();

    int size();

    void removePlayer(Player player);

    Player getPlayerByName(String name);

    Player[] getAllPlayers();

    Player[] getTeamPlayers(Team team);

    Player[] getLeaguePlayers(League league);

    void addScorePoints(String name, int points);

    interface Player {

        String getName();
        FootballManager.Player getNext();
        League getLeague();
        Team getTeam();
        void setPoints(Integer points);
        void setNext(FootballManager.Player next);
    }
}
