import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test5 {
    private static int FIELD_COUNTS = 5;
    
    public static void main(String[] args) {
        getUsers();
    }

    private static void getUsers() {
        try (FileReader fr = new FileReader("/Users/tatananedikova/IdeaProjects/otr/src/users.txt")) {
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            String firstName = null;
            String lastName = null;
            String patronymic = null;
            Integer age = 0;
            String passport = null;
            List<Users> users = new ArrayList<Users>();
            int count = 1;
            while (line != null) {
                if (count % FIELD_COUNTS == 0) {
                    if (!line.isEmpty()) {
                        passport = line;
                    }
                    Users newUser = new Users(firstName, lastName, patronymic, age, passport);
                    users.add(newUser);
                } else if (count % FIELD_COUNTS == 1) {
                    //на первой строке обнуляем все переменные
                    firstName = null;
                    lastName = null;
                    patronymic = null;
                    age = 0;
                    passport = null;
                    if (!line.isEmpty()) {
                        lastName = line;
                    }
                } else if ((count % FIELD_COUNTS == 2) && (!line.isEmpty())) {
                    firstName = line;
                } else if ((count % FIELD_COUNTS == 3) && (!line.isEmpty())) {
                    patronymic = line;
                } else if ((count % FIELD_COUNTS == 4) && (!line.isEmpty())) {
                    age = Integer.valueOf(line);
                }
                line = reader.readLine();
                count++;
            }
            Stream.concat(
                    users.stream()
                            .filter((u) -> u.getAge() == 0),
                    users.stream()
                            .filter((u) -> u.getAge() != 0)
                            .sorted((o1, o2) -> -o1.getAge().compareTo(o2.getAge())))
                    .forEach(user -> System.out.println(user));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
