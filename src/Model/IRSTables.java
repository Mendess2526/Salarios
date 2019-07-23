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

    public IRSTables() throws Exception{
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

    private void readFile (Hashtable<Integer, ArrayList<Integer>> table, String filename) throws Exception{
        File file = new File("desktop/Salarios/irs_tables/filename.csv");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(",");

            ArrayList<Integer> values = Arrays.stream(parts).map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

            table.put(Integer.parseInt(parts[0]),values);
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

    private int deducaoAux (Hashtable<Integer, ArrayList<Integer>> table, int salarioBruto, int dependentes){
        NavigableMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        map.putAll(married2disabled);
        int percent = map.floorEntry(salarioBruto).getValue().get(dependentes);
        return percent*salarioBruto;
    }

    private int deducaoSalario(IRSTableType estado, int salarioBruto, int dependentes){
        int res=0;
        switch (estado){
            case Married2Disabled:
                res = deducaoAux(married2disabled, salarioBruto, dependentes);
                break;
            case Married2:
                res = deducaoAux(married2, salarioBruto, dependentes);
                break;
            case Married1Disabled:
                res = deducaoAux(married1disabled, salarioBruto, dependentes);
                break;
            case Married:
                res = deducaoAux(married1, salarioBruto, dependentes);
                break;
            case SingleDisabled:
                res = deducaoAux(unmarriedisabled, salarioBruto, dependentes);
                break;
            case Single:
                res = deducaoAux(unmarried, salarioBruto, dependentes);
        }
        return res;
    }
}
