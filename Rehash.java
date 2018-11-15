// Drew Williams
// hw1108
// https://github.com/Github-Archives/hw1108/edit/master/Rehash.java

import java.util.Random;

public class Rehash {

    public static void main(String[] args) {

        int count = 0;
        int index = 0;
        int size = 8;
        int key = 0;
        int max = 40;
        int var = 0;
        Random rand = new Random(97);

        int[] table = new int[size];
        int[] input = new int[20];
        int[] value = new int[41];

        for(int i = 0; i < value.length; i++){
            value[i] = 10 + i;
        }

        for(int i = 0; i < input.length; i++){
            var = rand.nextInt(max + 1);
            input[i] = value[var];
            value[var] = value[max];
            max--;
        }

        for(int i = 0; i < input.length; i++){
            key = input[i];
            index = key % size;
            while (table[index] != 0) {
                index = (index + 1) % size;
            }
            table[index] = key;
            count++;
            if (count / size >= .75) {
                size *= 2;
                table = rehashTable(table, size, count);
            }
        }

        System.out.println("INDEX" + "\t\t" + "DATA VALUE");
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + "\t\t\t" + table[i]);
        }
    }

    public static int[] rehashTable(int[] table, int size, int count){
        int[] nextTable = new int[size];
        int key = 0, index = 0;

        for (int i = 0; i < table.length; i++){
            if (table[i] != 0) {
                key = table[i];
                index = key % size;
                while (nextTable[index] != 0){
                    index = (index + 1) % size;
                }
                nextTable[index] = key;
            }

        }
        return nextTable;
    }

}
