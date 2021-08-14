package battleship;

import battleship.dao.BattleshipDao;
import battleship.model.*;

/**
 * @author priyamvora
 * @created 02/05/2021
 */
public class Driver {
    public static void main(String[] args) {
        BattleshipDao battleshipDao = new BattleshipDao();
        Ship destroyer1 = new Destroyer();
        Ship submarine1 = new Submarine();
        Ship carrier1 = new Carrier();
        Ship cruiser1 = new Cruiser();
        Ship battleship1 = new Battleship();
        Coordinate destroyerStart = new Coordinate(2, 2);
        Coordinate destroyerEnd = new Coordinate(2, 3);
        battleshipDao.addShip(0, destroyer1, destroyerStart, destroyerEnd);

        Coordinate submarineStart = new Coordinate(3, 5);
        Coordinate submarineEnd = new Coordinate(5, 5);
        battleshipDao.addShip(0, submarine1, submarineStart, submarineEnd);

        Coordinate cruiserStart = new Coordinate(7, 0);
        Coordinate cruiserEnd = new Coordinate(9, 0);
        battleshipDao.addShip(0, cruiser1, cruiserStart, cruiserEnd);

        Coordinate battleShipStart = new Coordinate(0, 6);
        Coordinate battleShipEnd = new Coordinate(0, 9);
        battleshipDao.addShip(0, battleship1, battleShipStart, battleShipEnd);

        Coordinate carrierStart = new Coordinate(4, 0);
        Coordinate carrierEnd = new Coordinate(4, 4);
        battleshipDao.addShip(0, carrier1, carrierStart, carrierEnd);


        Ship destroyer2 = new Destroyer();
        Ship submarine2 = new Submarine();
        Ship carrier2 = new Carrier();
        Ship cruiser2 = new Cruiser();
        Ship battleship2 = new Battleship();

        Coordinate destroyerStart2 = new Coordinate(2, 2);
        Coordinate destroyerEnd2 = new Coordinate(2, 3);
        battleshipDao.addShip(1, destroyer2, destroyerStart2, destroyerEnd2);

        Coordinate submarineStart2 = new Coordinate(3, 5);
        Coordinate submarineEnd2 = new Coordinate(5, 5);
        battleshipDao.addShip(1, submarine2, submarineStart2, submarineEnd2);

        Coordinate cruiserStart2 = new Coordinate(7, 0);
        Coordinate cruiserEnd2 = new Coordinate(9, 0);
        battleshipDao.addShip(1, cruiser2, cruiserStart2, cruiserEnd2);

        Coordinate battleShipStart2 = new Coordinate(0, 6);
        Coordinate battleShipEnd2 = new Coordinate(0, 9);
        battleshipDao.addShip(1, battleship2, battleShipStart2, battleShipEnd2);

        Coordinate carrierStart2 = new Coordinate(4, 0);
        Coordinate carrierEnd2 = new Coordinate(4, 4);
        battleshipDao.addShip(1, carrier2, carrierStart2, carrierEnd2);
        battleshipDao.debug();

        battleshipDao.hitShip(0, 1, new Coordinate(2, 2));
        //Ship ship = battleshipDao.hitShip(0, 1, new Coordinate(2, 3));
        //battleshipDao.isShipDestroyed(0, 1, ship);
        battleshipDao.debug();

    }
}
