package Day_9.Task_1;

public class Task_1 {
    public static void main(String[] args) {
        Student s = new Student("Roman", "ak-47");
        Teacher t = new Teacher("Иван Иванович", "Математика");
        System.out.println("Группа студенда " + s.getGroupName());
        System.out.println("Название предмета " + t.getSubjectName());
        s.printInfo();
        t.printInfo();
    }
}

class Human {
    protected String name;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.println("Этот человек с именем " + name);
    }
}

class Student extends Human {
    private String groupName;

    public Student(String name, String groupName) {
        super(name);
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Этот студент с именем " + name);
    }
}

class Teacher extends Human {
    private String subjectName;

    public Teacher(String name, String subjectName) {
        super(name);
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Этот преподаватель с именем " + name);
    }
}