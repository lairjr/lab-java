/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortalgorithms;

/**
 *
 * @author lairjr
 */
public class InsertionSort {
    public static void Sort(int[] vector) {
        for (int j = 1; j < vector.length; j++) {
            int i = j - 1;
            int key = vector[j];
            while ((i >= 0) && (vector[i] > key)) {
                vector[i + 1] = vector[i];
                i--;
            }
            vector[i + 1] = key;
        }
    }
}
