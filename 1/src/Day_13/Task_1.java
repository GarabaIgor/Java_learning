package Day_13;

public class Task_1 {
    public static void main(String[] args) {
        User u1 = new User("Petya");
        User u2 = new User("Vasya");
        User u3 = new User("Oleg");

        u1.sendMessage(u2, "Привет, Вася");
        u2.sendMessage(u1, "Привет, Петя");
        u3.sendMessage(u1, "Привет, Петя");
        u1.sendMessage(u3, "Привет, Олег");
        u3.sendMessage(u1, "Как дела, Петя?");

        MessageDatabase.showDialog(u1, u3);

        System.out.println(MessageDatabase.getMessages().get(0));
    }
}
