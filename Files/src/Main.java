import java.io.IOException;

public class Main {

    public static void main(String[] args){
        FileParsing file = new FileParsing();
        try {
            file.parsingFile("Test2.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e){
            System.out.println("111");
            e.printStackTrace();
        }

        DatabaseHandler db = new DatabaseHandler();
        //System.out.println(db.getConnection());

    }
}
