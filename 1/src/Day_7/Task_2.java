package Day_7;

public class Task_2 {
    public static void main(String[] args) {
//        Создаем две команды
        Player[] dreamTeams = new Player[Player.MAX_PLAYERS_CNT];
        for (int i = 0; i < dreamTeams.length; i++) {
            dreamTeams[i] = new Player();
            Player.info();
        }
        System.out.println("Количество игроков на поле: " + Player.countPlayers);

//        Пытаемся вывести на поле лишних игроков
        Player extraPlayer1 = new Player();
        Player extraPlayer2 = new Player();
        System.out.println("Количество игроков на поле: " + Player.countPlayers);

//        Вынуждаем игрока покинуть поле
        Player luckyPlayer = dreamTeams[0];
        int luckyPlayerPrevStamina = luckyPlayer.getStamina();
        System.out.println("Выносливость игрока: " + luckyPlayerPrevStamina);
        for (int i = 0; i < luckyPlayerPrevStamina; i++) {
            luckyPlayer.run();
        }
    }
}

class Player {
    public static final int MAX_STAMINA = 100;
    public static final int MIN_STAMINA = 0;
    public static final int MAX_PLAYERS_CNT = 6;
    public static int countPlayers = 0;
    private int stamina;

    public Player() {
        this.stamina = (int) (Math.random() * (10 + 1)) + 90;
        if (countPlayers < 6) {
            countPlayers++;
        }
    }

    public int getStamina() {
        return stamina;
    }

    public void run() {
        if (stamina > 0) {
            stamina--;
            if (stamina == 0) {
                countPlayers--;
                System.out.println("Игрок устал и покидает поле");
            }
        } else {
            System.out.println("Игрок уже покинул поле!");
        }
    }

    public static void info() {
        if (countPlayers < MAX_PLAYERS_CNT) {
            int remainingPlayersCnt = MAX_PLAYERS_CNT - countPlayers;
            System.out.printf("Команды неполные. На поле еще есть %d %s\n", remainingPlayersCnt, getSpaceInfoTextPart(remainingPlayersCnt));
        } else {
            System.out.println("На поле нет свободных мест");
        }
    }

    private static String getSpaceInfoTextPart(int playersCnt) {
        String result;
        switch (playersCnt) {
            case 1:
                result = "свободное место";
                break;
            case 2:
            case 3:
            case 4:
                result = "свободных места";
                break;
//            0-5-6
            default:
                result = "свободных мест";
                break;
        }

        return result;
    }
}