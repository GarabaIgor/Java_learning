package HomeTask;

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

    /**
     * @param size - размер корабля
     * @param startCoords - начальные координаты
     * @param isHorizontal - тип расположения корабля
     */
    public Ship(int size, Coordinate startCoords, Boolean isHorizontal) {
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
            if (this.isHorizontal) {
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
                block.kill();
                break;
            }
        }

        // Если "живых" блоков не остается, то корабль считается убитым
        if (!this.CheckLiveBlocks()) {

            //TODO НАМУТИТЬ OBSERVER ДЛЯ ПОЛЯ
            this.isAlive = false;
        }
    }

    /**
     * Проверка есть ли еще "живые" блоки
     * @return - true - есть, false - нет
     */
    private Boolean CheckLiveBlocks() {
        for (Block block: this.blocks) {

            // Проверяем "жив" ли хоть один блок
            if (block.getAlive() == true) {
                return true;
            }
        }

        return false;
    }

    public int getSize() {
        return size;
    }
}

/**
 * Класс базового блока из которого состоят корабли
 */
class Block {
    /** Координаты блока */
    private Coordinate coords;

    /** "Живой" блок или уже "убитый" */
    private Boolean isAlive;

    public Block(Coordinate coords) {
        this.coords = coords;
        this.isAlive = true;
    }

    /**
     * Проверка находится ли блок на заданых координатах
     * @param coords - координаты, положение на которых проверяется
     * @return - true - находится, false - нет
     */
    public Boolean isBlockOnCoords(Coordinate coords) {
        if (this.coords.x == coords.x && this.coords.y == coords.y) {
            return true;
        }
        else {
            return false;
        }
    }

    /** "Убиваем" блок, означает что в блок попали */
    public void kill() {
        isAlive = false;
    }

    public Coordinate getCoords() {
        return coords;
    }

    public Boolean getAlive() {
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
}