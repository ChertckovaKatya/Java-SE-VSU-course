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

public class FileProcessing {
    File file = new File("energy-consumption.txt");
    File file_dan = new File("energy-consumption.dan");


    public void fileProcessing() throws IOException {
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
                   Stream<String> strim_janury = lines.stream();

                  Double janury;
                  Double february;
                  Double march;
                       try {
                       janury = strim_janury.skip(1)
                               .map((s) -> s.substring(36))
                               .limit(31)
                               .flatMapToDouble(
                                       (p) -> Arrays.asList(p.split(","))
                                       .stream().mapToDouble(Double::parseDouble))
                               .sum();
                           janury = janury/31;

                           Stream<String> strim_febtuary = lines.stream();

                           february = strim_febtuary.skip(1)
                                   .map((s) -> s.substring(36))
                                   .skip(31)
                                   .limit(28)
                                   .flatMapToDouble(
                                           (p) -> Arrays.asList(p.split(","))
                                           .stream().mapToDouble(Double::parseDouble))
                                   .sum();
                           february = february/29;

                           Stream<String> strim_march = lines.stream();
                           march = strim_march.skip(1)
                                   .map((s) -> s.substring(36))
                                   .skip(59)
                                   .limit(31)
                                   .flatMapToDouble(
                                           (p) -> Arrays.asList(p.split(","))
                                           .stream().mapToDouble(Double::parseDouble))
                                   .sum();

                           march = march/31;
                           Long average_for_three_months = Math.round((janury+february+march)/3);
                           System.out.println("Среднее потребление электроэнергии  в день за три месяца: "+ average_for_three_months+" КВт");

                           if (catalog.exists()) {
                               Files.delete(file3);
                               catalog.delete();
                           }
                       }
                       catch(NumberFormatException e){
                           e.printStackTrace();
                       }
                }
               catch (IOException e){
                   System.err.println(e);
               }

                break;
            }

        }
    }
}



