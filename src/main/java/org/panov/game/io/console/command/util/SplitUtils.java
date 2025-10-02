package org.panov.game.io.console.command.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitUtils {
    public static final char SPACE = ' ';
    public static final String ARGUMENT_SEPARATOR = ", ";

    public static List<String> getArguments(String arguments) {
        return Arrays.stream(arguments.split(SplitUtils.ARGUMENT_SEPARATOR))
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());
    }
}
