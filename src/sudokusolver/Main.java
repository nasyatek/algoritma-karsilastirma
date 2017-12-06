package sudokusolver;

/**
 *
 * @author ay
 */
public class Main {

    public static void main(String[] args) {
        // Helper dosyamız da iki adet sudoku ve yardımcı metotlar var.
        // Bunlar print sudoku ve sudoku conflict bulan metotlardır.
        Helper h = new Helper();
        BackTrackkingYontemi btm = new BackTrackkingYontemi(h.getSudokuKolay());
        System.out.println(btm.toString());
        btm.solve();
        long startTime = System.currentTimeMillis();
        Helper h2 = new Helper();
        SimuAnelYontemi simuAnelYontemi = new SimuAnelYontemi();
        simuAnelYontemi.SimulatedAnnealingSolve(h2.getSudokuZor());
        System.out.println("SimulatingAnelling - Çözüm için harcanan süre: " + (System.currentTimeMillis() - startTime) + "ms ");
    }
}
