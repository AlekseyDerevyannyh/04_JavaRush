package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Aleksey");
            user1.setLastName("Petrov");
            user1.setBirthDate(new Date(1984, 1, 12));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            User user2 = new User();
            user2.setFirstName("Ekaterina");
            user2.setLastName("Konstantinova");
            user2.setBirthDate(new Date(1988, 2, 14));
            user2.setMale(false);
            user2.setCountry(User.Country.UKRAINE);
            User user3 = new User();
            user3.setFirstName("Aleksandr");
            user3.setLastName("Ivanov");
            user3.setBirthDate(new Date(1928, 5, 20));
            user3.setMale(true);
            user3.setCountry(User.Country.OTHER);
            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                if (users.isEmpty()) {
                    writer.write("0");
                    return;
                }
                writer.write(users.size() + "\n");
                for (User user : users) {
                    if (user.getFirstName() == null) {
                        writer.write("null\n");
                    } else {
                        writer.write(user.getFirstName() + "\n");
                    }
                    if (user.getLastName() == null) {
                        writer.write("null\n");
                    } else {
                        writer.write(user.getLastName() + "\n");
                    }
                    if (user.getBirthDate() == null) {
                        writer.write("null\n");
                    } else {
                        writer.write(String.valueOf(user.getBirthDate().getTime()) + "\n");
                    }
                    if (user.isMale()) {
                        writer.write("male\n");
                    } else {
                        writer.write("female\n");
                    }
                    if (user.getCountry() == null) {
                        writer.write("null\n");
                    } else {
                        writer.write(user.getCountry().getDisplayName() + "\n");
                    }
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                int count;
                if (reader.ready()) {
                    try {
                        count = Integer.parseInt(reader.readLine());
                    } catch (NumberFormatException e) {
                        return;
                    }
                } else {
                    return;
                }
                if (count <= 0) {
                    return;
                }

                for (int i = 0; i < count; i++) {
                    if (!reader.ready()) {
                        return;
                    }
                    String firstName = reader.readLine();
                    if (firstName.equals("null")) {
                        firstName = null;
                    }
                    if (!reader.ready()) {
                        return;
                    }
                    String lastName = reader.readLine();
                    if (lastName.equals("null")) {
                        lastName = null;
                    }
                    if (!reader.ready()) {
                        return;
                    }
                    String birthDateString = reader.readLine();
                    Date birthDate;
                    if (birthDateString.equals("null")) {
                        birthDate = null;
                    } else {
                        try {
                            birthDate = new Date(Long.parseLong(birthDateString));
                        } catch (NumberFormatException e) {
                            return;
                        }
                    }
                    if (!reader.ready()) {
                        return;
                    }
                    boolean isMale = reader.readLine().equals("male");
                    if (!reader.ready()) {
                        return;
                    }
                    String countryString = reader.readLine();
                    User.Country country;
                    switch (countryString) {
                        case "Ukraine":
                            country = User.Country.UKRAINE;
                            break;
                        case "Russia":
                            country = User.Country.RUSSIA;
                            break;
                        default:
                            country = User.Country.OTHER;
                    }
                    User user = new User();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setBirthDate(birthDate);
                    user.setMale(isMale);
                    user.setCountry(country);
                    this.users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;
        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
