import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        System.out.println("Do you want to play normal or expert mode?");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        //game will end when the # of turns matches the # of spaced on the board
        int turns = 1;
        //checks in the code using the checkFor$ or 5 functions if someone has won
        boolean winner = false;
        //boolean statement to check if the player was able to drop a character
        boolean check;
        //loop ends when someone wins
        boolean displayCheck = false;
        while (winner == false){
            //one loop for normal mode and one loop for expert mode with separate but similiar functions
            if (input.equals("normal")) {
                Board game = new Board(6, 7);
                System.out.println("Do you want to have debug mode?");
                //string checker for debug mode
                Scanner x = new Scanner(System.in);
                String d = x.nextLine();
                if(input.equals("yes")) {
                    System.out.println("debug mode on");
                    displayCheck = true;
                    game.debug(7);
                }
                System.out.print("player 1: 'X', player 2: 'O'");
                while(true){
                    System.out.println("Turn " + turns);
                    System.out.println("Player 1's turn. Select a column to place an X");
                    int colNum = s.nextInt();
                    check = game.dropNormal(colNum, 'X');
                    //loops until the player is able to drop a character
                    //drop function returns false if there is a full column or if its an invalid input
                    while(check != true){
                        System.out.println("You must enter a valid column");
                        colNum = s.nextInt();
                        check = game.dropNormal(colNum, 'X');
                    }
                    //checks if player1 has won
                    if(game.connectsFour('X') == true) {
                        System.out.println("Player 1 has won this match!");
                        game.debug(7);
                        winner = true;
                        break;
                    }
                    System.out.println("Player 2's turn");
                    //gets random number
                    Random r = new Random();
                    colNum = r.nextInt(7);
                    check = game.dropNormal(colNum, 'O');
                    //loop continues until a random number is able to be placed
                    while(check != true){
                        colNum = r.nextInt(7);
                        check = game.dropNormal(colNum, 'O');
                    }
                    if(game.connectsFour('O') == true){
                        System.out.println("Player 2 has won this match!");
                        game.debug(7);
                        winner = true;
                        break;
                    }
                    //number of turns is added while checking if its less than the board size
                    turns ++;
                    //checks if code in on debug then either prints or asks the user to print or quit
                    if(displayCheck){
                        game.debug(7);
                    } else if(!displayCheck){
                        System.out.println("Do you want to print or quit before the game continues? Type print or quit");
                        d = x.nextLine();
                        if (d.equals("print")) {
                            game.debug(7);
                        } else if (d.equals("quit")) {
                            winner = true;
                            break;
                        }
                    }
                    if(turns >= 42){
                        winner = true;
                        break;
                    }
                }
            } else if (input.equals("expert")){
                //the structure for expert mode is essentially the same as the code above but with a different sized board
                Board game = new Board(6, 9);
                System.out.println("Do you want to have debug mode?");
                //string checker for debug mode
                Scanner x = new Scanner(System.in);
                String d = x.nextLine();
                if(input.equals("yes")) {
                    System.out.println("debug mode on");
                    displayCheck = true;
                    game.debug(7);
                }
                System.out.print("player 1: 'X', player 2: 'O'");
                while(true){
                    System.out.println("Turn " + turns);
                    System.out.println("Player 1's turn. Select a column to place an X");
                    int colNum = s.nextInt();
                    check = game.dropExpert(colNum, 'X');
                    while(check == false){
                        System.out.println("You must enter a valid column");
                        colNum = s.nextInt();
                        check = game.dropExpert(colNum, 'X');
                    }
                    if(game.connectsFive('X') == true) {
                        System.out.println("Player 1 has won this match!");
                        game.debug(9);
                        winner = true;
                        break;
                    }
                    System.out.println("Player 2's turn");
                    Random r = new Random();
                    colNum = r.nextInt(7);
                    check = game.dropExpert(colNum, 'O');
                    while(check != true){
                        colNum = r.nextInt(7);
                        check = game.dropExpert(colNum, 'O');
                    }
                    if(game.connectsFive('O') == true){
                        System.out.println("Player 2 has won this match!");
                        game.debug(9);
                        winner = true;
                        break;
                    }
                    turns ++;
                    if(displayCheck){
                        game.debug(7);
                    } else if(!displayCheck){
                        System.out.println("Do you want to print or quit before the game continues? Type print or quit");
                        d = x.nextLine();
                        if (d.equals("print")) {
                            game.debug(7);
                        } else if (d.equals("quit")) {
                            winner = true;
                            break;
                        }
                    }
                    if(turns >= 42){
                        winner = true;
                        break;
                    }
                }

            } else {
                //loop continues if the input is not either 'expert' or 'normal'
                System.out.println("You need to answer the question, normal or expert?");
                input = s.nextLine();
            }
        }
    }
}
