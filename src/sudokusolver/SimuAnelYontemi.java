package sudokusolver;

import java.util.*;

public class SimuAnelYontemi {

    boolean[] sabitKareler;

    public ArrayList<Integer> initNumbers(ArrayList<Integer> numbers) {
        numbers.clear();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        return numbers;
    }

    // boş kareler 0 kabul edildi.
    public void SimulatedAnnealingSolve(int[][] sudoku) {
        sabitKareler = new boolean[81];

        // dolu olan kareler değiştirilemez olarak işaretlendi.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] != 0) {
                    sabitKareler[i * 9 + j] = true;
                }
            }
        }

        // 3x3 kareler kontrol edilip rastgele dolduruluyor.
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers = initNumbers(numbers);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (sudoku[row][col] != 0) {
                    numbers.remove(new Integer(sudoku[row][col]));
                }
            }
        }
        Collections.shuffle(numbers);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (sudoku[row][col] == 0) {
                    sudoku[row][col] = numbers.remove(0);
                }
            }
        }

        numbers = initNumbers(numbers);

        for (int row = 0; row < 3; row++) {
            for (int col = 3; col < 6; col++) {
                if (sudoku[row][col] != 0) {
                    numbers.remove(new Integer(sudoku[row][col]));
                }
            }
        }
        Collections.shuffle(numbers);
        for (int row = 0; row < 3; row++) {
            for (int col = 3; col < 6; col++) {
                if (sudoku[row][col] == 0) {
                    sudoku[row][col] = numbers.remove(0);
                }
            }
        }

        numbers = initNumbers(numbers);

        for (int row = 0; row < 3; row++) {
            for (int col = 6; col < 9; col++) {
                if (sudoku[row][col] != 0) {
                    numbers.remove(new Integer(sudoku[row][col]));
                }
            }
        }
        Collections.shuffle(numbers);
        for (int row = 0; row < 3; row++) {
            for (int col = 6; col < 9; col++) {
                if (sudoku[row][col] == 0) {
                    sudoku[row][col] = numbers.remove(0);
                }
            }
        }

        numbers = initNumbers(numbers);

        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 3; col++) {
                if (sudoku[row][col] != 0) {
                    numbers.remove(new Integer(sudoku[row][col]));
                }
            }
        }
        Collections.shuffle(numbers);
        for (int row = 3; row < 6; row++) {
            for (int col = 0; col < 3; col++) {
                if (sudoku[row][col] == 0) {
                    sudoku[row][col] = numbers.remove(0);
                }
            }
        }

        numbers = initNumbers(numbers);

        for (int row = 3; row < 6; row++) {
            for (int col = 3; col < 6; col++) {
                if (sudoku[row][col] != 0) {
                    numbers.remove(new Integer(sudoku[row][col]));
                }
            }
        }
        Collections.shuffle(numbers);
        for (int row = 3; row < 6; row++) {
            for (int col = 3; col < 6; col++) {
                if (sudoku[row][col] == 0) {
                    sudoku[row][col] = numbers.remove(0);
                }
            }
        }

        numbers = initNumbers(numbers);

        for (int row = 3; row < 6; row++) {
            for (int col = 6; col < 9; col++) {
                if (sudoku[row][col] != 0) {
                    numbers.remove(new Integer(sudoku[row][col]));
                }
            }
        }
        Collections.shuffle(numbers);
        for (int row = 3; row < 6; row++) {
            for (int col = 6; col < 9; col++) {
                if (sudoku[row][col] == 0) {
                    sudoku[row][col] = numbers.remove(0);
                }
            }
        }

        numbers = initNumbers(numbers);

        for (int row = 6; row < 9; row++) {
            for (int col = 0; col < 3; col++) {
                if (sudoku[row][col] != 0) {
                    numbers.remove(new Integer(sudoku[row][col]));
                }
            }
        }
        Collections.shuffle(numbers);
        for (int row = 6; row < 9; row++) {
            for (int col = 0; col < 3; col++) {
                if (sudoku[row][col] == 0) {
                    sudoku[row][col] = numbers.remove(0);
                }
            }
        }

        numbers = initNumbers(numbers);

        for (int row = 6; row < 9; row++) {
            for (int col = 3; col < 6; col++) {
                if (sudoku[row][col] != 0) {
                    numbers.remove(new Integer(sudoku[row][col]));
                }
            }
        }
        Collections.shuffle(numbers);
        for (int row = 6; row < 9; row++) {
            for (int col = 3; col < 6; col++) {
                if (sudoku[row][col] == 0) {
                    sudoku[row][col] = numbers.remove(0);
                }
            }
        }

        numbers = initNumbers(numbers);

        for (int row = 6; row < 9; row++) {
            for (int col = 6; col < 9; col++) {
                if (sudoku[row][col] != 0) {
                    numbers.remove(new Integer(sudoku[row][col]));
                }
            }
        }
        Collections.shuffle(numbers);
        for (int row = 6; row < 9; row++) {
            for (int col = 6; col < 9; col++) {
                if (sudoku[row][col] == 0) {
                    sudoku[row][col] = numbers.remove(0);
                }
            }
        }

        for (int row = 0; row < 9; row++) {
            System.out.println();
            if (row == 0) {
                System.out.println("\n -----------------------");
            }
            for (int col = 0; col < 9; col++) {
                if (sudoku[row][col] != 0) {
                    if (col == 0) {
                        System.out.print("| ");
                    }
                    System.out.print(sudoku[row][col] + " ");
                    if (col == 2 | col == 5 | col == 8) {
                        System.out.print("| ");
                    }
                } else {
                    if (col == 0) {
                        System.out.print("| ");
                    }
                    System.out.print("-" + " ");
                    if (col == 2 | col == 5 | col == 8) {
                        System.out.print("| ");
                    }
                }
            }
            if (row == 2 | row == 5 | row == 8) {
                System.out.print("\n -----------------------");
            }
        }
        System.out.println();

        recurseSolve(sudoku, 0.3, 0);
    }

    public int numConflicts(int[][] sudoku) {
        int num = 0;
        HashMap<Integer, Integer> numbers = new HashMap<>();

        // satır kontrolu
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (numbers.get(sudoku[i][j]) == null) {
                    numbers.put(sudoku[i][j], 1);
                } else {
                    numbers.put(sudoku[i][j], numbers.get(sudoku[i][j]) + 1);
                }
            }

            for (int j = 1; j <= 9; j++) {
                if (numbers.get(j) != null && numbers.get(j) > 1) {
                    num += numbers.get(j) - 1;
                }
                numbers.put(j, null);
            }
        }
        // sutun kontrolu
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                if (numbers.get(sudoku[row][col]) == null) {
                    numbers.put(sudoku[row][col], 1);
                } else {
                    numbers.put(sudoku[row][col], numbers.get(sudoku[row][col]) + 1);
                }
            }

            for (int j = 1; j <= 9; j++) {
                if (numbers.get(j) != null && numbers.get(j) > 1) {
                    num += numbers.get(j) - 1;
                }
                numbers.put(j, null);
            }
        }
        return num;
    }

    // tekrarlı fonksiyon
    public int[][] recurseSolve(int[][] sudoku, double temperature, int iteration) {
        int initConflicts = numConflicts(sudoku);
        //0-8 arası rastgele bir sayı üretiyoruz

        if (initConflicts == 0) {
            System.out.println("Çözüm bulundu, iterasyon sayısı: " + iteration);
            return sudoku;
        }

        int square = (int) (Math.random() * 9);
        int xRandom = 0;
        int yRandom = 0;
        // Rastgele kare seçip herhangi bir karede rastgele değişim yapıyoruz, değiştirilemez 
        // bir alana gelinceye kadar
        switch (square) {
            case 0:
                xRandom = 0;
                yRandom = 0;
                break;
            case 1:
                xRandom = 0;
                yRandom = 3;
                break;
            case 2:
                xRandom = 0;
                yRandom = 6;
                break;
            case 3:
                xRandom = 3;
                yRandom = 0;
                break;
            case 4:
                xRandom = 3;
                yRandom = 3;
                break;
            case 5:
                xRandom = 3;
                yRandom = 6;
                break;
            case 6:
                xRandom = 6;
                yRandom = 0;
                break;
            case 7:
                xRandom = 6;
                yRandom = 3;
                break;
            case 8:
                xRandom = 6;
                yRandom = 6;
                break;
        }

        int x1, y1, x2, y2;
        do {
            x1 = (int) (Math.random() * 3);
            y1 = (int) (Math.random() * 3);
            x2 = (int) (Math.random() * 3);
            y2 = (int) (Math.random() * 3);
        } while (sabitKareler[(xRandom + x1) * 9 + (yRandom + y1)] || sabitKareler[(xRandom + x2) * 9 + (yRandom + y2)]);
        System.out.println("İterasyon Sayısı: " + iteration);//+ " Temp: " + temperature
        iteration++;

        int[][] tempSudoku = new int[9][9];
        multiArrayCopy(sudoku, tempSudoku);
        tempSudoku[xRandom + x1][yRandom + y1] = sudoku[xRandom + x2][yRandom + y2];
        tempSudoku[xRandom + x2][yRandom + y2] = sudoku[xRandom + x1][yRandom + y1];

        int newConflicts = numConflicts(tempSudoku);

        if (newConflicts < initConflicts) {
            multiArrayCopy(tempSudoku, sudoku);
        } else {
            double probability = Math.exp((initConflicts - newConflicts) / temperature);
            double random = Math.random();
            if (random <= probability) {
                multiArrayCopy(tempSudoku, sudoku);
            }
        }

        for (int row = 0; row < 9; row++) {
            System.out.println();
            if (row == 0) {
                System.out.println("\n -----------------------");
            }
            for (int col = 0; col < 9; col++) {
                if (sudoku[row][col] != 0) {
                    if (col == 0) {
                        System.out.print("| ");
                    }
                    System.out.print(sudoku[row][col] + " ");
                    if (col == 2 | col == 5 | col == 8) {
                        System.out.print("| ");
                    }
                } else {
                    if (col == 0) {
                        System.out.print("| ");
                    }
                    System.out.print("-" + " ");
                    if (col == 2 | col == 5 | col == 8) {
                        System.out.print("| ");
                    }
                }
            }
            if (row == 2 | row == 5 | row == 8) {
                System.out.print("\n -----------------------");
            }
        }
        System.out.println();

        if (iteration > 4450) {
            return sudoku;
        }

        double nextTemperature = updateTemp(temperature);
        return recurseSolve(sudoku, nextTemperature, iteration);
    }

    public void multiArrayCopy(int[][] source, int[][] destination) {
        for (int a = 0; a < source.length; a++) {
            System.arraycopy(source[a], 0, destination[a], 0, source[a].length);
        }
    }

    public double updateTemp(double temperature) {
        temperature *= .8;
        return temperature;
    }
}
