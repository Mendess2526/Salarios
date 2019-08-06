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
    private int retencaoIRS;
    private int totalLiquido;
    private int segSocialEEE;
    private int FCT;

    public OutputData (int salarioBruto, int subAlimNisento, int diuturnidadesNisentos, int subAlimIsento,
                      int abonoFalhasIsento, int outrosIsentos, int totalIliquido, int segSocial, int retencaoIRS,
                      int totalLiquido, int segSocialEEE, int FCT){
        this.salarioBruto = salarioBruto;
        this.subAlimNisento = subAlimNisento;
        this.diuturnidadesNisentos = diuturnidadesNisentos;
        this.subAlimIsento = subAlimIsento;
        this.abonoFalhasIsento = abonoFalhasIsento;
        this.outrosIsentos = outrosIsentos;
        this.totalIliquido = totalIliquido;
        this.segSocial = segSocial;
        this.retencaoIRS = retencaoIRS;
        this.totalLiquido = totalLiquido;
        this.segSocialEEE = segSocialEEE;
        this.FCT = FCT;
    }

    public int getSalarioBruto() {
        return salarioBruto;
    }

    public int getSubAlimNisento() {
        return subAlimNisento;
    }

    public int getDiuturnidadesNisentos() {
        return diuturnidadesNisentos;
    }

    public int getSubAlimIsento() {
        return subAlimIsento;
    }

    public int getAbonoFalhasIsento() {
        return abonoFalhasIsento;
    }

    public int getOutrosIsentos() {
        return outrosIsentos;
    }

    public int getTotalIliquido() {
        return totalIliquido;
    }

    public int getSegSocial() {
        return segSocial;
    }

    public int getRetencaoIRS() {
        return retencaoIRS;
    }

    public int getTotalLiquido() {
        return totalLiquido;
    }

    public int getSegSocialEEE() {
        return segSocialEEE;
    }

    public int getFCT() {
        return FCT;
    }
}
