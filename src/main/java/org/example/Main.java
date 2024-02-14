package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new MyBot("6611342834:AAHyEXzAJ3phLpYBtUa8tv9MbQcL6p5oC8I"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}