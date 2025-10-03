package org.panov.game.io.console.command.mapper.impl;

import lombok.NoArgsConstructor;
import org.panov.game.io.console.command.Command;
import org.panov.game.io.console.command.container.PlayerParameters;
import org.panov.game.io.console.command.container.TwoPlayersGameParameters;
import org.panov.game.io.console.command.managing.impl.TwoPlayersGameCommand;
import org.panov.game.io.console.command.mapper.BaseCommandMapper;
import org.panov.game.io.console.command.util.Assertions;
import org.panov.game.piece.PieceType;
import org.panov.game.player.PlayerType;

import java.util.List;

@NoArgsConstructor
public class GameCommandMapper extends BaseCommandMapper {
    private static final int ARGUMENTS_NUMBER = 3;
    private static final int BOARD_SIZE_INDEX = 0;
    private static final int FIRST_PLAYER_PARAMETERS_INDEX = 1;
    private static final int SECOND_PLAYER_PARAMETERS_INDEX = 2;

    private static final int PLAYER_PARAMETERS_NUMBER = 2;
    private static final String PLAYER_PARAMETERS_SEPARATOR = " ";
    private static final int PLAYER_TYPE_INDEX = 0;
    private static final int PIECE_TYPE_INDEX = 1;

    @Override
    public String getAssignedCommandName() {
        return TwoPlayersGameCommand.NAME;
    }

    @Override
    protected Command mapCommand(List<String> arguments) {
        int boardSize = this.getBoardSizeArgument(arguments);
        PlayerParameters firstPlayerParameters = this.getFirstPlayerParameters(arguments);
        PlayerParameters secondPlayerParameters = this.getSecondPlayerParameters(arguments);

        TwoPlayersGameParameters gameParameters = this.createGameParameters(
                boardSize,
                firstPlayerParameters,
                secondPlayerParameters
        );

        return this.createGameCommand(gameParameters);
    }

    @Override
    protected int getArgumentsNumber() {
        return ARGUMENTS_NUMBER;
    }

    private int getBoardSizeArgument(List<String> arguments) {
        String boardSizeArgument = arguments.get(BOARD_SIZE_INDEX);

        int boardSize = this.parseBoardSize(boardSizeArgument);

        return boardSize;
    }

    private int parseBoardSize(String argument) {
        int boardSize;
        try {
            boardSize = Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid board size: " + argument);
        }

        return boardSize;
    }

    private PlayerParameters getFirstPlayerParameters(List<String> arguments) {
        String firstPlayerParametersArgument = arguments.get(FIRST_PLAYER_PARAMETERS_INDEX);

        PlayerParameters firstPlayerParameters = this.parsePlayerParameters(firstPlayerParametersArgument);

        return firstPlayerParameters;
    }

    private PlayerParameters getSecondPlayerParameters(List<String> arguments) {
        String secondPlayerParametersArgument = arguments.get(SECOND_PLAYER_PARAMETERS_INDEX);

        PlayerParameters secondPlayerParameters = this.parsePlayerParameters(secondPlayerParametersArgument);

        return secondPlayerParameters;
    }

    private PlayerParameters parsePlayerParameters(String argument) {
        String[] parameters = argument.split(PLAYER_PARAMETERS_SEPARATOR);
        Assertions.assertPlayerParametersNumber(parameters, PLAYER_PARAMETERS_NUMBER);

        PlayerType playerType = this.parsePlayerType(parameters[PLAYER_TYPE_INDEX]);
        PieceType pieceType = this.parsePieceType(parameters[PIECE_TYPE_INDEX]);

        PlayerParameters playerParameters = new PlayerParameters()
            .setPlayerType(playerType)
            .setPieceType(pieceType);

        return playerParameters;
    }

    private PlayerType parsePlayerType(String argument) {
        PlayerType playerType = PlayerType.getPlayerType(argument);

        return playerType;
    }

    private PieceType parsePieceType(String argument) {
        PieceType pieceType = PieceType.getPieceType(argument);

        return pieceType;
    }

    private TwoPlayersGameParameters createGameParameters(int boardSize,
                                                          PlayerParameters firstPlayerParameters,
                                                          PlayerParameters secondPlayerParameters) {
        TwoPlayersGameParameters gameParameters = new TwoPlayersGameParameters()
            .setBoardSize(boardSize)
            .setFirstPlayer(firstPlayerParameters)
            .setSecondPlayer(secondPlayerParameters);

        return gameParameters;
    }

    private TwoPlayersGameCommand createGameCommand(TwoPlayersGameParameters gameParameters) {
        TwoPlayersGameCommand gameCommand = new TwoPlayersGameCommand(gameParameters);

        return gameCommand;
    }
}
