import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;


public class FileParsing {
    DatabaseHandler db = new DatabaseHandler();

    public void parsingFile(String name) throws IOException, SQLException {

        File file = new File("Test2.txt");
        if (file.isFile()) {
            List<String> lines;
            Path filePars = Paths.get("D://Java//Files",name);
            if (filePars!=null) {
                lines = Files.readAllLines(filePars, StandardCharsets.UTF_8);
                String first = lines.get(0);
                lines.size();
                String[] parametersTest = first.split("\\|");
                String Subject = parametersTest[0];                                 //Название предмета

                Integer idSubject = db.defineTheidSubject(Subject);                   //определяет номер предмета
                Integer NumberOfQuestions = Integer.valueOf(parametersTest[1]);      // Количество вопросов

                Integer LeadTime = Integer.valueOf(parametersTest[2]);               // Время выполнения теста

                Integer TotalScore = Integer.valueOf(parametersTest[3]);             //Общий балл за тест
                if (idSubject!=null) {
                    Boolean TestAdded = db.addTest(idSubject, NumberOfQuestions, LeadTime, TotalScore);
                    Integer idTest = db.defineTheidTest(idSubject, NumberOfQuestions, LeadTime, TotalScore);
                    if (TestAdded && idTest!=null) {
                        for (int i = 0; i < NumberOfQuestions; i++) {
                            String next = lines.get(i + 1);
                            String[] QuestionsAnswer = next.split("\\|");
                            Integer typeQuestions = Integer.valueOf(QuestionsAnswer[0]); // тип вопроса

                            System.out.print(" Тип вопроса: " + typeQuestions);

                            String Questions = QuestionsAnswer[1]; // вопрос

                            System.out.print(" Вопрос: " + Questions + ".  ");

                            Integer NumberAnswer = Integer.valueOf(QuestionsAnswer[2]);
                            db.addQuestions(idTest, Questions, typeQuestions);

                            for (int j = 3; j < (NumberAnswer * 2) + 2; j = j + 2) {
                                String Answer = QuestionsAnswer[j];
                                Integer Mark = Integer.valueOf(QuestionsAnswer[j + 1]);
                                System.out.print("[" + Answer + " :");
                                System.out.print(Mark + " ]; ");


                            }
                        }
                    }

                }
                else {
                    System.out.println("Укажите корректное название предмета");

                }

//                System.out.println("Название предмета " + Subject);
//                System.out.println("Количество вопросов " + NumberOfQuestions);
//                System.out.println("Время выполнения теста " + LeadTime);
//                System.out.println("Общий балл за тест " + TotalScore);
//                System.out.println(" ");


                    System.out.println("");

                }
        }
        else{
            System.out.println("не прошел проверку");
        }
    }


}
