package HomeTask;

import java.util.Scanner;

public class Game {
    /** Для чтения из консоли */
    private Scanner scanner;

    /** Игровое поле первого игрока */
    private GameField gf1;

    /** Игровое поле второго игрока */
    private GameField gf2;

    /** Текущее игровое поле, на нем создаются корабли и по нему стреляет соперник */
    private GameField currentGf;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.gf1 = new GameField();
        this.gf2 = new GameField();
        this.currentGf = gf2;
    }


    /**
     * Начало игры, основной метод, где запускаются другие
     */
    public void start() {
        System.out.println("-----Начало игры-----");
        System.out.println("Размещайте свои корабли в формате нач.коодината;размер;горизонтальный - x1,y1;3;true");

        System.out.println("Первый игрок, начинайте создавать ваши корабли");
        createShips(gf1);
        System.out.println("Второй игрок, начинайте создавать ваши корабли");
        createShips(gf2);

        this.changeRandomPlayer();
        System.out.println("Да начнется бой!");
        startMatch();

        scanner.close();
    }

    /**
     * Непосредственно сам матч, где игроки обстреливают игровые поля друг друга
     */
    private void startMatch() {
        String inpStr = "";
        String [] inpArr = new String[2];
        Coordinate shotCoords;
        System.out.println(this.printCurrentPlayer() + " ваш выстрел");

        // Читаем координаты и стреляем по полю
        while(true) {
            if (scanner.hasNextLine()) {
                inpStr = scanner.nextLine();
                inpArr = inpStr.split(",");
                try {
                    shotCoords = new Coordinate(Integer.parseInt(inpArr[0]), Integer.parseInt(inpArr[1]));
                }
                catch (Exception e) {
                    System.out.println("Введены некоорктные данные, повторите ввод");
                    continue;
                }

                // Если промах, то меняется игрок (активное игровое поле по которому будет стрелять другой игрок)
                if (!this.currentGf.shootOnCoords(shotCoords)) {
                    this.swapCurrentGf();
                }

                // Печатаю игоровое поле, по которму идет выстрел (смысл игры теряется, но для отображение происходящего отлично подходит)
                System.out.println(this.currentGf);

                // Если игровое поле игрока считается проигравшим (все корабли потоплены), то значит что текущий игрок,
                // стрелявший по этому полю побеждает
                if(this.currentGf.isLose()) {
                    System.out.println(this.printCurrentPlayer() + " вы победили");
                    break;
                }

                System.out.println(this.printCurrentPlayer() + " ваш выстрел");
            }
        }
    }


    /**
     * Рандомный выбор того, кто будет ходить первым
     */
    private void changeRandomPlayer() {
        if (Math.random() > 0.5) {
            this.currentGf = gf2;
        }
        else {
            this.currentGf = gf1;
        }
    }


    /**
     * Смена текущего игрового поля
     */
    private void swapCurrentGf() {
        if (this.currentGf == gf2) {
            this.currentGf = gf1;
        }
        else {
            this.currentGf = gf2;
        }
    }

    /**
     * Вовзращает название текущего игрока
     * @return - строка название
     */
    private String printCurrentPlayer() {
        if (this.currentGf == gf2) {
            return "Первый игрок";
        }
        else {
            return "Второй игрок";
        }
    }


    /**
     * Создание кораблей для игрового поля
     * @param gf - игровое поле
     */
    private void createShips(GameField gf) {
        String inpStr = "";

        // Считываем и создаем корабли, пока поле не считается полностью корректно заполненым
        while (!gf.isReady()) {
            System.out.println("Создайте корабль: ");
            if (scanner.hasNextLine()) {
                inpStr = scanner.nextLine();
                try {
                    gf.AddShipFromString(inpStr);
                } catch (Exception e) {
                    System.out.println("Введены некоорктные данные, повторите ввод");
                }

                System.out.println(gf);
            }
        }

//
    }
}
