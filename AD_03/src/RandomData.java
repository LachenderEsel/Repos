import javax.swing.*;
import java.util.Random;

/**
 * Zufällige Pivot Strategie
 * wir ziehen uns ein beliebiges Element aus dem Array, welches im weiteren unser Pivotelement darstellt.
 */
public class RandomData <T extends Comparable<T>> implements PivotStrategie <T> {

    private final int ZERO;
    private final int MANUELLSORTIEREN;

    /**
     * Konstruktor der Klasse Randomdata
     */
    RandomData() {
        ZERO = 0;
        MANUELLSORTIEREN = 30;
    }

    /**
     * Bestimmen eines Zufaelligen Pivotelementes, das zurückgegeben wird.
     * @param array Array der Elemente die zu sortieren sind
     * @return Rückgabe des Pivotelememtes
     */
    @Override
    public T getPivotelement (T array []) {
    return array[zufallsPivotelement(array)];
}


    /**
     * Sortiert die Arrays und findet für jeden weiteren Aufruf ein neues Pivotelement.
     * Ruft sich rekursiv auf
     * @param a Generisches Array, das es zu sortieren gilt.
     * @param iLinks Linke hälfte des Pivotelementes
     * @param iRechts rechte hälfte des Pivotslementes
     */
    public void sortiereQS (T a [], int iLinks, int iRechts) {
        if ((iRechts - iLinks) <= MANUELLSORTIEREN) {
            sortiereIS(a);
        } else if (iRechts > iLinks) {
            int i = iLinks;
            int j = iRechts - 1;
           // T pivot = a[iRechts];
            T pivot = getPivotelement(a);
            while (true) {
                while (a[i].compareTo(pivot) < ZERO) {
                    T thorsten = a[i];
                    i++;
                }
                while (a[j].compareTo(pivot) >= ZERO && j > ZERO) {
                    T thorsten = a[j];
                    j--;
                }
                if (i >= j) {
                    // In der Mitte getroffen
                    break;
                }
                // Vertauschen
                swap(a, i, j);
            }
            // Pivotelement in der Mitte tauschen
            swap(a, i, iRechts);
            sortiereQS(a, iLinks, i - 1);
            sortiereQS(a, i + 1, iRechts);
        }
    }


    /**
     * Vertauschen der Elemente
     * @param erstesElement Erstes Element
     * @param zweitesElement Zweites Element
     */
    private void swap(T array [], int erstesElement, int zweitesElement) {
        T buffer = array[erstesElement];
        array[erstesElement] = array[zweitesElement];
        array[zweitesElement] = buffer;
    }


    /**
     * Sortiert nach der Insertion Sort Variante, sobald das Array 30 oder weniger elemente hat
     * @param array Generisches Array, das es zu sortieren gilt.
     */
    private void sortiereIS (T array []) {
        for (int i = 1; i < array.length; i++){
            int j = i;
            T element = array[i];
            while (j >= 1 && array[j - i].compareTo(element) > ZERO){
                array[j] = array[j - 1];
                j = j - 1;
            }
            array[j] = element;
        }
    }

    /**
     * Hilfsmethode um einen zufällig gewähltes Pivotelement zu bestimmen.
     * @return Stelle in dem Array
     */
    private int zufallsPivotelement(T array []) {
        Random zufaelligesElement = new Random();
        int pivotelement = zufaelligesElement.nextInt(array.length - 1);
        return pivotelement;
    }
}
