package Model;

public class InputData {
    public float salarioBruto;
    private int numDependentes;
    private int diuturnidadesNisentos;
    private float subAlimNisento;
    private int numDias;
    private float abonoFalhasIsento;
    private float outrosIsentos;

    public InputData (float salarioBruto, int numDependentes, int diuturnidadesNisentos, float subAlimNisento,
                      int numDias, float abonoFalhasIsento, float outrosIsentos){
        this.salarioBruto = salarioBruto;
        this.numDependentes = numDependentes;
        this.diuturnidadesNisentos = diuturnidadesNisentos;
        this.subAlimNisento = subAlimNisento;
        this.numDias = numDias;
        this.abonoFalhasIsento = abonoFalhasIsento;
        this.outrosIsentos = outrosIsentos;
    }
}
