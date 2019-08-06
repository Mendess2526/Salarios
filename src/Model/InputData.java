package Model;

public class InputData {
    private int salarioBruto;
    private int numDependentes;
    private int diuturnidadesNisentos;
    private int subAlimNisento;
    private int subAlimIsentoValor;
    private int numDias;
    private int abonoFalhasIsentoValor;
    private int outrosIsentos;
    private MaritalStatus maritalStatus;

    public InputData (int salarioBruto, int numDependentes, int diuturnidadesNisentos, int subAlimNisento,
                      int subAlimIsentoValor, int numDias, int abonoFalhasIsentoValor, int outrosIsentos, MaritalStatus maritalStatus){
        this.salarioBruto = salarioBruto;
        this.numDependentes = numDependentes;
        this.diuturnidadesNisentos = diuturnidadesNisentos;
        this.subAlimNisento = subAlimNisento;
        this.subAlimIsentoValor = subAlimIsentoValor;
        this.numDias = numDias;
        this.abonoFalhasIsentoValor = abonoFalhasIsentoValor;
        this.outrosIsentos = outrosIsentos;
        this.maritalStatus = maritalStatus;
    }

    public int getSalarioBruto() {
        return salarioBruto;
    }

    public int getNumDependentes() {
        return numDependentes;
    }

    public int getDiuturnidadesNisentos() {
        return diuturnidadesNisentos;
    }

    public int getSubAlimNisento() {
        return subAlimNisento;
    }

    public int getSubAlimIsentoValor() {
        return subAlimIsentoValor;
    }

    public int getNumDias() {
        return numDias;
    }

    public int getAbonoFalhasIsentoValor() {
        return abonoFalhasIsentoValor;
    }

    public int getOutrosIsentos() {
        return outrosIsentos;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }
}
