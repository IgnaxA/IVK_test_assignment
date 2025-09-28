package org.panov.game.io.controller.dispatcher;

import org.panov.game.io.controller.IOController;

import java.util.Optional;

public interface IOControllerDispatcher {
    Optional<IOController> findIOController(String controllerType);
}
