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
public class BubbleSort {
    public static int Count;
    
    public static void Sort(int[] vector) {
        Count += 3;
        for (int i = 0; i < vector.length; i++) {
            Count += 8;
            for (int j = 0; j < vector.length - 1; j++){
                Count +=11;
                if (vector[j] > vector[j + 1]) {
                    Swap(vector, j, j + 1);
                }
            }
        }
    }

    private static void Swap(int[] vector, int j, int i) {
        int tmp = vector[i];
        vector[i] = vector[j];
        vector[j] = tmp;
    }
}
