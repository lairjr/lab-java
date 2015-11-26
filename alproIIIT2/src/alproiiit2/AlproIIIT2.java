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
    public static IPrintTreeHandler PrintTreeHandler;
    public static String FilePath = "./alproIII.csv";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        bootstrap();
        loadFile();
        
        /*while (true) {
            System.out.println("Informe o número de nodos: (0 para gerar enunciado, -1 para sair)");
            
            generateSampleTree();
            Integer numberOfNodes = Scanner.nextInt();
            
            if (numberOfNodes == -1)
                break;
            if (numberOfNodes == 0) 
                generateSampleTree();
            else
                generateRandomTree(numberOfNodes);
            
            PrintTreeHandler.printTree(Tree.getRoot());
        }*/
        
        for (Integer numberOfNodes = 1; numberOfNodes <= 10000; numberOfNodes++) {
            generateRandomTree(numberOfNodes);
            System.out.println(numberOfNodes);
            Integer numberOfOperations = PrintTreeHandler.printTreeNumberOfOperations(Tree.getRoot());
            writeOutput(numberOfNodes, numberOfOperations);
        }
        
        closeFile();
    }
    
    public static void bootstrap() {
        Scanner = new Scanner(System.in);
        Tree = new Tree();
	File = new File(FilePath);
        IPrintNodeInfoFactory printNodeInfoFactory = new PrintNodeInfoFactory();
        PrintTreeHandler = new PrintTreeHandler(printNodeInfoFactory);
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
    
    public static void generateRandomTree(Integer numberOfNodes) {
        Random random = new Random();
        Integer randomKey = random.nextInt(100000);
        Tree.setRoot(randomKey);
        
        for (Integer count = 1; count < numberOfNodes; count++) {
            randomKey = random.nextInt(100000);
            Tree.add(randomKey);
        }
    }
    
    public static void generateSampleTree() {
        Integer[] keyList = new Integer [] { 262, 80, 332, 3, 164, 297, 353, 73, 115, 199, 276, 325, 346, 367, 24, 143, 192, 220, 290, 318, 10, 31, 171, 206, 255, 45, 234, 38, 52, 241 };
        
        Tree.setRoot(keyList[0]);
        
        for (Integer index = 1; index < keyList.length; index++){
            Tree.add(keyList[index]);
        }
    }
}
