package org.example.service.impl;

public interface FileServices {
    String getDataFromFile(String fileName);
    boolean writeDataToFile(String data, String fileName);
}
