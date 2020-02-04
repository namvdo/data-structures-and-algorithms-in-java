public class EnglishRuler {
    /** Draws an English ruler for the given number of inches and major tick length. */
    public static void drawRuler(int nInches, int majorLength){
        drawLine(majorLength, 0); // draw inch 0 line and label
        for(int i = 1; i <= nInches; i++){
            drawInterval(majorLength - 1); // draw interior ticks for inch
            drawLine(majorLength, i); // draw inch i line and label 
        }
    }
    private static void drawInterval(int centralLength){
        // if centralLength < 1, do nothing.
        if(centralLength >= 1){
            drawInterval(centralLength - 1); // recursively draw top interval
            drawLine(centralLength); // draw central tick line (without label)
            drawInterval(centralLength - 1); // recursively draw bottom interval
        }
    }
    private static void drawLine(int tickLength, int tickLabel){
        for(int i = 0; i < tickLength; i++){
            System.out.print("-");
        }
        if(tickLabel >= 0){
            System.out.print(" " + tickLabel);
        }
        System.out.println();
    }
    /** Draws a line with a given tick length (with no label). */
    private static void drawLine(int tickLength){
        drawLine(tickLength, -1);
    }
}