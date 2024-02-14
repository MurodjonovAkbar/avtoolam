package org.example.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;

public class UserServiceImpl implements UserServiceImple {
    private final String fileName = "users.txt";
    private FileServiceImpl fileService = new FileServiceImpli();

    @Override
    public User create(User user) {
        String dataFromFile = fileService.getDataFromFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<User> list = objectMapper.readValue(dataFromFile, List.class);
            list.add(user);
            Gson gson = new Gson();
            String json = gson.toJson(list);
            boolean b = fileService.writeDataToFile(json, fileName);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User getUser(long chatId) {
        String dataFromFile = fileService.getDataFromFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<User> list = objectMapper.readValue(dataFromFile, List.class);
            for (User user : list) {
                if (user.getId() == chatId) {
                    return user;
                }
            }
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
