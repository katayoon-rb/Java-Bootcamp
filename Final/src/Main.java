import java.security.SecureRandom;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        User user = new User();
        int input;
        int money = 0;
        int verified = 0;

        // admin
        user.addUser(new Person("admin", "admin", "admin", 0, 0));

        System.out.println("Hello, welcome to our online shop");

        boolean programRunning = true;
        while(programRunning) {
            // main menu
            System.out.println("here's a list of available commands:");
            System.out.println("1. Sign up");
            System.out.println("2. Log in");
            System.out.println("3. Close");

            input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Seller or costumer?(s or c)");
                    System.out.println("1. Back");
                    String type = scanner.next();

                    if (type.equals("1")) { break; }
                    else {
                        System.out.println("1. Back");
                        System.out.println("username: ");
                        String username = scanner.next();
                        if (username.equals("1")) { break; }

                        // checking username
                        if ( user.checkUsername(username) ) {
                            System.out.println("Sorry, this username has already been chosen!");
                            System.out.println("1. Back");
                            int back = scanner.nextInt();
                            if (back == 1) { break; }
                        }
                        else {
                            System.out.println("1. Back");
                            System.out.println("Password: ");
                            String password = scanner.next();
                            if (password.equals("1")) { break; }

                            user.addUser(new Person(username, password, type, money, verified));

                            System.out.println("Done!");
                            System.out.println("1. Back");
                            int back = scanner.nextInt();
                            if (back == 1) { break; }
                        }
                    }


                // log in
                case 2:
                    System.out.println("1. Back");
                    System.out.println("username: ");
                    String username = scanner.next();
                    System.out.println("password: ");
                    String password = scanner.next();
                    if (username.equals("1") || password.equals("1")) { break; }

                    // check user
                    if (!user.checkUser(username, password)) {
                        System.out.println("sorry, The username or password is wrong!");
                        System.out.println("1. Back");
                        int back = scanner.nextInt();
                        if (back == 1) { break; }
                    }
                    else {
                        // costumer
                        if (user.findType(username).equals("c")) {
                            boolean loggedIn = true;
                            while(loggedIn) {
                                // costumer menu
                                System.out.println("here's a list of available commands:");
                                System.out.println("1. Account Info");
                                System.out.println("2. Add Balance");
                                System.out.println("3. List of Items");
                                System.out.println("4. Search by tag");
                                System.out.println("5. Logout");

                                int command = scanner.nextInt();
                                switch (command) {
                                    // Account Info
                                    case 1:
                                        System.out.println("Your account info is:");
                                        System.out.println("Username: " + username);
                                        System.out.println("Password: " + password);
                                        System.out.println("Balance: $" + user.getBalance(username));

                                        System.out.println("1. Back");
                                        int back = scanner.nextInt();
                                        if (back == 1) { break; }

                                    // Add Balance
                                    case 2:
                                        System.out.println("How much do you want to add to your balance:");
                                        long amount = scanner.nextInt();
                                        System.out.println("Your Balance: " + user.setBalance(username, amount));

                                        System.out.println("1. Back");
                                        back = scanner.nextInt();
                                        if (back == 1) { break; }

                                    // List of Items
                                    case 3:
                                        System.out.println("Your balance is: $" + user.getBalance(username));
                                        user.getItems("price");
                                        System.out.println("1. Back");
                                        System.out.println("Enter the name of what you wanna buy:");

                                        String chosenItem = scanner.next();
                                        if (chosenItem.equals("1")) { break; }
                                        user.buyItem(username, chosenItem);

                                        System.out.println("1. Back");
                                        back = scanner.nextInt();
                                        if (back == 1) { break; }

                                    // Search by tag
                                    case 4:
                                        System.out.println("1. Back");
                                        user.getItems("tag");
                                        System.out.println("Enter your desired tag:");
                                        String tag = scanner.next();
                                        if (tag.equals("1")) { break; }

                                        user.searchByTag(tag);
                                        System.out.println("1. Back");
                                        System.out.println("Enter the name of what you wanna buy:");

                                        chosenItem = scanner.next();
                                        if (chosenItem.equals("1")) { break; }
                                        user.buyItem(username, chosenItem);

                                        System.out.println("1. Back");
                                        back = scanner.nextInt();
                                        if (back == 1) { break; }

                                    // Logout
                                    case 5:
                                        loggedIn = false;
                                        break;
                                }
                            }
                        }

                        // seller (DONE)
                        else if (user.findType(username).equals("s")) {
                            boolean loggedIn = true;
                            while(loggedIn) {
                                // seller menu
                                System.out.println("here's a list of available commands:");
                                System.out.println("1. Account Info");
                                System.out.println("2. Add Item");
                                System.out.println("3. Remove Item");
                                System.out.println("4. Logout");

                                int command = scanner.nextInt();
                                switch (command) {
                                    // Account Info
                                    case 1:
                                        System.out.println("Your account info is:");
                                        System.out.println("Username: " + username);
                                        System.out.println("Password: " + password);
                                        System.out.println("Verified: " + user.getVerified(username));

                                        System.out.println("1. Back");
                                        int back = scanner.nextInt();
                                        if (back == 1) { break; }

                                    // Add Item
                                    case 2:
                                        System.out.println("1. Back");
                                        System.out.println("name: ");
                                        String name = scanner.next();
                                        System.out.println("tag: ");
                                        String tag = scanner.next();
                                        System.out.println("price: ");
                                        long price = scanner.nextLong();
                                        if (name.equals("1") || tag.equals("1") || price == 1) { break; }

                                        SecureRandom random = new SecureRandom();
                                        int id = random.nextInt();
                                        user.addItem( new Item(name, tag, price, id, username) );
                                        System.out.println("Item with id [" + id + "] was added successfully.");
                                        System.out.println("1. Back");
                                        back = scanner.nextInt();
                                        if (back == 1) { break; }

                                    // Remove Item
                                    case 3:
                                        int itemsAmount = user.getOwnersItems(username);
                                        if (itemsAmount == 0) {
                                            System.out.println("You don't have any items yet!");
                                        }
                                        else {
                                            System.out.println("1. Back");
                                            System.out.println("Type the name to remove:");

                                            String nameToRemove = scanner.next();
                                            user.removeItem(nameToRemove, 's', username);

                                            if (nameToRemove.equals("1")) { break; }
                                            System.out.println("Item was removed successfully.");
                                        }
                                        System.out.println("1. Back");
                                        back = scanner.nextInt();
                                        if (back == 1) { break; }

                                    // Logout
                                    case 4:
                                        loggedIn = false;
                                        break;
                                }
                            }
                        }

                        // admin (DONE)
                        else {
                            if (username.equals("admin") && password.equals("admin")) {
                                boolean loggedIn = true;
                                while (loggedIn) {
                                    // admin menu
                                    System.out.println("here's a list of available commands:");
                                    System.out.println("1. List of Unverified Users");
                                    System.out.println("2. List of All Users");
                                    System.out.println("3. Remove User");
                                    System.out.println("4. Remove Item");
                                    System.out.println("5. Logout");

                                    int command = scanner.nextInt();
                                    switch (command) {
                                        // List of Unverified Users
                                        case 1:
                                            List<Person> unverifiedUsers = user.getUnverifiedUsers();
                                            if (unverifiedUsers.isEmpty()) {
                                                System.out.println("All of the users are verified.");
                                            }
                                            else {
                                                for (Person p : unverifiedUsers) {
                                                    System.out.println("- " + p.username);
                                                }

                                                System.out.println("1. Back");
                                                System.out.println("Type the username to approve:");
                                                String name = scanner.next();
                                                if (name.equals("1")) { break; }
                                                else {
                                                    user.setVerified(name);
                                                    System.out.println("User with username [" + name + "] is verified now.");
                                                }
                                            }
                                            System.out.println("1. Back");
                                            int back = scanner.nextInt();
                                            if (back == 1) { break; }

                                        // List of All Users
                                        case 2:
                                            user.getUsers();
                                            System.out.println("1. Back");
                                            back = scanner.nextInt();
                                            if (back == 1) { break; }

                                        // Remove User
                                        case 3:
                                            user.getUsers();
                                            System.out.println("1. Back");
                                            System.out.println("Type the username to remove:");
                                            String name = scanner.next();
                                            user.removeUser(name);

                                            System.out.println("User with username [" + name + "] was removed successfully.");
                                            System.out.println("1. Back");
                                            back = scanner.nextInt();
                                            if (back == 1) { break; }

                                        // Remove Item
                                        case 4:
                                            user.getItems("Id");
                                            System.out.println("1. Back");
                                            System.out.println("Type the name to remove:");
                                            String nameToRemove = scanner.next();

                                            if (nameToRemove.equals("1")) { break; }
                                            user.removeItem(nameToRemove);
                                            long id = user.getItemId(nameToRemove);

                                            System.out.println("Item username [" + id + "] was removed successfully.");
                                            System.out.println("1. Back");
                                            back = scanner.nextInt();
                                            if (back == 1) { break; }

                                        // Logout
                                        case 5:
                                            loggedIn = false;
                                            break;
                                    }
                                }
                            }
                        }
                    }

                // close
                case 3:
                    programRunning = false;
                    System.out.println("Goodbye!");
                    break;
            }
        }
    }
}