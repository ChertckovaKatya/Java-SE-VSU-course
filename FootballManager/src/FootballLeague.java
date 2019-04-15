import java.util.Currency;

public class FootballLeague implements FootballManager {
    private Player head = null;       // указатель на первый элемент
    private Player tail = null;
    private int size = 0;
    private String name;
    private String team;
    private String league;
    private Integer points;

    @Override
    public void addPlayer(Player player) {
        if (head == null) {
            head = player;

        } else {
            tail.setNext(player);
        }
        tail = player;
        size++;
    }

    @Override
    public void removePlayer(Player player) {
        Player previous = null;
        Player current = head;
        while (current != null)
        {
            if (player.equals(current) && player.hashCode() == current.hashCode())
            {
                if (previous != null)
                {
                    if (current.getNext() == null)
                    {
                        tail = previous;
                        previous.setNext(null);
                        current = null;
                    }
                    else {
                        previous.setNext(current.getNext());
                        current = current.getNext();

                    }
                }
                else
                {
                    head = head.getNext();
                    previous = null;
                    current = head;
                    if (head == null)
                    {
                        tail.setNext(null);
                    }
                }

                size--;
            }

            else {
                previous = current;
                current = current.getNext();
            }
        }


    }

    @Override
    public Object pull() {
        int num =size();
        if (num == 0) {
            return null;
        }

        Player curr = this.head;
        this.head = head.getNext();

        if (this.head == null) {
            tail = null;
        }
        num--;
        return curr;
    }

    @Override
    public Player getPlayerByName(String name) {
        Player current = this.head;
        int number = size();
        if (number != 0) {
            while (number!=0) {
                if (name.equals(current.getName())) {
                    return current;

                    }
                    else {
                    number--;
                    current = current.getNext();
                }
            }
            }
        return null;
    }

    @Override
    public Player[] getAllPlayers() {
        int num = size();
        Player[] array = new Player[size()];
        int i = 0;
        if (num == 0) {
            return null;

        }
        Player curr = this.head;
        while(num!=0){
            array[i] = curr;
            curr= curr.getNext();
            i++;
            num--;
        }
        return array;
    }

    @Override
    public Player[] getTeamPlayers(Team team) {
        int num = size();
        Player[] array = new Player[size()];
        int i = 0;
        if (num == 0) {
            return null;
        }
        Player current = this.head;
        while(num!=0){
            if (current.getTeam()!=null) {
                if ((current.getTeam()).equals(team)) {
                   array[i] = current;
                    i++;
                }
            }
            current= current.getNext();
            num--;
        }
        return array;

    }

    @Override
    public Player[] getLeaguePlayers(League league) {
        int num = size();
        Player[] array = new Player[size()];
        int i = 0;
        if (num == 0) {
            return null;
        }
        Player current = this.head;
        while(num!=0){
            if (current.getLeague()!=null) {
                if ((current.getLeague()).equals(league)) {
                    array[i] = current;
                    i++;
                }
            }
            current= current.getNext();
            num--;
        }
        return array;
    }

    @Override
    public void addScorePoints(String name, int points) { //добавить очки
        int num = size();
        if (num == 0) {
            System.out.println("Список игроков пуст");
        }
        Player current = this.head;
        while(num!=0){
            if (current.getName()!=null) {
                if ((current.getName()).equals(name)) {
                   current.setPoints(points);
                }
            }
            current= current.getNext();
            num--;
        }
    }

    public int size() {
        return size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }
}
