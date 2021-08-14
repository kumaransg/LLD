package battleship.dao;

import battleship.model.Board;
import battleship.model.Coordinate;
import battleship.model.Ship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author priyamvora
 * @created 02/05/2021
 */
public class  BattleshipDao {
    private static final Integer TOTAL_SHIPS_EACH_PLAYER = 5;
    private final Map<String, List<Coordinate>> shipToCoordinatesMap;
    private final Board board;
    private final Map<Integer, Integer> playerToOppSinkMap;

    public BattleshipDao() {
        this.shipToCoordinatesMap = new HashMap<>();
        this.board = new Board();
        this.playerToOppSinkMap = new HashMap<>();
    }

    public void debug() {
        System.out.println(shipToCoordinatesMap);
        System.out.println(board);
        System.out.println(playerToOppSinkMap);
    }

    public void addShip(Integer playerNum, Ship ship, Coordinate start, Coordinate end) {
        board.addShip(playerNum, ship, start, end);
        List<Coordinate> coordinates = shipToCoordinatesMap.getOrDefault(ship.getShipId(), new ArrayList<>());
        coordinates.add(start);
        coordinates.add(end);
        shipToCoordinatesMap.put(ship.getShipId(), coordinates);
    }

    public Ship hitShip(Integer playerNum, Integer playerToHit, Coordinate coordinate) {
        return board.hitShip(playerNum, playerToHit, coordinate);
    }

    public boolean isShipDestroyed(Integer playerNum, Integer playerToHit, Ship ship) {
        boolean isShipDestroyed = board.isShipDestroyed(playerToHit, shipToCoordinatesMap.get(ship.getShipId()).get(0), shipToCoordinatesMap.get(ship.getShipId()).get(1));
        if (isShipDestroyed) {
            playerToOppSinkMap.put(playerNum, playerToOppSinkMap.getOrDefault(playerNum, 0) + 1);
        }
        return isShipDestroyed;
    }

    public boolean hasPlayerWon(Integer playerNum) {
        return playerToOppSinkMap.getOrDefault(playerNum, 0).equals(TOTAL_SHIPS_EACH_PLAYER);
    }
}
