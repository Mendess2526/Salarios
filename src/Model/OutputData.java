package Model;

public class OutputData {
    private  int salarioBruto;
    private int subAlimNisento;
    private int diuturnidadesNisentos;
    private int subAlimIsento;
    private int abonoFalhasIsento;
    private int outrosIsentos;
    private int totalIliquido;
    private int segSocial;
    private int FCT;
    private int totalMensalSegSocial;
    private int totalMensalIRS;
    private int totalMensalFCT_FGCT;
    private int totalMensalSalario;

    public OutputData (int salarioBruto, int subAlimNisento, int diuturnidadesNisentos, int subAlimIsento,
                      int abonoFalhasIsento, int outrosIsentos, int totalIliquido, int segSocial, int FCT,
                      int totalMensalSegSocial, int totalMensalIRS, int totalMensalFCT_FGCT, int totalMensalSalario){
        this.salarioBruto = salarioBruto;
        this.subAlimNisento = subAlimNisento;
        this.diuturnidadesNisentos = diuturnidadesNisentos;
        this.subAlimIsento = subAlimIsento;
        this.abonoFalhasIsento = abonoFalhasIsento;
        this.outrosIsentos = outrosIsentos;
        this.totalIliquido = totalIliquido;
        this.segSocial = segSocial;
        this.FCT = FCT;
        this.totalMensalSegSocial = totalMensalSegSocial;
        this.totalMensalIRS = totalMensalIRS;
        this.totalMensalFCT_FGCT = totalMensalFCT_FGCT;
        this.totalMensalSalario = totalMensalSalario;
    }
}
