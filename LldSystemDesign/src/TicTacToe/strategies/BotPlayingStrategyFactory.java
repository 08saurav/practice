package TicTacToe.strategies;

import TicTacToe.models.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static EasyBotPlayingStrategy getBotPlayingStrategyByDifficultyLevel(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new EasyBotPlayingStrategy();
        }
        return null;
    }
}