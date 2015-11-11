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
        Bootstrap();
        LoadFile();
        
        while (true) {
            System.out.println("Informe o número de nodos: (0 para sair)");
            
            Integer numberOfNodes = Scanner.nextInt();
            if (numberOfNodes == 0)
                break;
            GenerateRandomTree(numberOfNodes);
            Integer numberOfOperations = GetNumberOfOperations();
            WriteOutput(numberOfNodes, numberOfOperations);
        }
        
        CloseFile();
    }
    
    public static void Bootstrap() {
        Scanner = new Scanner(System.in);
        Tree = new Tree();
	File = new File(FilePath);
    }
    
    public static void CloseFile() {
        try {
            BufferWriter.close();
        }
        catch (Exception e) {
            // let it throw
        }
    }
    
    public static void LoadFile() {
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
    
    public static void WriteOutput(Integer numberOfNodes, Integer numberOfOperations) {
        try {
            BufferWriter.newLine();
            BufferWriter.write(numberOfNodes + "," + numberOfOperations);
        } catch (Exception e) {
        }
    }
    
    public static Integer GetNumberOfOperations() {
        return Tree.GetNodesByLevelCountOperations();
    }
    
    public static void GenerateRandomTree(Integer numberOfNodes) {
        Random random = new Random();
        Integer randomKey = random.nextInt(100000);
        Tree.SetRoot(new Node(randomKey));
        
        for (Integer count = 0; count < numberOfNodes; count++) {
            randomKey = random.nextInt(100000);
            Tree.Add(randomKey);
        }
    }
}
