package HomeTask;

import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс представляющий собой корабль
 */
public class Ship {
    /** Размер корабля, характеризуется кол-вом блоков */
    private int size;

    /** Живой ли корабль */
    private boolean isAlive;

    /** Тип расположения корабля - горизонтальный или вертикальный */
    private boolean isHorizontal;

    /** Начальные координаты корабля */
    private Coordinate startCoords;

    /** Массив блоков, из которых собственно и состоит корабль */
    private Block[] blocks;

    /** Массив координат ореола корабля */
    private List<Coordinate> haloCoords;

    /**
     * @param size - размер корабля
     * @param startCoords - начальные координаты
     * @param isHorizontal - тип расположения корабля
     */
    public Ship(int size, Coordinate startCoords, boolean isHorizontal) {

        // Если передан размер слишком маленький или большой, то устанавливаем граничные значения размера
        if (size < 1) {
            this.size = 1;
        }
        else if (size > 4) {
            this.size = 4;
        }
        else {
            this.size = size;
        }

        this.startCoords = startCoords;
        this.isHorizontal = isHorizontal;
        this.isAlive = true;
        this.blocks = new Block[this.size];
        this.fillBlocks();
        this.haloCoords = new ArrayList<>();
        this.addHaloToShip();
    }

    /**
     * Наполнение массива базовых блоков согласно характеристикам корабля (начальные координаты, размер, тип расположения)
     */
    private void fillBlocks() {

        // Первый блок создается на основе стартовых координат корабля
        this.blocks[0] = new Block(this.startCoords);

        // Остальные блоки создаются согласно характеристикам корабля
        int newX = 0;
        int newY = 0;
        for (int i = 1; i < this.blocks.length; i++) {

            // Добавление блоков по горизонтали
            if (!this.isHorizontal) {
                newX = this.startCoords.x + i;
                newY = this.startCoords.y;
            }

            // Добавление блоков по вертикали
            else {
                newX = this.startCoords.x;
                newY = this.startCoords.y + i;
            }

            this.blocks[i] = new Block(new Coordinate(newX, newY));
        }
    }

    /**
     * Нанесение урона кораблю, если все блоки корабля повреждены, то он перестает быть "живым"
     * @param coords - координаты, по которым наносится урон (выстрел)
     */
    public void getHurt(Coordinate coords) {

        // Ищем блок по координатам выстрела и если такой находится, то "убиваем" его
        for (Block block: this.blocks) {
            if (block.isBlockOnCoords(coords)) {
                block.Kill();
                break;
            }
        }

        // Если "живых" блоков не остается, то корабль считается убитым
        if (!this.checkLiveBlocks()) {
            this.isAlive = false;
        }
    }

    /**
     * Проверка есть ли еще "живые" блоки
     * @return - true - есть, false - нет
     */
    private boolean checkLiveBlocks() {
        for (Block block: this.blocks) {

            // Проверяем "жив" ли хоть один блок
            if (block.getAlive() == true) {
                return true;
            }
        }

        return false;
    }

    /**
     * Принадлежат ли координаты кораблю
     * @param coords - координаты для проверки
     * @return - true - принадлежат, false - нет
     */
    public boolean isCoordsOnShip(Coordinate coords) {
        for (Block shipBlock: this.blocks) {
            if (shipBlock.getCoords().equals(coords)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Принадлежит ли блок кораблю
     * @param block - координаты для проверки
     * @return - true - принадлежат, false - нет
     */
    public boolean isBlockOnShip(Block block) {
        return this.isCoordsOnShip(block.getCoords());
    }

    /**
     * Принадлежат ли координаты ореолу корабля
     * @param coords - координаты для проверки
     * @return - true - принадлежат, false - нет
     */
    public boolean isCoordsOnShipHalo(Coordinate coords) {
        for (Coordinate haloCoords: this.haloCoords) {
            if (haloCoords.equals(coords)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Принадлежит ли блок ореолу корабля
     * @param block - координаты для проверки
     * @return - true - принадлежат, false - нет
     */
    public boolean isBlockOnShipHalo(Block block) {
        return this.isCoordsOnShipHalo(block.getCoords());
    }

    /** Добавление ореола кораблю */
    private void addHaloToShip() {
        for (Block shipBlock: this.blocks) {
            this.addHaloToBlock(shipBlock);
        }
    }

    /**
     * Добавление ореола блоку
     * @param block - блок, которому добавляется ореол
     */
    private void addHaloToBlock(Block block) {

        // Оригинальные координаты
        int originalX = block.getCoords().x;
        int originalY = block.getCoords().y;

        // Координаты вокруг блока
        Coordinate topLeft = new Coordinate(originalX - 1, originalY + 1);
        Coordinate top = new Coordinate(originalX, originalY + 1);
        Coordinate topRight = new Coordinate(originalX + 1, originalY + 1);
        Coordinate right = new Coordinate(originalX + 1, originalY);
        Coordinate bottomRight = new Coordinate(originalX + 1, originalY - 1);
        Coordinate bottom = new Coordinate(originalX, originalY - 1);
        Coordinate bottomLeft = new Coordinate(originalX - 1, originalY - 1);
        Coordinate left = new Coordinate(originalX - 1, originalY);

        Coordinate[] blockHaloCoords = {topLeft, top, topRight, right, bottomRight, bottom, bottomLeft, left};

        // Добавление ореола, ореол не добавляется если попадает на сам корабль
        for (Coordinate coords: blockHaloCoords) {
            if (!this.isCoordsOnShip(coords)) {
                this.haloCoords.add(coords);
            }
        }
    }


    /**
     * Могут ли два корабля существовать вместе (не пересекаются и не лежат на ореолах друг друга)
     * @param ship1 - первый корабль для проверки
     * @param ship2 - второй корабль для проверки
     * @return - true - могут, false - нет
     */
    public static boolean canShipsExistTogether(Ship ship1, Ship ship2) {
        for (Block secondShipBlock: ship2.blocks) {
            if (ship1.isBlockOnShip(secondShipBlock) || ship1.isBlockOnShipHalo(secondShipBlock)) {
                return false;
            }
        }
        return  true;
    }

    public int getSize() {
        return size;
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public boolean isAlive() {
        return isAlive;
    }
}

/**
 * Класс базового блока из которого состоят корабли
 */
class Block {
    /** Координаты блока */
    private Coordinate coords;

    /** "Живой" блок или уже "убитый" */
    private boolean isAlive;

    public Block(Coordinate coords) {
        this.coords = coords;
        this.isAlive = true;
    }

    /**
     * Проверка находится ли блок на заданых координатах
     * @param coords - координаты, положение на которых проверяется
     * @return - true - находится, false - нет
     */
    public boolean isBlockOnCoords(Coordinate coords) {
        if (this.coords.equals(coords)) {
            return true;
        }
        else {
            return false;
        }
    }

    /** "Убиваем" блок, означает что в блок попали */
    public void Kill() {
        isAlive = false;
    }

//    @Override
//    public String toString() {
//        if (this.isAlive) {
//            return "■";
//        }
//        return "x";
//    }

    public Coordinate getCoords() {
        return coords;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setCoords(Coordinate coords) {
        this.coords = coords;
    }
}

/**
 * Класс для хранения координат
 */
class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Coordinate)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Coordinate coords = (Coordinate) o;

        // Compare the data members and return accordingly
        return this.x == coords.x && this.y == coords.y;
    }
}