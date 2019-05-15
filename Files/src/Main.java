import java.io.IOException;

public class Main {

    public static void main(String[] args){
        FileShit file = new FileShit();
        try {
            file.fileProcessing();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e){
            System.out.println("111");
            e.printStackTrace();
        }
    }
}
