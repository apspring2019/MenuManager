package menus;

public class Menu
{
    private int id;
    private String title;
    private transient ParentMenu parent;

    public Menu(int id, String title)
    {
        this.id = id;
        this.title = title;
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public ParentMenu getParent()
    {
        return parent;
    }

    void setParent(ParentMenu parent)
    {
        this.parent = parent;
    }

    public static class Id
    {
        public static final int MAIN_MENU = 0;

        public static final int DRINKS = 1;
        public static final int JUICE = 11;
        public static final int COKE = 10;

        public static final int FOODS = 2;
        public static final int PIZZA = 20;
        public static final int SANDWICH = 21;

        public static final int EXIT = 3;
    }
}
