package com.company;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {

    private String text = "0";

    @Override
    public void onUpdateReceived(Update update) {

        System.out.println("update");

        if (update.hasMessage()) {
            Message message = update.getMessage();

            SendMessage sendMessage = SendMessage
                    .builder()
                    .text(text)
                    .chatId(message.getChatId())
                    .build();

            sendMessage.setReplyMarkup(getKeyboard());

            sendMSG(sendMessage);

        } else if (update.hasCallbackQuery()) {

            CallbackQuery callbackQuery = update.getCallbackQuery();
            Message message = (Message) callbackQuery.getMessage();

            String temp = callbackQuery.getData();

//            text = text + temp;

            if (//            temp.equals("0") ||
//                            temp.equals("1") ||
//                            temp.equals("2") ||
//                            temp.equals("3") ||
//                            temp.equals("4") ||
//                            temp.equals("5") ||
//                            temp.equals("6") ||
//                            temp.equals("7") ||
//                            temp.equals("8") ||
//                            temp.equals("9")
                    temp.matches("[0-9]")) {
                text = text + temp;
            }
            else if (temp.equals("+") ||
                    temp.equals("-") ||
                    temp.equals("*") ||
                    temp.equals("/")) {

                text = text + temp;

            } else if (temp.equals("C")) {
                text = "0";

            } else if (temp.equals("=")) {

                // 12 + 3
                // 0  1  2
                // 12
                // +
                // 3
                if (text.split("\\+").length == 2) {
                    //12 + 3 + 9 + 5
                    // 12 + 3 only this
                    String[] numbers = text.split("\\+");

                    double result = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]); // 12 + 3

                    EditMessageText editMessageText = EditMessageText
                            .builder()
                            .text(String.valueOf(result))
                            .chatId(message.getChatId())
                            .messageId(message.getMessageId())
                            .build();
                    editMessageText.setReplyMarkup(getKeyboard());

                    editMSG(editMessageText);
                    return;

                } else if (text.split("\\-").length == 2) {
                    //12 - 3 - 9 - 5
                    // 12 - 3 only this


                } else if (text.split("\\/").length == 2) {
                    //12 / 3 / 9 / 5
                    // 12 / 3 only this


                } else if (text.split("\\*").length == 2) {
                    //12 * 3 * 9 * 5
                    // 12 * 3 only this

                }
            }

            EditMessageText editMessageText = EditMessageText
                        .builder()
                        .text(text)
                        .chatId(message.getChatId())
                        .messageId(message.getMessageId())
                        .build();

            editMessageText.setReplyMarkup(getKeyboard());

            editMSG(editMessageText);

        }

    }

    private void editMSG(EditMessageText editMessageText) {
        try {
            execute(editMessageText);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private InlineKeyboardMarkup getKeyboard() {

        InlineKeyboardButton button0 = InlineKeyboardButton
                .builder()
                .text("0")
                .callbackData("0")
                .build();


        InlineKeyboardButton button1 = InlineKeyboardButton
                .builder()
                .text("1")
                .callbackData("1")
                .build();

        InlineKeyboardButton button2 = InlineKeyboardButton
                .builder()
                .text("2")
                .callbackData("2")
                .build();

        InlineKeyboardButton button3 = InlineKeyboardButton
                .builder()
                .text("3")
                .callbackData("3")
                .build();

        InlineKeyboardButton button4 = InlineKeyboardButton
                .builder()
                .text("4")
                .callbackData("4")
                .build();

        InlineKeyboardButton button5 = InlineKeyboardButton
                .builder()
                .text("5")
                .callbackData("5")
                .build();

        InlineKeyboardButton button6 = InlineKeyboardButton
                .builder()
                .text("6")
                .callbackData("6")
                .build();

        InlineKeyboardButton button7 = InlineKeyboardButton
                .builder()
                .text("7")
                .callbackData("7")
                .build();

        InlineKeyboardButton button8 = InlineKeyboardButton
                .builder()
                .text("8")
                .callbackData("8")
                .build();

        InlineKeyboardButton button9 = InlineKeyboardButton
                .builder()
                .text("9")
                .callbackData("9")
                .build();


        InlineKeyboardButton plus = InlineKeyboardButton
                .builder()
                .text("+")
                .callbackData("+")
                .build();

        InlineKeyboardButton minus = InlineKeyboardButton
                .builder()
                .text("-")
                .callbackData("-")
                .build();

        InlineKeyboardButton divide = InlineKeyboardButton
                .builder()
                .text("/")
                .callbackData("/")
                .build();

        InlineKeyboardButton multiply = InlineKeyboardButton
                .builder()
                .text("*")
                .callbackData("*")
                .build();

        InlineKeyboardButton equals = InlineKeyboardButton
                .builder()
                .text("=")
                .callbackData("=")
                .build();

        InlineKeyboardButton clear = InlineKeyboardButton
                .builder()
                .text("C")
                .callbackData("C")
                .build();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(button7);
        row1.add(button8);
        row1.add(button9);
        row1.add(divide);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(button4);
        row2.add(button5);
        row2.add(button6);
        row2.add(multiply);

        List<InlineKeyboardButton> row3 = new ArrayList<>();
        row3.add(button1);
        row3.add(button2);
        row3.add(button3);
        row3.add(minus);

        List<InlineKeyboardButton> row4 = new ArrayList<>();
        row4.add(clear);
        row4.add(button0);
        row4.add(equals);
        row4.add(plus);

        List<List<InlineKeyboardButton>> rows = new ArrayList<>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
        rows.add(row4);

        return InlineKeyboardMarkup
                .builder()
                .keyboard(rows)
                .build();
    }

    private void sendMSG(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "@bot_testoviY_project_bot";
    }

    @Override
    public String getBotToken() {
        return "7056756199:AAEwQ9I6iv0-6CH994_ifRxRAuUbYC1vofc";
    }
}
