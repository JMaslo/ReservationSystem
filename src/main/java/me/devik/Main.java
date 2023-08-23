package me.devik;

import me.devik.systemManager.SystemManager;

import java.util.Scanner;

public class Main {
    public static SystemManager manager = new SystemManager();
    public static void main(String[] args) {



        System.out.println("-----------------------");
        System.out.println("Welcome in our Reservation System");
        System.out.println("We would be happy if you will continue :)");
        System.out.println("-----------------------");

        manager.chooseRoom();
    }



}