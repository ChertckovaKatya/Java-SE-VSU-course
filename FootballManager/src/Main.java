
public class Main {

    public static void main(String[] args) {
        FootballManager player = new FootballLeague();
        player.addPlayer(new Player( "Вася"));
        player.addPlayer(new Player( "Петя"));
        player.addPlayer(new Player( "Женя"));
        player.addPlayer( new Player(League.English, Team.Goalkeeper,"Вася"));

//        Player num1 = new Player("Вася");
//        Player num2 = new Player("Вася");
//        if(num1.equals(num2)==true){System.out.println("равны");} else {System.out.println("не равны");}
//        while(player.size()>0){
//            System.out.println(player.pull().toString());
//        }

        player.removePlayer(new Player(League.English, Team.Goalkeeper,"Вася"));


        while(player.size()>0){
            System.out.println(player.pull().toString());
        }
    }
}
