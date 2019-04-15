
public class Main {

    public static void main(String[] args) {
        FootballManager league = new FootballLeague();
        league.addPlayer(new PlayerImpl(League.Spanish, Team.Goalkeeper, "Вася"));
        league.addPlayer(new PlayerImpl(League.English, Team.Goalkeeper, "Витя"));
        league.addPlayer( new PlayerImpl(League.English, Team.Cleaner, "Миша"));
        league.addPlayer(new PlayerImpl(League.Spanish, Team.Cleaner, "Женя"));

        FootballManager.Player[] list = league.getAllPlayers(); // получаем всех игроков
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + ", ");
        }
        System.out.println(" ");
        System.out.println("Удаляем игрока");
        league.removePlayer(new PlayerImpl(League.English, Team.Goalkeeper, "Витя"));
        FootballManager.Player[] pl = league.getAllPlayers();
        for (int i = 0; i < pl.length; i++) {
            System.out.println(pl[i] + ", ");
        }

        System.out.println(" ");
        System.out.println("Выводим игрока с именем Женя");
        System.out.println(league.getPlayerByName("Женя").toString());

        System.out.println(" ");
        System.out.println("Выводим игроков на позиции: "+ Team.Cleaner );
        FootballManager.Player[] list2 = league.getTeamPlayers(Team.Cleaner);
        for (int i = 0; i < list2.length; i++) {
            if (list2[i]!=null) {
                System.out.println(list2[i] + ", ");
            }
        }
        System.out.println(" ");
        System.out.println("Выводим игроков  "+ League.Spanish +" лиги");
        FootballManager.Player[] players_league = league.getLeaguePlayers(League.Spanish);
        for (int i = 0; i < players_league.length; i++) {
            if (players_league[i]!=null) {
                System.out.println(players_league[i] + ", ");
            }
       }

        System.out.println(" ");
        System.out.println("Добавляем очки игроку с именем Вася");
       league.addScorePoints("Вася",5);
        FootballManager.Player[] list3 = league.getAllPlayers();
        for (int i = 0; i < list3.length; i++) {
            System.out.println(list3[i] + ", ");
        }

    }
}
