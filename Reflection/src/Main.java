import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ReflectionChecker reflectionChecker = new ReflectionChecker();
        Person Alex = new Person();
        Car Reno = new Car();
        List<String> list_fields = new LinkedList<>();
        list_fields.add(reflectionChecker.showFieldsAnnotations(Alex));
        list_fields.add(reflectionChecker.showFieldsAnnotations(Reno));
        try {
            if (new File("demo.txt").exists()) {
                new File("demo.txt").delete();
                Files.write(Paths.get("demo.txt"), list_fields, StandardOpenOption.CREATE);
            }
            else {
                Files.write(Paths.get("demo.txt"), list_fields, StandardOpenOption.CREATE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
