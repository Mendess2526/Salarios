package Model;

public class Solver {
    private static int totalIliquido(int salarioBruto, int subAlimNisento, int diuturnidadesNisentos,
                                    int subAlimentoIsentoValor, int abonoFalhasIsento, int outrosIsentos){
        return salarioBruto + subAlimNisento + diuturnidadesNisentos + subAlimentoIsentoValor + abonoFalhasIsento +
                outrosIsentos;
    }

    private static double segSocial(int salariobruto, int subAlimNisento, int diuturnidadesNisentos){
        return (salariobruto+subAlimNisento+diuturnidadesNisentos)*0.11;
    }

    private static double retencaoIRS(int salarioBruto, int subAlimNisento, int diuturnidadesNisentos){
        return (salarioBruto+subAlimNisento+diuturnidadesNisentos)*0.64;
    }

    private static double totalLiquido(int totalIliquido, double segSocial, double retencaoIRS){
        return totalIliquido-segSocial-retencaoIRS;
    }

    private static double segSocialEEE(int salariobruto, int subAlimNisento, int diuturnidadesNisentos){
        return (salariobruto+subAlimNisento+diuturnidadesNisentos)*0.2375;
    }

    private static double FCT(int salarioBruto, int diuturnidadesNisentos){
        return (salarioBruto+diuturnidadesNisentos)*0.1;
    }

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


    public OutputData solve(InputData in){
        int salarioBruto = in.getSalarioBruto();
        int subAlimNisento = in.getSubAlimNisento();
        int diuturnidadesNisentos = in.getDiuturnidadesNisentos();
        int subAlimIsento = in.getSubAlimIsentoValor();
        int abonoFalhasIsento = in.getAbonoFalhasIsento();
        int outrosIsentos = in.getOutrosIsentos();
        int totalIliquido = totalIliquido(salarioBruto, subAlimNisento, diuturnidadesNisentos, subAlimIsento,
                abonoFalhasIsento, outrosIsentos);
        double segSocial = segSocial(salarioBruto, subAlimNisento, diuturnidadesNisentos);
        double retencaoIRS = retencaoIRS(salarioBruto, subAlimNisento, diuturnidadesNisentos);
        double totalLiquido = totalLiquido(totalIliquido, segSocial, retencaoIRS);
        double segSocialEEE = segSocialEEE(salarioBruto, subAlimNisento, diuturnidadesNisentos);
        double FCT = FCT(salarioBruto, diuturnidadesNisentos);
        OutputData out = new OutputData(salarioBruto, subAlimNisento, diuturnidadesNisentos, subAlimIsento,
                abonoFalhasIsento, outrosIsentos, totalIliquido, segSocial, retencaoIRS, totalLiquido, segSocialEEE, FCT);
        return out;
    }
}
