public class DoppelKnoten<T> {
    private DoppelKnoten _vorgaenger;
    private DoppelKnoten _nachfolger;
    private T _element;

    public DoppelKnoten(DoppelKnoten vorgaenger, DoppelKnoten nachfolger, T element){
        _vorgaenger = vorgaenger;
        _nachfolger = nachfolger;
        _element = element;
    }

    public DoppelKnoten(){
        // braucht man für Konstruktor von der Verkettung
    };

    public DoppelKnoten gibNachfolger() {
        return _nachfolger;
    }

    public void setzeNachfolger(DoppelKnoten nachfolger){
        _nachfolger = nachfolger;
    }

    public DoppelKnoten gibVorgaenger() {
        return _vorgaenger;
    }

    public void setzeVorgaenger(DoppelKnoten vorgaenger){
        _vorgaenger = vorgaenger;
    }

    public T gibElement() {
        return _element;
    }

    public void setzeElement(T element){
        _element = element;
    }
}