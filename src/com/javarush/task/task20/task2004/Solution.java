package com.javarush.task.task20.task2004;

import java.io.*;

/* 
Читаем и пишем в файл статики
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //here check that the classWithStatic object is equal to the loadedObject object - проверьте тут, что classWithStatic и loadedObject равны
            System.out.println(classWithStatic.equals(loadedObject));

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

    public static class ClassWithStatic {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                if (staticString == null) {
                    writer.write("null\n");
                } else {
                    writer.write(staticString + "\n");
                }
                writer.write(i + "\n");
                writer.write(j + "\n");
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                if (!reader.ready()) {
                    return;
                }
                String line = reader.readLine();
                if (line.equals("null")) {
                    line = null;
                }
                staticString = line;
                if (!reader.ready()) {
                    return;
                }
                int i;
                try {
                    i = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    return;
                }
                this.i = i;
                if (!reader.ready()) {
                    return;
                }
                int j;
                try {
                    j = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    return;
                }
                this.j = j;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic that = (ClassWithStatic) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
