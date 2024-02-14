package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import static org.example.BotState.*;

public class MyBot extends TelegramLongPollingBot{
    public MyBot(String token){
        super(token);
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            if (text.equals("/start")) {
                InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
                List<InlineKeyboardButton> row2 = new ArrayList<>();
                InlineKeyboardButton button2 = new InlineKeyboardButton();
                button2.setText("Tekshirish");
                button2.setCallbackData("check");
                row2.add(button2);
                rowList.add(row2);

                markup.setKeyboard(rowList);

                SendMessage message = new SendMessage();
                message.setText("Siz kanalga a'zo bo'lmadingiz va bepul darslardan foydalana olmaysiz!-->https://t.me/AvtoMetro");
                message.setChatId(chatId);
                message.setReplyMarkup(markup);

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

        } else if (update.hasCallbackQuery()) {
            Long chatId = update.getMessage().getChatId();
            String data = update.getCallbackQuery().getData();
            switch (data) {
                case "check" -> {
                    GetChatMember member = new GetChatMember();
                    member.setChatId("https://t.me/AvtoMetro");
                    member.setUserId(update.getCallbackQuery().getMessage().getChatId());
                    ChatMember user = null;
                    try {
                        user = execute(member);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    if (user.getStatus().equals("member") || user.getStatus().equals("creator") || user.getStatus().equals("administrator")) {
                        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                        List<List<InlineKeyboardButton>> list = new ArrayList<>();
                        List<InlineKeyboardButton> row = new ArrayList<>();
                        InlineKeyboardButton button = new InlineKeyboardButton();
                        button.setText("O'zbek(lotin)\uD83C\uDDFA\uD83C\uDDFF");
                        button.setCallbackData(String.valueOf("uzb"));
                        row.add(button);
                        List<InlineKeyboardButton> row1 = new ArrayList<>();
                        InlineKeyboardButton button1 = new InlineKeyboardButton();
                        button1.setText("Русский\uD83C\uDDF7\uD83C\uDDFA");
                        button1.setCallbackData(String.valueOf("rus"));
                        row1.add(button1);
                        InlineKeyboardButton button2 = new InlineKeyboardButton();
                        button2.setText("Ўзбекча(крилл)\uD83C\uDDFA\uD83C\uDDFF");
                        button2.setCallbackData(String.valueOf("uzk"));
                        row1.add(button2);
                        list.add(row1);
                        list.add(row);
                        markup.setKeyboard(list);
                        SendMessage message = new SendMessage();
                        message.setText("Tilni tanlang\uD83D\uDC47\nВыберите язык\uD83D\uDC47\nТилни танланг\uD83D\uDC47");
                        message.setChatId(chatId);
                        message.setReplyMarkup(markup);
                        try {
                            execute(message);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }case "uzb"->{
                    InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> list = new ArrayList<>();
                    List<InlineKeyboardButton> row = new ArrayList<>();
                    InlineKeyboardButton button = new InlineKeyboardButton();
                    button.setText("Standart test");
                    button.setCallbackData(String.valueOf("uzb"));
                    row.add(button);
                    List<InlineKeyboardButton> row1 = new ArrayList<>();
                    InlineKeyboardButton button1 = new InlineKeyboardButton();
                    button1.setText("Русский\uD83C\uDDF7\uD83C\uDDFA");
                    button1.setCallbackData(String.valueOf("rus"));
                    row1.add(button1);
                    InlineKeyboardButton button2 = new InlineKeyboardButton();
                    button2.setText("Ўзбекча(крилл)\uD83C\uDDFA\uD83C\uDDFF");
                    button2.setCallbackData(String.valueOf("uzk"));
                    row1.add(button2);
                    list.add(row1);
                    list.add(row);
                    markup.setKeyboard(list);
                    SendMessage message = new SendMessage();
                    message.setText("Tilni tanlang\uD83D\uDC47\nВыберите язык\uD83D\uDC47\nТилни танланг\uD83D\uDC47");
                    message.setChatId(chatId);
                    message.setReplyMarkup(markup);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "qataristonbot";
    }
}
