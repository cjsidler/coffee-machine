package machine;

import java.util.Scanner;

public class CoffeeMachine {
    enum MachineSelection {
        buy, fill, take, remaining, exit
    }

    static int mlOfWater = 400;
    static int mlOfMilk = 540;
    static int gramsOfBeans = 120;
    static int disposableCups = 9;
    static int money = 550;

    public static void main(String[] args) {

        while (true) {
            MachineSelection selection = getUserSelection();
            switch (selection) {
                case buy -> {
                    buyCoffee();
                }
                case fill -> {
                    fillMachine();
                }
                case take -> {
                    takeMoney();
                }
                case remaining -> {
                    displayContents();
                }
                case exit -> {
                    return;
                }
            }
        }
    }

    private static void takeMoney() {
        System.out.printf("I gave you $%d%n", money);
        System.out.println();
        money = 0;
    }

    private static void fillMachine() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water you want to add:");
        mlOfWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        mlOfMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        gramsOfBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        disposableCups += scanner.nextInt();
        System.out.println();
    }

    private static void buyCoffee() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String buySelectionStr = scanner.nextLine();
        int buySelection;
        if (buySelectionStr.equals("back")) {
            buySelection = 4;
        } else {
            buySelection = Integer.parseInt(buySelectionStr);
        }

        switch (buySelection) {
            case 1 -> {
                if (mlOfWater >= 250 && gramsOfBeans >= 16 && disposableCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    mlOfWater -= 250;
                    gramsOfBeans -= 16;
                    disposableCups -= 1;
                    money += 4;
                } else {
                    if (mlOfWater < 250) {
                        System.out.println("Sorry, not enough water!");
                    } else if (gramsOfBeans < 16) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (disposableCups == 0) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                    System.out.println();
                    return;
                }
            }
            case 2 -> {
                if (mlOfWater >= 350 && mlOfMilk >= 75 && gramsOfBeans >= 20 && disposableCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    mlOfWater -= 350;
                    mlOfMilk -= 75;
                    gramsOfBeans -= 20;
                    disposableCups -= 1;
                    money += 7;
                } else {
                    if (mlOfWater < 350) {
                        System.out.println("Sorry, not enough water!");
                    } else if (mlOfMilk < 75) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (gramsOfBeans < 20) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (disposableCups == 0) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                    return;
                }
            }
            case 3 -> {


                if (mlOfWater >= 200 && mlOfMilk >= 100 && gramsOfBeans >= 12 && disposableCups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    mlOfWater -= 200;
                    mlOfMilk -= 100;
                    gramsOfBeans -= 12;
                    disposableCups -= 1;
                    money += 6;
                } else {
                    if (mlOfWater < 200) {
                        System.out.println("Sorry, not enough water!");
                    } else if (mlOfMilk < 100) {
                        System.out.println("Sorry, not enough milk!");
                    } else if (gramsOfBeans < 12) {
                        System.out.println("Sorry, not enough coffee beans!");
                    } else if (disposableCups == 0) {
                        System.out.println("Sorry, not enough disposable cups!");
                    }
                    return;
                }
            }
            case 4 -> {
                return;
            }
        }
        System.out.println();
    }

    private static MachineSelection getUserSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return MachineSelection.valueOf(scanner.nextLine());
    }

    private static void displayContents() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", mlOfWater);
        System.out.printf("%d ml of milk%n", mlOfMilk);
        System.out.printf("%d g of coffee beans%n", gramsOfBeans);
        System.out.printf("%d disposable cups%n", disposableCups);
        System.out.printf("$%d of money%n", money);
        System.out.println();
    }
}
