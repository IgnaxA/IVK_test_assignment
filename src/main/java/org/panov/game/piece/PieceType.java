package org.panov.game.piece;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PieceType {
    WHITE("W"),
    BLACK("B");

    private final String name;
}
