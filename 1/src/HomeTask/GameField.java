package HomeTask;

/**
 * Игровое поле для игрока
 */
public class GameField {
    private Ship[] ships;
    private int aliveShipsCnt;
    private int[] shipsTypes;


    /**
     * Проверяет возможно ли добавить корабль определенного типа
     * @param newShip
     * @return
     */
    public boolean isPossibleToAddShip(Ship newShip) {
        this.isPossibleToAddShipWithSize(newShip.getSize());

        //Проверить координаты
    }

    private boolean isPossibleToAddShipWithSize(int newShipSize) {
        int shipsWithSameSizeCnt = 0;
        for (Ship ship: ships) {
            if (ship.getSize() == newShipSize) {
                shipsWithSameSizeCnt++;
            }
        }

        if (5 - newShipSize < shipsWithSameSizeCnt) {
            return false;
        }
        return true;
    }

    private boolean isPossibleToAddShipWithCoords(Coordinate coords) {

    }

}
