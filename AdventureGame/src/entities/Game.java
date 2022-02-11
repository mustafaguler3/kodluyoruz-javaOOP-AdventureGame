package entities;

import abstracts.Impl.NormalLocImpl.SafeHouse;
import abstracts.Impl.NormalLocImpl.ToolStore;
import abstracts.Location;

import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.println("Welcome to our adventure game");
        System.out.println("Enter a name :");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println("Welcome "+ player.getName());
        player.selectCharacter();

        while (true){
            Location location = null;
            System.out.println("Areas");
            System.out.println("1 - Safe House");
            System.out.println("2 - Store");
            System.out.println("3 - Cave");
            System.out.println("4 - Forest");
            System.out.println("Please Choose a area that want to go ");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
            }


            if(!location.onLocation()){
                System.out.println("GAME OVER!");
                break;
            }
        }


    }
}
