package Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class IRSTables {
    private static IRSTables instance = null;

    static IRSTables getInstance() {
        if (instance == null) {
            try {
                instance = new IRSTables();
            } catch (Exception e) {
                e.printStackTrace();
                throw new NullPointerException(e.getMessage());
            }
        }
        return instance;
    }

    private TreeMap<Integer, ArrayList<Double>> unmarried;
    private TreeMap<Integer, ArrayList<Double>> unmarriedDisabled;
    private TreeMap<Integer, ArrayList<Double>> married1;
    private TreeMap<Integer, ArrayList<Double>> married1Disabled;
    private TreeMap<Integer, ArrayList<Double>> married2;
    private TreeMap<Integer, ArrayList<Double>> married2Disabled;

    private IRSTables() throws Exception {
        this.unmarried = new TreeMap<>();
        this.unmarriedDisabled = new TreeMap<>();
        this.married1 = new TreeMap<>();
        this.married1Disabled = new TreeMap<>();
        this.married2 = new TreeMap<>();
        this.married2Disabled = new TreeMap<>();

        readFile(unmarried, "irs_tables/irs_retention_unmarried.csv");
        readFile(unmarriedDisabled, "irs_tables/irs_retention_unmarried_disabled.csv");
        readFile(married1, "irs_tables/irs_retention_married_only.csv");
        readFile(married1Disabled, "irs_tables/irs_retention_married_only_disabled.csv");
        readFile(married2, "irs_tables/irs_retention_married_double.csv");
        readFile(married2Disabled, "irs_tables/irs_retention_married_double_disabled.csv");
    }

    private static void readFile(TreeMap<Integer, ArrayList<Double>> table, String filename) throws Exception {
        File file = new File(filename);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(",");

            ArrayList<Double> values = Arrays.stream(parts)
                                             .skip(1)
                                             .map(s -> s.replaceFirst("%$", ""))
                                             .map(Double::parseDouble)
                                             .map(x -> x / 100)// TODO: FIX THIS
                                             .collect(Collectors.toCollection(ArrayList::new));

            table.put(Integer.parseInt(parts[0].replaceFirst("\\.","")), values);
        }
    }

    public enum IRSTableType {
        Single,
        SingleDisabled,
        Married1,
        Married1Disabled,
        Married2,
        Married2Disabled,
        ;

        @Override
        public String toString() {
            switch (this){
                case Single:
                    return "Single";
                case SingleDisabled:
                    return "SingleDisabled";
                case Married1:
                    return "Married1";
                case Married1Disabled:
                    return "Married1Disabled";
                case Married2:
                    return "Married2";
                case Married2Disabled:
                    return "Married2Disabled";
                default:
                    return "Oopsie Daisy!";
            }
        }
    }

    private double deducaoAux(TreeMap<Integer, ArrayList<Double>> table, int salarioBruto, int dependentes) {
        double percent = table.ceilingEntry(salarioBruto).getValue().get(dependentes);
        return percent * salarioBruto;
    }

    double deducaoSalario(IRSTableType estado, int salarioBruto, int dependentes) {
        switch (estado) {
            case Single:
                return deducaoAux(unmarried, salarioBruto, dependentes);
            case SingleDisabled:
                return deducaoAux(unmarriedDisabled, salarioBruto, dependentes);
            case Married1:
                return deducaoAux(married1, salarioBruto, dependentes);
            case Married1Disabled:
                return deducaoAux(married1Disabled, salarioBruto, dependentes);
            case Married2:
                return deducaoAux(married2, salarioBruto, dependentes);
            case Married2Disabled:
                return deducaoAux(married2Disabled, salarioBruto, dependentes);
            default:
                throw new IllegalArgumentException();
        }
    }
}
