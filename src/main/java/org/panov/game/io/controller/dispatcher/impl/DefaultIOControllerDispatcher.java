package org.panov.game.io.controller.dispatcher.impl;

import org.panov.game.io.controller.IOController;
import org.panov.game.io.controller.dispatcher.IOControllerDispatcher;

import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultIOControllerDispatcher implements IOControllerDispatcher {
    private final Map<String, IOController> controllers = new ConcurrentHashMap<>();

    public DefaultIOControllerDispatcher(IOController... controllers) {
        for (IOController controller : controllers) {
            this.controllers.put(controller.getType(), controller);
        }
    }

    @Override
    public Optional<IOController> findIOController(String controllerType) {
        return Optional.ofNullable(this.controllers.get(controllerType));
    }

    @PreDestroy
    public void destroy() {
        this.controllers.clear();
    }
}
