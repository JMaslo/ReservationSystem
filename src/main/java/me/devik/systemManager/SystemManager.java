package me.devik.systemManager;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    public void YamlParser() {
        try {
            String yamlFilePath = "configuration/data.yaml";
            Yaml yaml = new Yaml();
            FileInputStream inputStream = new FileInputStream(yamlFilePath);
            Map<String, Object> yamlData = yaml.load(inputStream);

            // From every room load data

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}