package me.devik.systemManager;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

public class SystemManager {

    public void checkAvailability() {
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

        try {
            File file = new File("src/main/resources/data.yaml");
            InputStream inputStream = new FileInputStream(file);
            Yaml yaml = new Yaml();
            Map<String, Object> yamlData = yaml.load(inputStream);

            for (Map.Entry<String, Object> entry : yamlData.entrySet()) {
                String roomName = entry.getKey();
                Map<String, Object> roomDetail = (Map<String, Object>) entry.getValue();

                int peopleAmount = (int) roomDetail.get("people_amount");
                int total_price = (int) roomDetail.get("price_night");
                boolean food_breakfast = (boolean) roomDetail.get("breakfast");
                boolean food_lunch_dinner = (boolean) roomDetail.get("lunch_dinner");

                if (people == peopleAmount && breakfast_bool == food_breakfast && lunch_dinner_bool == food_lunch_dinner) { // And ....
                    System.out.println("You could have one of these rooms: " + roomName);
                    System.out.println("Here you have your total price for " + nights + " nights: " + nights * total_price);
                    return;
                } else {
                    System.out.println("We don't have any available room for you, sorry.");
                    return;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}