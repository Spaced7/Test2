import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Zad.1");

        int[] array = {1, 3, 5, 99, 2};

        arraySort(array);
        for (int j : array) {
            System.out.print(j + " ");
        }

        System.out.println();
        System.out.println("----------");

        System.out.println("Zad.2");

        int[] array1 = {5, 2, 3, 1, 10};

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(arraySort2(array1)));
        System.out.println("Tablica wejściowa bez zmian: ");
        System.out.println(Arrays.toString(array1));

        /*
        Różnica między metodami jest taka, że pierwsza(arraySort) modyfikuje tablicę którą otrzymuje w argumencie.
        Druga(arraySort2) metoda tworzy kopie tablicy, sortuje ją bez modyfikowania tablicy wejsciowej
         */

        System.out.println("----------");
        System.out.println("Zad.3");

        int[] array2 = {10, 20, 30, 40};
        System.out.println(checkIsArthimetic(array2));

        System.out.println("----------");
        System.out.println("Zad.4");
        int[] array3 = {2, 4, 8, 16};
        System.out.println(getNazwaCiagu(array2));
        System.out.println(getNazwaCiagu(array3));
        System.out.println(getNazwaCiagu(array));

        System.out.println("----------");
        System.out.println("Zad.5");

        int[] common1 = {1, 1, 2, 3, 4, 5};
        int[] common2 = {9, 7, 8, 10, 1, 2, 2, 5};
        int[] result = commonElements(common1, common2);
        for (int element : result) {
            System.out.println(element);
        }

    }

    public static void arraySort(int[] array) {
        Arrays.sort(array);
    }

    public static int[] arraySort2(int[] array) {
        int[] result = Arrays.copyOf(array, array.length);
        Arrays.sort(result);
        return result;
    }

    public static boolean checkIsArthimetic(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Tablica musi zawierac co najmniej 2 elementy");
        }
        int variable = array[1] - array[0];
        for (int i = 2; i < array.length; i++) {
            if (array[i] - array[i - 1] != variable) {
                return false;
            }

        }
        return true;
    }

    public static boolean checkIsGeometrnic(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Tablica musi zawierac co najmniej 2 elementy");
        }
        double d = (double) array[1] / array[0];
        for (int i = 1; i < array.length; i++) {
            if ((double) array[i] / array[i - 1] != d) {
                return false;
            }
        }
        return true;
    }

    public static String getNazwaCiagu(int[] ciag) {
        if (ciag == null) {
            throw new IllegalArgumentException("Ciąg jest pusty");
        }
        if (checkIsArthimetic(ciag)) {
            return "ARYTMETYCZNY";
        } else if (checkIsGeometrnic(ciag)) {
            return "GEOMETRYCZNY";
        } else {
            return "INNY";
        }
    }

    public static int[] commonElements(int[] array1, int[] array2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : array1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : array2) {
            set2.add(num);
        }

        set1.retainAll(set2);

        int[] results = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            results[i++] = num;
        }
        return results;
    }

}