public class Person {
    @Deprecated
    public String name;
    @Deprecated
    private String surname;

    public String gender;
    @Deprecated
    public Integer age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }
}
