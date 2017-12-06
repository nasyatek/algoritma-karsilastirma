package sudokusolver;

public class BackTrackkingYontemi {

    int[][] sudoku;
    private Helper helper = new Helper();
    int steps = 0;

    public BackTrackkingYontemi(int[][] s) {
        sudoku = s;
    }

    // 0,0 koordinatı ile başlıyoruz
    // çözüm yoksa bir sonraki adıma geçiyoruz.
    public void solve() {
        long startTime = System.currentTimeMillis();
        if (isSolve(0, 0)) {
            System.out.println(this.toString());
            System.out.println("Backtracking - Çözüm için harcanan süre: " + (System.currentTimeMillis() - startTime) + "ms :::  " + steps + " adımda sonuç bulundu!");
        } else {
            System.out.println("Backtracking - Çözüm için harcanan süre: " + (System.currentTimeMillis() - startTime) + "ms, sonuç bulunamadı!");
        }
    }

    // Bir sonraki adımda çözüm var mı kontrol ediyoruz, bu fonksiyon
    // _next
    protected boolean isSolve(int sat, int sut) {
        steps++;
        // Belirlenen koordinatta 0 yoksa bir sonraki koordinata geç
        // 0 yoksa zaten bir sayı var, değiştirme
        if (sudoku[sat][sut] != 0) {
            return nextStep(sat, sut);
        } else {
            // 0 varsa buraya uygun bir rakam atıyoruz
            // 1-9 arası rakam atıp util metodu ile kontrol ediyoruz.
            for (int num = 1; num < 10; num++) {
                // Set edilen sayı uygun değilse, bir sonraki deneme için nextStep 
                // fonksiyonu çağrılıyor. yeni bir numara set edip kontrol ediyoruz
                if (!helper.isValid(sat, sut, num, sudoku)) {
                    sudoku[sat][sut] = num;
                    // Next stepten bir çözüm geldiyse isSolve fonksiyonu true olacak.
                    if (nextStep(sat, sut)) {
                        return true;
                    }
                    // Uygun bir değer değilse tekrar 0 set ediyoruz.
                    // System.out.println("Eski : " + sat + "." + sut + " DEGER " + sudoku[sat][sut] + " Yeni : " + 0);
                    sudoku[sat][sut] = 0;
                }
            }
            return false;
        }
    }

    // Eğer çözüm yok ise satır ya da kolonu bir arttırıyoruz.
    // Varsa true dönüyoruz
    // sutun 8'den küçükse bir arttır, değilse satırı bir arttır
    public boolean nextStep(int sat, int sut) {
        System.out.println(sat + "." + " satır " + sut + "."
                + " sutun kontrol ediliyor. Deger: " + sudoku[sat][sut]);
        if (sut < 8) {
            return isSolve(sat, sut + 1);
        } else if (sat < 8) {
            return isSolve(sat + 1, 0);
        } else {
            return true;
        }
    }

    // Print metodu ile yazdırıyoruz.
    @Override
    public String toString() {
        return helper.printSudoku(sudoku);
    }
}
