package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                if (this.name == null) {
                    writer.write("null");
                } else {
                    writer.write(this.name);
                }
                writer.write("\n");
                if (assets.isEmpty()) {
                    writer.write("0");
                } else {
                    writer.write(String.valueOf(assets.size()));
                }
                writer.write("\n");

                for (Asset asset : assets) {
                    writer.write(asset.getName());
                    writer.write("\n");
                    writer.write(String.valueOf(asset.getPrice()));
                    writer.write("\n");
                }
                writer.flush();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String name;
                if (reader.ready()) {
                    name = reader.readLine();
                    if (name.equals("null")) {
                        name = null;
                    }
                } else {
                    return;
                }
                this.name = name;
                int count;
                if (reader.ready()) {
                    try {
                        count = Integer.parseInt(reader.readLine());
                    }  catch (NumberFormatException e) {
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
                    String assetName = reader.readLine();
                    if (!reader.ready()) {
                        return;
                    }
                    double assetPrice;
                    try {
                        assetPrice = Double.parseDouble(reader.readLine());
                    } catch (NumberFormatException e) {
                        return;
                    }
                    Asset asset = new Asset(assetName, assetPrice);
                    this.assets.add(asset);
                }
            }
        }
    }
}
