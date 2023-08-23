package me.devik.systemManager;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class SystemManager {

    public void chooseRoom() {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the amount of people: ");
        int people = sc.nextInt(); // Save the number of people

        System.out.println("Enter the amount of night: ");
        int nights = sc.nextInt(); // Save the amount of nights

    }
}