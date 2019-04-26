import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class FileShit {
    File file = new File("energy-consumption.txt");
    File file_dan = new File("energy-consumption.dan");


    public void fileShit() throws IOException {
        for(;;) {
            if (file.isFile() && file_dan.exists()) {
                Path file2 = Paths.get("D://Java//Files","energy-consumption.txt" );
                File catalog = new File("D://Java//Files//tmp");
                Path cat_path = Paths.get("D://Java//Files//tmp", file2.getFileName().toString());
                if (catalog.exists()== false) {
                    catalog.mkdirs();
                }
               try{
                   Path file3 = Files.copy(file2,cat_path,REPLACE_EXISTING);
                   List<String> lines = Files.readAllLines(file3, StandardCharsets.UTF_8);
                   Stream<String> strimFromList = lines.stream();

//                   List<String> collection = Arrays.asList("0.454,34.54,0.5");
//                   Stream<String> streamFromCollection = collection.stream();
//                   streamFromCollection.mapToDouble((s)->Double.parseDouble(s))
//                           .forEach(System.out::println);

//                   String janury;
//                       try {
//                           //janury =
//                                   strimFromList
//                                   .skip(1)
//                                   .map((s) -> s.substring(36))
//                                   .limit(1)
//                                           .map(s->s.split(""))
//                                           .flatMap(Arrays::stream)
//                                           .collect(Collectors.toList())
//                                   //.mapToDouble((s)-> Double.parseDouble(s))
//                                   // .reduce(((el1,el2)->el1+el2))
//                                    .forEach(System.out::print);
//                                  // .get();
//                           // System.out.println(janury);
//                       }
//                       catch(NumberFormatException e){
//                           e.printStackTrace();
//                       }
                }
               catch (IOException e){
                   System.err.println(e);
               }
                break;
            }
        }
    }
}



