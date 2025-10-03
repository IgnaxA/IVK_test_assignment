package org.panov.game.piece;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum PieceType {
    WHITE("w"),
    BLACK("b");

    private final String name;

    public static PieceType getPieceType(String pieceType) {
        for (PieceType type : PieceType.values()) {
            if (type.getName().equalsIgnoreCase(pieceType)) {
                return type;
            }
        }

        throw new RuntimeException("Unknown piece type: " + pieceType);
    }
}
