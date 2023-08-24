package me.devik.systemManager;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

public class SystemManager {

    public void chooseRoom() {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter the amount of people: ");
        int people = sc.nextInt(); // Save the number of people

        System.out.println("Enter the amount of night: ");
        int nights = sc.nextInt(); // Save the amount of nights

        System.out.println("Do you want to include breakfast? true/false");
        String breakfast = sc.next();
        boolean breakfast_bool = Boolean.parseBoolean(breakfast);

        System.out.println("Do you want to include lunch and dinner? true/false");
        String lunch_dinner = sc.next();
        boolean lunch_dinner_bool = Boolean.parseBoolean(lunch_dinner);



    }

    public void checkAvailability() {
        try {
            InputStream inputStream = new FileInputStream(new File("configuration/data.yaml")); // TODO: Fix this path bug
            Yaml yaml = new Yaml();
            Map<String, Object> yamlData = yaml.load(inputStream);

            for (Map.Entry<String, Object> entry : yamlData.entrySet()) {
                String roomName = entry.getKey();
                Map<String, Object> roomDetail = (Map<String, Object>) entry.getValue();

                int peopleAmount = (int) roomDetail.get("people_amount");
                System.out.println("Room: " + roomName);
                System.out.println("People in one room: " + peopleAmount);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}