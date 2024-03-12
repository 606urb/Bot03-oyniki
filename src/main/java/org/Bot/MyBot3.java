package org.Bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.LinkedList;
import java.util.List;

public class MyBot3 extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();

        KeyboardRow row1 = new KeyboardRow();
        row1.add("\uD83D\uDCB8 Tolov");
        row1.add("\uD83D\uDCB0 Balans");
        KeyboardRow row2 = new KeyboardRow();
        row2.add("\uD83D\uDD00 O'tkazmalar");
        row2.add("\uD83D\uDCC6 Tolovlar tarix");

        KeyboardRow row3 = new KeyboardRow();
        row3.add("↙\uFE0F Kiruvchi hisoblar");
        row3.add("\uD83C\uDF1F Saralangan to'lovlar");


        List<KeyboardRow> rows = new LinkedList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);


        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(rows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        SendMessage sendMessage = SendMessage.builder()
                .text("Hello")
                .chatId(message.getChatId())
                .replyMarkup(replyKeyboardMarkup)
                .build();

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getBotUsername() {
        return "@Dars_mashq_bot";
    }

    public String getBotToken(){

        return"7187995039:AAGmfYfVC7VxC5roXj0dfZVnyQJX_tks728" ;
    }
}
