/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alproiiit2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lairjr
 */
public class AlproIIIT2 {
    public static Tree Tree;
    public static Scanner Scanner;
    public static File File;
    public static BufferedWriter BufferWriter;
    public static String FilePath = "./alproIII.csv";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        bootstrap();
        loadFile();
        
        while (true) {
            System.out.println("Informe o número de nodos: (0 para sair)");
            
            Integer numberOfNodes = Scanner.nextInt();
            if (numberOfNodes == 0)
                break;
            generateRandomTree(numberOfNodes);
            Integer numberOfOperations = getNumberOfOperations();
            writeOutput(numberOfNodes, numberOfOperations);
        }
        
        /*for (Integer numberOfNodes = 1; numberOfNodes <= 10000; numberOfNodes++) {
            generateRandomTree(numberOfNodes);
            Integer numberOfOperations = getNumberOfOperations();
            writeOutput(numberOfNodes, numberOfOperations);
        }*/
        
        closeFile();
    }
    
    public static void bootstrap() {
        Scanner = new Scanner(System.in);
        Tree = new Tree();
	File = new File(FilePath);
    }
    
    public static void closeFile() {
        try {
            BufferWriter.close();
        }
        catch (Exception e) {
            // let it throw
        }
    }
    
    public static void loadFile() {
        try {
            if (!File.exists()) {
                File.createNewFile();
            }
            FileWriter fw = new FileWriter(File.getAbsoluteFile());
            BufferWriter = new BufferedWriter(fw);
            BufferWriter.write("numberOfNodes,numberOfOperations");
        }
        catch (Exception e) {
            // let it throw
        }
    }
    
    public static void writeOutput(Integer numberOfNodes, Integer numberOfOperations) {
        try {
            BufferWriter.newLine();
            BufferWriter.write(numberOfNodes + "," + numberOfOperations);
        } catch (Exception e) {
            // let it throw
        }
    }
    
    public static Integer getNumberOfOperations() {
        return Tree.getNodesByeLvelCountOperations();
    }
    
    public static void generateRandomTree(Integer numberOfNodes) {
        Random random = new Random();
        Integer randomKey = random.nextInt(100000);
        Tree.setRoot(randomKey);
        
        for (Integer count = 0; count < numberOfNodes; count++) {
            randomKey = random.nextInt(100000);
            Tree.add(randomKey);
        }
    }
}
