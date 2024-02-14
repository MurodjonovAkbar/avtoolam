package org.example.service.impl;

public interface FileServiceImpl {
    String getDataFromFile(String fileName);

    boolean writeDataToFile(String data, String fileName);
}
