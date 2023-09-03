public class Fridge {
    double size;
    boolean freezer;
    String color;

    public Fridge(double size, boolean freezer, String color) {
        this.size = size;
        this.freezer = freezer;
        this.color = color;
    }

    public String toString(){
        String result = String.format("%.1f cubic foot Fridge ",size);
        if (freezer){
            result += String.format("with Freezer (%s).",color);
        }
        else{
            result += String.format("(%s).",color);
        }
        return result;
    }
}
