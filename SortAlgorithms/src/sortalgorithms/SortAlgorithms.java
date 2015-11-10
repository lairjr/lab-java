/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgorithms;

import java.util.Arrays;

/**
 *
 * @author lairjr
 */
public class SortAlgorithms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] vector = new int[] {9,6,2,3,8,7,1,0,4,5};
        System.out.println(Arrays.toString(vector));
        InsertionSort.Sort(vector);
        System.out.println(Arrays.toString(vector));
    }
    
}
