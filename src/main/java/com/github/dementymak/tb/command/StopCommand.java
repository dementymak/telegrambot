package com.github.dementymak.tb.command;

import com.github.dementymak.tb.repository.entity.TelegramUser;
import com.github.dementymak.tb.service.SendBotMessageService;
import com.github.dementymak.tb.service.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Optional;

/**
 * Stop {@link Command}.
 */
public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;
    public static final String STOP_MESSAGE = "Деактивировал все твои подписки \uD83D\uDE1F.\n" +
            "Ты всегда можешь вернуться нажав /start";

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
        telegramUserService.findByChatId(update.getMessage().getChatId().toString())
                .ifPresent(it -> {
                    it.setActive(false);
                    telegramUserService.save(it);
                });
    }
}
