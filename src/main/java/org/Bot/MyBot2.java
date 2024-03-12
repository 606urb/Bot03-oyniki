
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

public class MyBot2 extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();

        KeyboardRow row1 = new KeyboardRow();
        row1.add("\uD83D\uDECD Buyurtma berish");

        KeyboardRow row2 = new KeyboardRow();
        row2.add("\uD83C\uDF89 Aksiya");
        row2.add("\uD83C\uDFD8 Barcha filyallar");

        KeyboardRow row3 = new KeyboardRow();
        row3.add("\uD83D\uDCE6 Mening buyutmam");
        row3.add("\uD83D\uDCDD Izoh qoldirish");

        KeyboardRow row4 = new KeyboardRow();
        row4.add("\uD83D\uDCBC Vakansiyalar");
        row4.add("ℹ\uFE0F Biz haqimizda");

        List<KeyboardRow> rows = new LinkedList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);


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
