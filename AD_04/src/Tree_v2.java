import java.lang.reflect.Array;

/**
 * Darstellung eines Baumes.
 * Der Baum besitzt eine Wurzel und es können weitere Wurzeln eingefügt werden.
 * Sollte eine Wurzel eingefügt werden, wird automatisch erkannt an welcher Position diese eingefügt werden muss.
 *
 * Desweiteren erlaubt diese Funktion das ausgeben des Baumes.
 * Man kann den Baum Symmetrisch, in Hauptreihenfolge sowie in der Nebenreihenfolge ausgeben.
 *
 *
 * @author Daniel Dichte
 * @author Santa Rudevica
 * @author Pascal Kießler
 *
 * @version 1.1
 * @version 09.06.2020
 *
 * @param <T>
 */
public class Tree_v2 <T extends Comparable<T>> implements Search_ {
    private Knot root;
    private Knot knot;
    private final int ZERO;
    private final int ARRAYSIZE;
  //  private final T arr [];
    private int counterSym;

    /**
     * Konstruktor der Klasse Tree_v2
     * @param root Wurzel des Baumes
     */
    public Tree_v2 (Knot  root) {
        this.root = root;
        ZERO = 0;
        ARRAYSIZE = 100;
    //    arr = (T[]) new Object[ARRAYSIZE];
        counterSym = 0;

        // man kann hier auch nur die Daten eingeben und dann kann man den rest der Wurzel erzeugen, anstatt direkt die ganze Wurzel zu übergeben.
    }


    /**
     * Hinzufügen eines weiteren Knotens.
     * Ein weiterer Knoten wird automatisch an der richtigen Stelle hinzugefügt. (Es wird erkannt wo er eingefügt werden muss)
     * @param data Vergleichbarer Wert der in den Knoten eingefügt wird.  Der Knoten wiederrum wird in den Baum eingefügt.
     */
    @Override
    public void addKnot(Object data) {
        Knot newKnot;
        int test = root.getData().compareTo(data);
        if (root.getData().compareTo(data) > ZERO ) {           //linke Seite der Wurzel
            if (root.getChildLeft() == null){                   //wenn noch kein Kind auf der linken seite vorhanden ist neuen Knoten einfügen
                newKnot = new Knot ((Comparable) data, root);                //Verbindungen des Knotens setzen
                root.setChildLeft(newKnot);                     //Verbindung der Wurzel setzen
            } else {
                knot = root.getChildLeft();                     //linken Knoten geben
                add (data);                                     //Einfuegeposition wird bestimmt
            }
        }
        if (root.getData().compareTo(data) <= ZERO ) {          //rechte Seite der Wurzel
            if (root.getChildRight() == null){                  //wenn noch kein Kind auf der rechten seite vorhanden ist neuen Knoten einfügen
                newKnot = new Knot ((Comparable) data, root);                //Verbindungen des Knotens setzen
                root.setChildRight(newKnot);                    //Verbindung der Wurzel setzen
            } else {
                knot = root.getChildRight();                    //rechten Knoten geben
                add (data);                                     //Einfuegeposition wird bestimmt
            }
        }
    }





    /**
     * Ausgabe der gewöhlten Methode.
     * Man kann zwischen der Hauptreihenfolge, der Nebenreihenfolge sowie der Symmetrischen Reihenfolge auswählen.
     *
     * @param method Methode die erkennt in welcher Methode der Baum ausgegeben werden soll.
     *               1 -> Hauptreihenfolge
     *               2 -> Nebenreihenfolge
     *               3 -> Symmetrisch
     */
    @Override
    public void output(int method) {
    if (method == 0) {
        //--> Hauptreihenfolge ausgeben
    } else if (method == 1) {
        //--> Nebenreihenfolge ausgeben
    } else {
        int counter = 0;
  //      symmetrisch(root);
    }


    }



/*
    public void symmetrisch (Knot knoten) {
        //relursiv links
        if (knoten.getChildLeft() == null) {            //wenn keine linke Seite, hole daten hier raus.
            arr[counterSym] = (T) knoten.getData();     //get wert
            counterSym++;
        } else {                                        //wenn es eine linke Seite gibt, gehe hier rein. am ende auch hier die Datan auslesen.
            symmetrisch(knoten.getChildLeft());
            arr[counterSym] = (T) knoten.getData();
            counterSym++;
        }
        //get wert
        //arr[counterSym] = (T) root.getData();
        //rekursiv rechts
        if (knoten.getChildRight() != null) {
            symmetrisch(knoten);
            arr[counterSym] = (T) knoten.getData();
            counterSym++;
        }
    }

 */














    private void add (Object data) {
        Knot newKnot;
        while (true){
            if (knot.getData().compareTo(data) > ZERO) {//sollten die Daten kleiner sein als die des aktuellen Knotens -> links einfügen
                if (knot.getChildLeft() == null) {      //sollte noch kein Knoten da sein, hier einen neuen einfügen
                    newKnot = new Knot((Comparable) data, knot);     //Verbindung des keien Knotens setzen
                    knot.setChildLeft(newKnot);         //Verbindungen des alten Knotens setzen
                    break;  //ggf. muss hier ein return hin
                } else {                                //wenn hier schon ein Knoten ist, hole mir den neuen knoten und gehe erneut durch die Schleife.
                    knot = knot.getChildLeft();
                }
            } else { //evtl. hier else if (knot.getData().compareTo(data) >= ZERO)          //Wenn das Kind auf die Rechte seite muss, geh hier rein
                if (knot.getChildRight() == null) {     //Wenn auf der rechten Seite des Knotens noch kein weiterer Knoten ist, fuege ihn hier ein
                    newKnot = new Knot((Comparable) data, knot);     //Verbindung des keien Knotens setzen
                    knot.setChildRight(newKnot);        //Verbindungen des alten Knotens setzen
                    break;
                } else {                                //wenn hier schon ein Knoten ist, hole mir den neuen knoten und gehe erneut durch die Schleife.
                    knot = knot.getChildRight();
                }
            }
        }
    }
}