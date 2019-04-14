
public class Main {

    public static void main(String[] args) {
        FootballManager league = new FootballLeague();
        league.addPlayer(new PlayerImpl( "Вася"));
        league.addPlayer(new PlayerImpl( "Петя"));
        league.addPlayer(new PlayerImpl( "Женя"));
        league.addPlayer( new PlayerImpl(League.English, Team.Goalkeeper,"Вася"));

//        PlayerImpl num1 = new PlayerImpl("Вася");
//        PlayerImpl num2 = new PlayerImpl("Вася");
//        if(num1.equals(num2)==true){System.out.println("равны");} else {System.out.println("не равны");}
//        while(league.size()>0){
//            System.out.println(league.pull().toString());
//        }

        league.removePlayer(new PlayerImpl(League.English, Team.Goalkeeper,"Вася"));


        while(league.size()>0){
            System.out.println(league.pull().toString());
        }
    }
}
