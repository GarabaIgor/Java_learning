package Day_6;

public class Task_3 {
    public static void main(String[] args) {
        Teacher mathTeacher = new Teacher("Мария Ивановна", "Математика");
        Student petya = new Student("Петя");
        mathTeacher.evaluate(petya);

        Teacher geoTeacher = new Teacher("Екатерина Петровна", "География");
        Student vasya = new Student("Вася");
        geoTeacher.evaluate(vasya);
    }
}

class Teacher {
    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void evaluate(Student student) {
        int minScore = 2;
        int maxScore = 5;
        int score = (int) (Math.random() * (maxScore - minScore + 1)) + minScore;
        String scoreStringRepr;
        switch (score){
            case 2:
                scoreStringRepr = "неудовлетворительно";
                break;
            case 3:
                scoreStringRepr = "удовлетворительно";
                break;
            case 4:
                scoreStringRepr = "хорошо";
                break;
            case 5:
                scoreStringRepr = "отлично";
                break;
            default:
                scoreStringRepr = "без оценки";
                break;

        }
        System.out.printf("Преподаватель %s оценил студента с имененм %s по предмету %s на оценку %s\n", name, student.getName(), subject, scoreStringRepr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String name) {
        this.name = name;
    }
}