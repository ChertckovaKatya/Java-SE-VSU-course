
import java.sql.*;

public class DatabaseHandler {

        private Connection conn = null;
        private ResultSet result;
        private PreparedStatement preStm;
        public static Statement dbConnection;

        public DatabaseHandler() {
//        String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/sys_analysis_management?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            //System.out.println(myUrl);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.conn = DriverManager.getConnection(myUrl, "root", "");
//            dbConnection = DriverManager.getConnection(myUrl,dbUser,dbPass).createStatement();
//            result = dbConnection.executeQuery(query);
            } catch (ClassNotFoundException e) {
                System.err.println("Ошибка подключения к базе данных!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Ошибка подключения к базе данных!");
                e.printStackTrace();
            }
        }

        public Connection getConnection(){
            return this.conn;
        }

        public Boolean addTest(Integer idSubjectTest, Integer QuantityQuestions,Integer LeadTime, Integer TotalScore){
            String query= "INSERT INTO test (idSubjectTest, QuantityQuestions, LeadTime, TotalScore)"+" VALUES (?,?,?,?)";
            try {
                preStm = conn.prepareStatement(query);
                preStm.setInt(1,idSubjectTest);
                preStm.setInt(2,QuantityQuestions);
                preStm.setInt(3,LeadTime);
                preStm.setInt(4,TotalScore);
                preStm.execute();
                conn.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public Integer defineTheidSubject (String subject) throws SQLException {
            Integer idSubject = null;
            String query= "SELECT idSubject FROM subject WHERE SubjectName=\"Математика\"";
            ResultSet id = resultQuery(query);
            if(id.next()){
                idSubject = id.getInt("idSubject");
            }
            else{
                System.out.println("Предмета с названием: "+subject+" не существует");
            }
            return idSubject;
        }

        public Integer defineTheidTest (Integer idSubjectTest, Integer QuantityQuestions,Integer LeadTime, Integer TotalScore) throws SQLException {
            Integer idTest = null;
            String query = "SELECT idTest FROM test where idSubjectTest="+idSubjectTest+" AND QuantityQuestions="+QuantityQuestions+" AND LeadTime="+LeadTime+" AND TotalScore="+TotalScore+" ORDER\n" +
                    "    BY idTest DESC LIMIT 1;";
            ResultSet id = resultQuery(query);
            if(id.next()){
                idTest = id.getInt("idTest");
            }
            else{
                System.out.println("Теста с данными параметрами не существует");
            }
            return idTest;
        }

        public Boolean addQuestions (Integer idTestQuestions,String QuestionWording, Integer TypeQues){

            String query= "INSERT INTO  questions (idTestQuestions, QuestionWording, TypeQues)"+" VALUES (?,?,?)";
            try {
                preStm = conn.prepareStatement(query);
                preStm.setInt(1,idTestQuestions);
                preStm.setString(2,QuestionWording);
                preStm.setInt(3,TypeQues);
                preStm.execute();
                conn.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        public Integer defineTheidQuestions(Integer idTestQuestions,String QuestionWording, Integer TypeQues) throws SQLException {
            Integer idQuestions = null;
            String query = "SELECT idQuestions from questions where QuestionWording="+QuestionWording+" AND TypeQues="+TypeQues+" AND questions.idTestQuestions="+idTestQuestions+";";
            ResultSet id = resultQuery(query);
            if(id.next()){
                idQuestions = id.getInt("idQuestions");
            }
            else{
                System.out.println("Вопроса с данными параметрами не существует");
            }
            return idQuestions;
        }

        public Boolean addAnswer(Integer idQuestionAnswer,String AnswerWording,Integer Mark){

            String query= "INSERT INTO answer (idQuestionAnswer, AnswerWording, Mark)"+" VALUES (?,?,?)";
            try {
                preStm = conn.prepareStatement(query);
                preStm.setInt(1,idQuestionAnswer);
                preStm.setString(2,AnswerWording);
                preStm.setInt(3,Mark);
                preStm.execute();
                conn.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;

            }

        }


        public ResultSet resultQuery (String query) {
            try {
                dbConnection = this.conn.createStatement();
                result = dbConnection.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }
//        public Boolean CheckLoginName (User user) throws SQLException, ClassNotFoundException {
//            ResultSet result = null;
//            String name = user.getName();
//            String password = user.getPassword();
//            String query = "SELECT Name,Password from User where Name='"+ name +"' AND Password = '" + password + "';";
//            System.out.println("SELECT Name,Password from User where Name='"+ name +"' AND Password = '" + password + "';");
//            result = resultQuery(query);
//            if (result.next()) {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }

    }

