package SystemDesign.SnakeAndLadder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
class Player {
    private String playerName;
    private int id;

    Player(String playerName, int id) {
        this.playerName = playerName;
        this.id = id;
    }
}
