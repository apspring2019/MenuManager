package menus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParentMenu extends Menu
{
    private List<Menu> subItems = new ArrayList<>();

    public ParentMenu(int id, String title)
    {
        super(id, title);
    }

    public void addSubItem(Menu menu)
    {
        subItems.add(menu);
        menu.setParent(this);
    }

    public void addSubItem(int id, String title)
    {
        addSubItem(new Menu(id, title));
    }

    public List<Menu> getSubItems()
    {
        return Collections.unmodifiableList(subItems);
    }

}
