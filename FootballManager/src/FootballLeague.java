import java.util.stream.Stream;

public class FootballLeague implements FootballManager {
    private ObjectPlayer head = null;       // указатель на первый элемент
    private ObjectPlayer tail = null;
    private int size = 0;
    private String name;
    private String team;
    private String league;

    @Override
    public void addPlayer(Player player) {

        ObjectPlayer gamer = new ObjectPlayer();
        gamer.setObject(player);
        if(head == null)
        {
            head = gamer;

        }
        else {
            tail.setNext(gamer);
        }
        tail = gamer;
        size++;

    }

    @Override
    public void removePlayer(Player player) {

        ObjectPlayer gamer = new ObjectPlayer();
        gamer.setObject(player);
        ObjectPlayer current = head;
        ObjectPlayer previous = head;
        if (size !=0) {

            if (size() == 1) {
                if (gamer.equals(current)) {
                    head = null;
                    System.out.println("Элемент один и он удален");
                }
                System.out.println("Элемент один и он не тот, что мы ищем");
            }
            int pos = 0;
            while (pos < size()) {
                System.out.println(gamer.toString());
                System.out.println(current.toString());
                System.out.println("              ");
//                previous = current;
//                current = current.getNext();
                if (gamer.equals(current)) {
                    if (current.getNext() == null) {
                        System.out.println(" я работаю");
                        previous.setNext(null);
                        System.out.println ("Элемент последний и он удален");
                    } else {

                        previous.setNext(current.getNext());
                        System.out.println("Элемент найден и удален");
                    }
                }
                else {
                    previous = current;
                    current = current.getNext();
                }
                pos++;
            }
        }
        else {System.out.println("Список нет элементов");}
        System.out.println("Нужного элемента не найдено");
//        this.equals(player);
//        Stream.of(this).forEach( System.out::println );
    }
    @Override
    public Object pull() {

        if (size == 0) {
            return null;
        }
        Object gamer = head.getObject();

        head = head.getNext();

        if (head == null) {
            tail = null;
        }

        size--;
        return gamer;
    }
    @Override
    public String toString() {
        return "Player [name=" + name
                + ", league=" + league
                + ", team=" + team+"]";
    }


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
    private class ObjectPlayer
    {
        private Object object;

        private ObjectPlayer next;

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public ObjectPlayer getNext() {
            return next;
        }

        public void setNext(ObjectPlayer next) {
            this.next = next;
        }
    }

}
