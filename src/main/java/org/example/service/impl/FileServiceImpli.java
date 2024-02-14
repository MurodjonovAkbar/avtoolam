package org.example.service.impl;

import java.io.*;

public class FileServiceImpli implements FileServiceImpl {
    @Override
    public String getDataFromFile(String fileName) {
        File file = new File("\"C:\\Users\\User\\Desktop\\Новая папка\\Новый текстовый документ.txt\"" + fileName);
        System.out.println(1);
        StringBuilder builder = new StringBuilder();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bf = new BufferedReader(reader);
            String line;
            while((line = bf.readLine()) != null){
                builder.append(line);
            }
            bf.close();
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return builder.toString();
    }

    @Override
    public boolean writeDataToFile(String data, String fileName) {
        File file = new File("\"C:\\Users\\User\\Desktop\\Новая папка\\Новый текстовый документ.txt\"" + fileName);
        System.out.println(file.getAbsolutePath());
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
