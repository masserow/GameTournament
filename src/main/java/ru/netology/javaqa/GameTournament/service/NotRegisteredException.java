package ru.netology.javaqa.GameTournament.service;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String playerName) {
        super("Игрок" + playerName + "не найден");
    }
}
