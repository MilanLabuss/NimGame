//This program will play Nim game
//Author: Milan Labus
//Assignment 3
//Date 16/10/2021
//COMP7035_26533

import java.util.Random;
import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        int low = 10;                   //range for the number of matchsticks
        int high = 100;
        int highfirst = 3;              //range for who goes first
        int lowfirst = 1;
        int matchstickNum = random.nextInt(high - low) + low;     //the total number of match sticks
        int playerChoice;                //the players choice of stick
        int whoGoesFirst = random.nextInt(highfirst - lowfirst) + lowfirst;


        while (matchstickNum > 0) {             //code will run until the num of matchsticks reaches zero
            if (whoGoesFirst==1) {              //player goes first

                do {
                    System.out.println("Nunmber of MatchSticks: " + matchstickNum + "  \nSelect between one and half: ");
                    playerChoice = scan.nextInt();
                }
                while (playerChoice > matchstickNum/2 && playerChoice!=1 && playerChoice!=2);          //making sure the player chose less than half the match sticks

                  matchstickNum -= playerChoice;
                if (matchstickNum <= 0) {               //if there are no sticks left after the players choice computer wins
                    System.out.println("Computer Wins");
                } else {
                    int computerchoice = 0;

                    // System.out.println("THe random number will be between: " + (matchstickNum / 2) + "And one");
                    if (matchstickNum == 1) {          //if there is one match stick left the comp loses
                        System.out.println("Player Wins");
                        matchstickNum = 0;

                    }
                    if (matchstickNum == 2) {          //if there are two left the comp will take only one
                        computerchoice = 1;
                        matchstickNum -= computerchoice;
                        System.out.println("Computer took: " + computerchoice);

                    }
                    if (matchstickNum == 3) {          //if there are three matchsticks left then the comp will take 2
                        computerchoice = 2;
                        matchstickNum -= computerchoice;
                        System.out.println("Computer took: " + computerchoice);
                    }
                    if (matchstickNum > 3) {          //if there are more than three the comp will choose a random number
                        computerchoice = random.nextInt((matchstickNum / 2) - 1) + 1;

                        System.out.println("Computer took: " + computerchoice);
                        matchstickNum -= computerchoice;
                    }

                }

            } else {      //code is run if the program decides that the computer runs first

                int computerchoice = 0;


                if (matchstickNum == 1) {          //if there is one match stick left the comp loses
                    System.out.println("Player Wins");
                    matchstickNum = 0;

                }
                if (matchstickNum == 2) {          //if there are two left the comp will take only one
                    computerchoice = 1;
                    matchstickNum -= computerchoice;

                }
                if (matchstickNum == 3) {          //if there are three matchsticks left then the comp will take 2
                    computerchoice = 2;
                    matchstickNum -= computerchoice;
                }
                if (matchstickNum > 3) {          //if there are more than three the comp will choose a random number
                    computerchoice = random.nextInt((matchstickNum / 2) - 1) + 1;

                    System.out.println("Computer took: " + computerchoice);
                    matchstickNum -= computerchoice;
                }

                do {
                    System.out.println("Nunmber of MatchSticks: " + matchstickNum + "  \nSelect between one and half: ");
                    playerChoice = scan.nextInt();
                }
                while (playerChoice > matchstickNum/2 && playerChoice!=1);


                matchstickNum -= playerChoice;
                if (matchstickNum <= 0) System.out.println("Computer Wins");


            }


        }
    }
}
