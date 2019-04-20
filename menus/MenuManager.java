package menus;

import java.util.ArrayList;
import java.util.List;

public class MenuManager
{
    private ParentMenu currentMenu;
    private List<OnMenuItemClickListener> clickListeners = new ArrayList<>();
    private List<OnMenuChangeListener> menuChangeListeners = new ArrayList<>();

    public ParentMenu getCurrentMenu()
    {
        return currentMenu;
    }

    public void setCurrentMenu(ParentMenu currentMenu)
    {
        this.currentMenu = currentMenu;
        callOnMenuChangeListeners();
    }

    public void addOnClickListener(OnMenuItemClickListener listener)
    {
        clickListeners.add(listener);
    }

    private void callOnClickListeners(int menuId)
    {
        clickListeners.forEach(listener -> listener.onMenuItemClicked(menuId));
    }

    public void addOnMenuChangeListener(OnMenuChangeListener listener)
    {
        menuChangeListeners.add(listener);
    }

    private void callOnMenuChangeListeners()
    {
        menuChangeListeners.forEach(listener -> listener.onMenuChanged(currentMenu));
    }

    public void performClickOnItem(int index)
    {
        if (index >= currentMenu.getSubItems().size())
            return;

        Menu clickedItem = currentMenu.getSubItems().get(index);
        if (clickedItem instanceof ParentMenu)
            setCurrentMenu((ParentMenu)clickedItem);
        else
            callOnClickListeners(clickedItem.getId());
    }

    public void back()
    {
        setCurrentMenu(this.currentMenu.getParent());
    }
}
