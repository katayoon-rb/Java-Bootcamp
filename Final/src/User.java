import java.util.ArrayList;
import java.util.List;

public class User {
    private ArrayList<Person> users = new ArrayList<>();
    private ArrayList<Item> items = new ArrayList<>();


    public boolean checkUsername(String username) {
        boolean isDuplicated = false;
        for(Person p : users) {
            if (p.username.equals(username)) {
                isDuplicated = true;
                break;
            }
        }
        return isDuplicated;
    }


    public void addUser(Person p) { users.add(p); }
    public void removeUser(String username) {
        users.removeIf(p -> p.username.equals(username));
    }


    public boolean checkUser(String username, String password) {
        boolean doesExist = false;
        for (Person p : users) {
            if (p.username.equals(username) && p.password.equals(password)) {
                doesExist = true;
                break;
            }
        }
        return doesExist;
    }


    public String findType(String username) {
        String type = null;
        for (Person p : users) {
            if (p.username.equals(username)) {
                type = p.type;
            }
        }
        return type;
    }


    public long getBalance(String username) {
        long balance = 0;
        for (Person p : users) {
            if (p.username.equals(username)) {
                balance = p.money;
            }
        }
        return balance;
    }
    public long setBalance(String username, Long amount) {
        long balance = 0;
        for (Person p : users) {
            if (p.username.equals(username)) {
                p.money = p.money + amount;
                balance = p.money;
            }
        }
        return balance;
    }


    public boolean getVerified(String username) {
        boolean isVerified = false;
        for (Person p : users) {
            if (p.username.equals(username)) {
                if (p.verified == 1) {
                    isVerified = true;
                }
            }
        }
        return isVerified;
    }
    public void setVerified(String username) {
        for (Person p : users) {
            if (p.username.equals(username)) {
                p.verified = 1;
            }
        }
    }


    public List<Person> getUnverifiedUsers() {
        return users.stream().filter(p -> p.verified == 0).toList();
    }
    public void getUsers() {
        if (users.isEmpty()) {
            System.out.println("There are no users here!");
        }
        else {
            for (Person p : users) {
                System.out.println("- " + p.username);
            }
        }
    }


    public void addItem(Item i) { items.add(i); }
    public void removeItem(String name, char s, String owner) {
        items.removeIf( i -> i.name.equals(name) && i.owner.equals(owner) );
    }
    public void removeItem(String name) {
        items.removeIf( i -> i.name.equals(name) );
    }


    public long getItemId(String name) {
        long ItemId = 0;
        for (Item i : items) {
            if (i.name.equals(name)) {
                ItemId = i.id;
            }
        }
        return ItemId;
    }


    public int getOwnersItems(String owner) {
        int amount = 0;
        for (Item i : items) {
            if (i.owner.equals(owner)) {
                amount++;
                System.out.println("- " + i.name);
            }
        }
        return amount;
    }
    public void getItems(String with) {
        if (items.isEmpty()) {
            System.out.println("There are no items yet!");
        }
        if (with.equals("Id")) {
            for (Item i : items) {
                System.out.println("- " + i.name + " (" + i.id + ")");
            }
        }
        else if (with.equals("price")) {
            for (Item i : items) {
                System.out.println("- " + i.name + " ($" + i.price + ")");
            }
        }
        else if (with.equals("tag")) {
            ArrayList<String> tags = new ArrayList<String>();
            for (Item i : items) {
                if (!tags.contains(i.tag)) { tags.add(i.tag); }
            }
            for (String t : tags) {
                System.out.println("- " + t);
            }
        }
    }


    public void searchByTag(String tag) {
        for (Item i : items) {
            if (i.tag.equals(tag)) {
                System.out.println("- " + i.name + " ($" + i.price + ")");
            }
        }
    }
    public void buyItem(String username, String itemName) {
        long userBalance = 0;
        long itemPrice = 0;

        for (Person p : users) {
            if (p.username.equals(username)) {
                userBalance = p.money;
            }
        }
        for (Item i : items) {
            if (i.name.equals(itemName)) {
                itemPrice = i.price;
            }
        }

        long leftMoney = userBalance - itemPrice;
        if (leftMoney >= 0) {
            setBalance(username, -itemPrice);
            removeItem(itemName);
            System.out.println("You have successfully bought [" + itemName + "].");
        }
        else {
            System.out.println("Sorry, You don't have enough balance to buy this item.");
        }
    }
}
