package org.panov.game.io.console.command.mapper.impl;

import lombok.NoArgsConstructor;
import org.panov.game.io.console.command.Command;
import org.panov.game.io.console.command.container.MoveParameters;
import org.panov.game.io.console.command.managing.impl.MoveCommand;
import org.panov.game.io.console.command.mapper.BaseCommandMapper;

import java.util.List;

@NoArgsConstructor
public class MoveCommandMapper extends BaseCommandMapper {
    private static final int ARGUMENTS_NUMBER = 2;

    private static final int X_COORDINATE_INDEX = 0;
    private static final int Y_COORDINATE_INDEX = 1;

    @Override
    public String getAssignedCommandName() {
        return MoveCommand.NAME;
    }

    @Override
    protected Command mapCommand(List<String> arguments) {
        int xCoordinate = this.getXCoordinate(arguments);
        int yCoordinate = this.getYCoordinate(arguments);

        MoveParameters moveParameters = this.createMoveParameters(xCoordinate, yCoordinate);

        return this.createMoveCommand(moveParameters);
    }

    @Override
    protected int getArgumentsNumber() {
        return ARGUMENTS_NUMBER;
    }

    private int getXCoordinate(List<String> arguments) {
        String xCoordinateArgument = arguments.get(X_COORDINATE_INDEX);

        int xCoordinate = this.parseCoordinate(xCoordinateArgument);

        return xCoordinate;
    }

    private int getYCoordinate(List<String> arguments) {
        String yCoordinateArgument = arguments.get(Y_COORDINATE_INDEX);

        int yCoordinate = this.parseCoordinate(yCoordinateArgument);

        return yCoordinate;
    }

    private int parseCoordinate(String argument) {
        int xCoordinate;

        try {
            xCoordinate = Integer.parseInt(argument);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid coordinate number: " + argument);
        }

        return xCoordinate;
    }

    private MoveParameters createMoveParameters(int xCoordinate, int yCoordinate) {
        MoveParameters moveParameters = new MoveParameters()
            .setXCoordinate(xCoordinate)
            .setYCoordinate(yCoordinate);

        return moveParameters;
    }

    private MoveCommand createMoveCommand(MoveParameters moveParameters) {
        MoveCommand moveCommand = new MoveCommand(moveParameters);

        return moveCommand;
    }
}
