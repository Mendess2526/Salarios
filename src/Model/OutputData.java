package Model;

public class OutputData {
    private int salarioBruto;
    private int outrosNaoIsentos;
    private int subAlimentacaoNaoIsento;
    private int diuturnidadesNaoIsentos;
    private int subAlimentacaoIsento;
    private int abonoFalhasIsento;
    private int outrosIsentos;
    private int totalIliquido;
    private int segSocial;
    private int retencaoIRS;
    private int totalLiquido;
    private int segSocialEEE;
    private int FCT;

    public OutputData(int salarioBruto, int outrosNaoIsentos, int subAlimentacaoNaoIsento, int diuturnidadesNaoIsentos, int subAlimentacaoIsento,
                      int abonoFalhasIsento, int outrosIsentos, int totalIliquido, int segSocial, int retencaoIRS,
                      int totalLiquido, int segSocialEEE, int FCT){
        this.salarioBruto = salarioBruto;
        this.outrosNaoIsentos = outrosNaoIsentos;
        this.subAlimentacaoNaoIsento = subAlimentacaoNaoIsento;
        this.diuturnidadesNaoIsentos = diuturnidadesNaoIsentos;
        this.subAlimentacaoIsento = subAlimentacaoIsento;
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

    public int getSubAlimentacaoNaoIsento() {
        return subAlimentacaoNaoIsento;
    }

    public int getDiuturnidadesNaoIsentos() {
        return diuturnidadesNaoIsentos;
    }

    public int getSubAlimentacaoIsento() {
        return subAlimentacaoIsento;
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

    public int getOutrosNaoIsentos() {
        return outrosNaoIsentos;
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "salarioBruto=" + salarioBruto +
                ", outrosNaoIsentos=" + outrosNaoIsentos +
                ", subAlimentacaoNaoIsento=" + subAlimentacaoNaoIsento +
                ", diuturnidadesNaoIsentos=" + diuturnidadesNaoIsentos +
                ", subAlimentacaoIsento=" + subAlimentacaoIsento +
                ", abonoFalhasIsento=" + abonoFalhasIsento +
                ", outrosIsentos=" + outrosIsentos +
                ", totalIliquido=" + totalIliquido +
                ", segSocial=" + segSocial +
                ", retencaoIRS=" + retencaoIRS +
                ", totalLiquido=" + totalLiquido +
                ", segSocialEEE=" + segSocialEEE +
                ", FCT=" + FCT +
                '}';
    }
}
