public class Users {

    private String firstName;

    private String lastName;

    private String patronymic;

    private Integer age;

    private String passport;

    @Override
    public String toString() {
        return "Users{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", passport='" + passport + '\'' +
                '}';
    }

    public Users(String firstName, String lastName, String patronymic, Integer age, String passport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.age = age;
        this.passport = passport;
    }

    public Integer getAge() {
        return age;
    }
}
