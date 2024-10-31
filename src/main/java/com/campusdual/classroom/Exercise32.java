package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exercise32 {

    public static void main(String[] args) {

        String userInput = generateStringToSave(null);

        printToFile(userInput);


    }

    public static String generateStringToSave(String string) {

        if (string != null) {
            return string;
        }else {
            return generateUserInputToSave();
        }

    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {

        Path filePath = Paths.get("src/main/resources/data.txt");

        try {

            if (!Files.exists(filePath)) {
                Files.createDirectories(filePath.getParent());
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(PrintWriter pw = new PrintWriter(new FileWriter(filePath.toFile()))) {
            pw.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}