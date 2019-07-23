package Model;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class IRSTables {
    private Hashtable<Integer, ArrayList<Integer>> married2disabled;
    private Hashtable<Integer, ArrayList<Integer>> married2;
    private Hashtable<Integer, ArrayList<Integer>> married1disabled;
    private Hashtable<Integer, ArrayList<Integer>> married1;
    private Hashtable<Integer, ArrayList<Integer>> unmarriedisabled;
    private Hashtable<Integer, ArrayList<Integer>> unmarried;

    public IRSTables() throws Exception {
        this.married2disabled = new Hashtable<>();
        this.married2 = new Hashtable<>();
        this.married1disabled = new Hashtable<>();
        this.married1 = new Hashtable<>();
        this.unmarriedisabled = new Hashtable<>();
        this.unmarried = new Hashtable<>();

        readFile(married2disabled, "irs_retention_married_double_disabled");
        readFile(married2, "irs_retention_married_double");
        readFile(married1disabled, "irs_retention_married_only_disabled");
        readFile(married1, "irs_retention_married_only");
        readFile(unmarriedisabled, "irs_retention_unmarried_disabled");
        readFile(unmarried, "irs_retention_unmarried");
    }

    private void readFile(Hashtable<Integer, ArrayList<Integer>> table, String filename) throws Exception {
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
        Married2Disabled,
        Married2,
        Married1Disabled,
        Married,
        SingleDisabled,
        Single
    }

    private int deducaoAux(TreeMap<Integer, ArrayList<Integer>> table, int salarioBruto, int dependentes) {
        int percent = table.floorEntry(salarioBruto).getValue().get(dependentes);
        return percent * salarioBruto;
    }

    private int deducaoSalario(IRSTableType estado, int salarioBruto, int dependentes) {
        int res = 0;
        switch (estado) {
            case Married2Disabled:
                TreeMap<Integer, ArrayList<Integer>> married2disableD = new TreeMap<>();
                married2disableD.putAll(married2disabled);
                res = deducaoAux(married2disableD, salarioBruto, dependentes);
                break;
            case Married2:
                TreeMap<Integer, ArrayList<Integer>> marrieD2 = new TreeMap<>();
                marrieD2.putAll(married2);
                res = deducaoAux(marrieD2, salarioBruto, dependentes);
                break;
            case Married1Disabled:
                TreeMap<Integer, ArrayList<Integer>> married1DisableD = new TreeMap<>();
                married1DisableD.putAll(married1disabled);
                res = deducaoAux(married1DisableD, salarioBruto, dependentes);
                break;
            case Married:
                TreeMap<Integer, ArrayList<Integer>> marrieD1 = new TreeMap<>();
                marrieD1.putAll(married1);
                res = deducaoAux(marrieD1, salarioBruto, dependentes);
                break;
            case SingleDisabled:
                TreeMap<Integer, ArrayList<Integer>> singledisableD = new TreeMap<>();
                singledisableD.putAll(unmarriedisabled);
                res = deducaoAux(singledisableD, salarioBruto, dependentes);
                break;
            case Single:
                TreeMap<Integer, ArrayList<Integer>> singlE = new TreeMap<>();
                singlE.putAll(unmarried);
                res = deducaoAux(singlE, salarioBruto, dependentes);
        }
        return res;
    }
}
