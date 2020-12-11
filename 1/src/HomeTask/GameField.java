package HomeTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Игровое поле для игрока
 */
public class GameField {
    private List<Ship> ships;
    private int aliveShipsCnt;
    private final int FIELD_SIZE = 10;
    private final int MAX_SHIPS_CNT = 10;
    private List<Coordinate> shotCoordinates;

    public GameField() {
        ships = new ArrayList<>();
        aliveShipsCnt = 0;
    }


    /**
     * Готово ли игровое поле (созданы все корабли определенного типа)
     * @return
     */
    public boolean isReady() {
        if (aliveShipsCnt == MAX_SHIPS_CNT) {
            return  true;
        }
        return false;
    }


    /**
     * Проиграло ли игровое поле (все корабли убиты)
     * @return - true - проиграло, false - нет
     */
    public boolean isLose() {
        if (aliveShipsCnt == 0) {
            return true;
        }
        return false;
    }

    /**
     * Выстрел по определенным координатам
     * @param coords - координаты
     * @return - true - попал, false - мимо
     */
    public boolean shootOnCoords(Coordinate coords) {
        for (Ship ship: this.ships) {
            if (ship.isCoordsOnShip(coords)) {
                ship.getHurt(coords);
                System.out.println("Попадание");

                if (!ship.isAlive()) {
                    this.aliveShipsCnt--;
                    System.out.println("Убил");
//                    if (this.aliveShipsCnt == 0) {
//                        System.out.println("Вы победили!");
//                    }
                }
                return true;
            }
        }

        System.out.println("Мимо");
        return false;
    }

    /** Добавление нового корабля на поле
     * @param newShip - новый корабль
     * @return - true - корабль успешно добавлен, false - нет
     */
    public boolean AddShip(Ship newShip) {

        // Проверяем общее кол-во кораблей
        if (aliveShipsCnt > MAX_SHIPS_CNT) {
            System.out.println("Уже добавлено максимальное количество кораблей");
            return false;
        }

        // Проверки возможно ли добавить корабль с переданными параметрами
        if (this.isPossibleToAddShip(newShip)) {
            ships.add(newShip);
            aliveShipsCnt++;
            return true;
        }
        return false;
    }

    /**
     * Создание корабля из параметров переданных в виде строки
     * @param inpParams - строка содержащая параметры корабля
     * @return - true - корабль успешно добавлен, false - нет
     * @throws Exception
     */
    public boolean AddShipFromString(String inpParams) throws Exception {
        String[] inpArr = inpParams.split(";");
        String coords = inpArr[0];
        int size = Integer.parseInt(inpArr[1]);
        boolean isHorizontal = Boolean.parseBoolean(inpArr[2]);
        String[] coordsArr = coords.split(",");
        Coordinate startCoords = new Coordinate(Integer.parseInt(coordsArr[0]), Integer.parseInt(coordsArr[1]));

        Ship ship = new Ship(size, startCoords, isHorizontal);
        return this.AddShip(ship);
    }

    /**
     * Проверяет возможно ли добавить корабль на поле (кол-во кораблей типа и пересечение с кораблями/ореолами)
     * @param newShip
     * @return - true - можно, false - нет
     */
    private boolean isPossibleToAddShip(Ship newShip) {

        if (!this.isShipInFieldBounds(newShip)) {
            System.out.println("Введены некорректные координаты корабля");
            return false;
        }

        // Можно ли добавить корабль такого типа
        if (!this.isPossibleToAddShipWithSize(newShip.getSize())) {
            System.out.println("Превышено допустимое количество кораблей данного размера");
            return false;
        }

        // Проверка пересечения с другими кораблями/ореолами
        if (this.isShipIntersectedWithOthers(newShip)) {
            System.out.println("Корабль пересекается с другим или находится в его ореоле");
            return false;
        }

        return true;
    }

    /**
     * Можно ли добавить корабль определенного размера на поле
     * @param newShipSize - размер корабля
     * @return - true - можно, false - нет
     */
    private boolean isPossibleToAddShipWithSize(int newShipSize) {

        // Считаем кол-во кораблей определенного размера на поле
        int shipsWithSameSizeCnt = 0;
        for (Ship ship: ships) {
            if (ship.getSize() == newShipSize) {
                shipsWithSameSizeCnt++;
            }
        }

        // Не превышено ли допустимое кол-во кораблей определенного размера
        if (5 - newShipSize <= shipsWithSameSizeCnt) {
            return false;
        }
        return true;
    }

    /** Находится ли корабль в пределах поля
     * @param newShip - корабль, для проверка
     * @return - true - в пределах поля, false - нет
     */
    private boolean isShipInFieldBounds(Ship newShip) {
        int newX = 0;
        int newY = 0;
        for (Block block: newShip.getBlocks()) {
            newX = block.getCoords().x;
            newY = block.getCoords().y;
            if (newX > FIELD_SIZE || newX < 0 || newY > FIELD_SIZE || newY < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Пересекатся ли корабль (находится в ореоле) с другими кораблями на поле
     * @param newShip - корабль для проверки
     * @return - true - пересекается, false - нет
     */
    private boolean isShipIntersectedWithOthers(Ship newShip) {
        for(Ship ship: ships) {
            if (!Ship.canShipsExistTogether(ship, newShip)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String[][] reprArr = new String[FIELD_SIZE][FIELD_SIZE];
        StringBuilder reprString = new StringBuilder();

        // Заполняю массив представлением пустых клеток
        for (int i = 0; i < FIELD_SIZE; i++) {
            Arrays.fill(reprArr[i], "□");
        }

        // Рисую корабли, раскрашиваю их клетки согласно их состоянию
        int x = 0;
        int y = 0;
        for(Ship ship: this.ships) {
            for(Block block: ship.getBlocks()) {
                x = block.getCoords().x;
                y = block.getCoords().y;
                if (block.getAlive()) {
                    reprArr[x][y] = "■";
                }
                else {
                    reprArr[x][y] = "☒";
                }
            }
        }

        // Преобразую массив в строку для вывода
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                reprString.append(reprArr[i][j]);
            }
            reprString.append("\n");
        }

        return reprString.toString();
    }
}
