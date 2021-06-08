package tracy.androidprojects.project2;

public class Category {
    private String name;
    private int value;

    public Category(String name) {
        this.name = name;
        this.value = 0;
    }

    public String getName() {
        return name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
