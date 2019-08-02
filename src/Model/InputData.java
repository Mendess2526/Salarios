package Model;

public class InputData {
    private int salarioBruto;
    private int numDependentes;
    private int diuturnidadesNisentos;
    private int subAlimNisento;
    private int subAlimIsentoValor;
    private int numDias;
    private int abonoFalhasIsento;
    private int outrosIsentos;

    public InputData (int salarioBruto, int numDependentes, int diuturnidadesNisentos, int subAlimNisento,
                      int subAlimIsentoValor, int numDias, int abonoFalhasIsento, int outrosIsentos){
        this.salarioBruto = salarioBruto;
        this.numDependentes = numDependentes;
        this.diuturnidadesNisentos = diuturnidadesNisentos;
        this.subAlimNisento = subAlimNisento;
        this.subAlimIsentoValor = subAlimIsentoValor;
        this.numDias = numDias;
        this.abonoFalhasIsento = abonoFalhasIsento;
        this.outrosIsentos = outrosIsentos;
    }
}
