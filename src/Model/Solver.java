package Model;

public class Formulas {
    public static int totalIliquido(int salarioBruto, int subAlimNisento, int diuturnidadesNisentos,
                                    int subAlimentoIsentoValor, int abonoFalhasIsento, int outrosIsentos){
        return salarioBruto + subAlimNisento + diuturnidadesNisentos + subAlimentoIsentoValor + abonoFalhasIsento +
                outrosIsentos;
    }

    public static double segSocial(int salariobruto, int subAlimNisento, int diuturnidadesNisentos){
        return (salariobruto+subAlimNisento+diuturnidadesNisentos)*0.11;
    }

    public static double retencaoIRS(int salarioBruto, int subAlimNisento, int diuturnidadesNisentos){
        return (salarioBruto+subAlimNisento+diuturnidadesNisentos)*0.64;
    }

    public static int totalLiquido(int totalIliquido, int segSocial, int retencaoIRS){
        return totalIliquido-segSocial-retencaoIRS;
    }

    public static double segSocialEEE(int salariobruto, int subAlimNisento, int diuturnidadesNisentos){
        return (salariobruto+subAlimNisento+diuturnidadesNisentos)*0.2375;
    }

    public static double FCT(int salarioBruto, int diuturnidadesNisentos){
        return (salarioBruto+diuturnidadesNisentos)*0.1;
    }
}
