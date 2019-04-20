package views;

import java.util.Scanner;

import menus.Menu;
import menus.MenuManager;
import menus.ParentMenu;

public class RestaurantView
{
    private MenuManager menuManager;

    public void start()
    {
        initMenus();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine())
        {
            String input = scanner.nextLine();
            if (input.matches("\\d+"))
            {
                int index = Integer.parseInt(input) - 1;
                menuManager.performClickOnItem(index);
            }
            else if (input.equalsIgnoreCase("back"))
                menuManager.back();
        }
    }

    private void initMenus()
    {
        ParentMenu mainMenu = new ParentMenu(Menu.Id.MAIN_MENU, "Main Menu");
        ParentMenu drinks = new ParentMenu(Menu.Id.DRINKS, "Drinks");
        drinks.addSubItem(Menu.Id.COKE, "Coke");
        drinks.addSubItem(Menu.Id.JUICE, "Juice");
        ParentMenu foods = new ParentMenu(Menu.Id.FOODS, "Foods");
        foods.addSubItem(Menu.Id.PIZZA, "Pizza");
        foods.addSubItem(Menu.Id.SANDWICH, "Sandwich");
        mainMenu.addSubItem(drinks);
        mainMenu.addSubItem(foods);
        mainMenu.addSubItem(new Menu(Menu.Id.EXIT, "Exit"));

        menuManager = new MenuManager();
        menuManager.addOnMenuChangeListener(this::showMenu);    //Add listeners - (Method reference)
        menuManager.addOnClickListener(this::onItemClicked);
        menuManager.setCurrentMenu(mainMenu);
    }

    private void onItemClicked(int id)
    {
        //This method can be implemented in the presenter, controller, etc.
        //or you can call appropriate methods on them based on the clicked item
        System.out.printf("Item with id: %d was clicked.%n", id);
    }

    private void showMenu(ParentMenu menu)
    {
        System.out.println(menu.getTitle());
        System.out.println("--------");
        for (int i = 0; i < menu.getSubItems().size(); i++)
        {
            Menu item = menu.getSubItems().get(i);
            System.out.printf("%d. %s%n", i + 1, item.getTitle());
        }
    }
}
