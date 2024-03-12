package org.Bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

public class MyBot2 extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);

        KeyboardButton keyboardButton1 = KeyboardButton
                .builder()
                .text("1")
                .build();

        KeyboardButton keyboardButton2 = KeyboardButton
                .builder()
                .text("2")
                .build();

        KeyboardButton keyboardButton3 = KeyboardButton
                .builder()
                .text("3")
                .build();

        KeyboardButton keyboardButton4 = KeyboardButton
                .builder()
                .text("4")
                .build();

        KeyboardRow row1 = new KeyboardRow();
                row1.add(keyboardButton1);
                row1.add(keyboardButton2);

        KeyboardRow row2 = new KeyboardRow();
        row1.add(keyboardButton3);
        row2.add(keyboardButton4);

        KeyboardRow rows = new KeyboardRow();
        row1.add(keyboardButton2);

    }

    @Override
    public String getBotUsername() {
        return "@Dars_mashq_bot";
    }
    public String getBotToken(){

        return"7187995039:AAGmfYfVC7VxC5roXj0dfZVnyQJX_tks728" ;
    }
}
