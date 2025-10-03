package org.panov.game.io.console.command.container;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.panov.game.piece.PieceType;
import org.panov.game.player.PlayerType;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
public class PlayerParameters {
    PlayerType playerType;
    PieceType pieceType;
}
