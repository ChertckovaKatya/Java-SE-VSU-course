public class FootballLeague implements FootballManager {
    private Player head = null;       // указатель на первый элемент
    private Player tail = null;
    private int size = 0;
    private String name;
    private String team;
    private String league;

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
        Player current = head;
        Player previous = head;
        if (size != 0) {
            if (size() == 1) {
                if (player.equals(current)) {
                    head = null;
                    System.out.println("Элемент один и он удален");
                }
                System.out.println("Элемент один и он не тот, что мы ищем");
            }
            int pos = 0;
            while (pos < size()) {
                System.out.println(player.toString());
                System.out.println(current.toString());
                System.out.println("              ");
//                previous = current;
//                current = current.getNext();
                if (player.equals(current)) {
                    if (current.getNext() == null) {
                        System.out.println(" я работаю");
                        previous.setNext(null);
                        System.out.println("Элемент последний и он удален");
                    } else {

                        previous.setNext(current.getNext());
                        System.out.println("Элемент найден и удален");
                    }
                } else {
                    previous = current;
                    current = current.getNext();
                }
                pos++;
            }
        } else {
            System.out.println("Список нет элементов");
        }
        System.out.println("Нужного элемента не найдено");
//        this.equals(player);
//        Stream.of(this).forEach( System.out::println );
    }

    @Override
    public Object pull() {

        if (size == 0) {
            return null;
        }

        Player curr = this.head;
        this.head = head.getNext();

        if (this.head == null) {
            tail = null;
        }

        size--;
        return curr;
    }
//    @Override
//    public String toString() {
//        return "PlayerImpl [name=" + name
//                + ", league=" + league
//                + ", team=" + team+"]";
//    }


    @Override
    public Player getPlayerByName(String name) {
        return null;
    } //получить игрока по имени

    @Override
    public Player[] getAllPlayers() {
        return new Player[0];
    }

    @Override
    public Player[] getTeamPlayers(Team team) {
        return new Player[0];
    } //получить командных игроков

    @Override
    public Player[] getLeaguePlayers(League league) {
        return new Player[0];
    }

    @Override
    public void addScorePoints(String name, int points) { //добавить очки

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
