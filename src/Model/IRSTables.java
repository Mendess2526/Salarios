package Model;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class IRSTables {
    private TreeMap<Integer, ArrayList<Integer>> unmarried;
    private TreeMap<Integer, ArrayList<Integer>> unmarriedDisabled;
    private TreeMap<Integer, ArrayList<Integer>> married1;
    private TreeMap<Integer, ArrayList<Integer>> married1Disabled;
    private TreeMap<Integer, ArrayList<Integer>> married2;
    private TreeMap<Integer, ArrayList<Integer>> married2Disabled;

    public IRSTables() throws Exception {
        this.unmarried = new TreeMap<>();
        this.unmarriedDisabled = new TreeMap<>();
        this.married1 = new TreeMap<>();
        this.married1Disabled = new TreeMap<>();
        this.married2 = new TreeMap<>();
        this.married2Disabled = new TreeMap<>();

        readFile(unmarried, "irs_retention_unmarried");
        readFile(unmarriedDisabled, "irs_retention_unmarried_disabled");
        readFile(married1, "irs_retention_married_only");
        readFile(married1Disabled, "irs_retention_married_only_disabled");
        readFile(married2, "irs_retention_married_double");
        readFile(married2Disabled, "irs_retention_married_double_disabled");
    }

    private static void readFile(TreeMap<Integer, ArrayList<Integer>> table, String filename) throws Exception {
        File file = new File(filename);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(",");

            ArrayList<Integer> values = Arrays.stream(parts).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

            table.put(Integer.parseInt(parts[0]), values);
        }
    }

    public enum IRSTableType {
        Single,
        SingleDisabled,
        Married1,
        Married1Disabled,
        Married2,
        Married2Disabled,
    }

    private int deducaoAux(TreeMap<Integer, ArrayList<Integer>> table, int salarioBruto, int dependentes) {
        int percent = table.floorEntry(salarioBruto).getValue().get(dependentes);
        return percent * salarioBruto;
    }

    public int deducaoSalario(IRSTableType estado, int salarioBruto, int dependentes) {
        int res = 0;
        switch (estado) {
            case Single:
                res = deducaoAux(unmarried, salarioBruto, dependentes);
                break;
            case SingleDisabled:
                res = deducaoAux(unmarriedDisabled, salarioBruto, dependentes);
                break;
            case Married1:
                res = deducaoAux(married1, salarioBruto, dependentes);
                break;
            case Married1Disabled:
                res = deducaoAux(married1Disabled, salarioBruto, dependentes);
                break;
            case Married2:
                res = deducaoAux(married2, salarioBruto, dependentes);
                break;
            case Married2Disabled:
                res = deducaoAux(married2Disabled, salarioBruto, dependentes);
                break;
        }
        return res;
    }
}
