package Model;

public class Solver {
    private static double subAlimNisento(int subAlimIsentoValor){ //FIXME
        if(subAlimIsentoValor>4.77) return subAlimIsentoValor-4.77;
        else return 0;
    }

    private static double subAlimIsento(int subAlimIsentoValor, int numDias){ //FIXME
        if(subAlimIsentoValor<=4.77) return numDias*subAlimIsentoValor;
        else return 4.77*numDias;
    }

    private static double abonoFalhasIsento(int abonoFalhasIsentoValor, int constante){ //FIXME
        if(abonoFalhasIsentoValor<constante) return abonoFalhasIsentoValor;
        else return constante;
    }

    private static int totalIliquido(int salarioBruto, int subAlimNisento, int diuturnidadesNisentos,
                                     int subAlimentoIsentoValor, int abonoFalhasIsento, int outrosIsentos) {
        return salarioBruto + subAlimNisento + diuturnidadesNisentos + subAlimentoIsentoValor + abonoFalhasIsento +
                outrosIsentos;
    }

    private static int segSocial(int salariobruto, int subAlimNisento, int diuturnidadesNisentos) {
        return (int) Math.round((salariobruto + subAlimNisento + diuturnidadesNisentos) * Constants.SocialSecurityTaxWorker);
    }

    private static int retencaoIRS(int salarioBruto, int subAlimNisento, int diuturnidadesNisentos, MaritalStatus maritalStatus) {
        return (int) Math.round((salarioBruto + subAlimNisento + diuturnidadesNisentos) * Constants.retentionTax(maritalStatus));
    }

    private static int totalLiquido(int totalIliquido, int segSocial, int retencaoIRS) {
        return totalIliquido - segSocial - retencaoIRS;
    }

    private static int segSocialEEE(int salariobruto, int subAlimNisento, int diuturnidadesNisentos, MaritalStatus maritalStatus) {
        return (int) Math.round((salariobruto + subAlimNisento + diuturnidadesNisentos) * Constants.SocialSecurityTaxEmployer);
    }

    private static int FCT(int salarioBruto, int diuturnidadesNisentos) {
        return (int) Math.round((salarioBruto + diuturnidadesNisentos) * Constants.FCT);
    }

    public OutputData solve(InputData in) {
        int salarioBruto = in.getSalarioBruto();
        int diuturnidadesNisentos = in.getDiuturnidadesNisentos();
        int outrosIsentos = in.getOutrosIsentos();

        int subAlimNisento = subAlimNisento(in.getSubAlimIsentoValor());
        int subAlimIsento = subAlimIsento(in.getSubAlimIsentoValor(), in.getNumDias());
        int abonoFalhasIsento = abonoFalhasIsento(in.getAbonoFalhasIsentoValor(), constante); //FIXME
        int totalIliquido = totalIliquido(salarioBruto, subAlimNisento, diuturnidadesNisentos, subAlimIsento, abonoFalhasIsento, outrosIsentos);
        int segSocial = segSocial(salarioBruto, subAlimNisento, diuturnidadesNisentos);
        int retencaoIRS = retencaoIRS(salarioBruto, subAlimNisento, diuturnidadesNisentos);
        int totalLiquido = totalLiquido(totalIliquido, segSocial, retencaoIRS);
        int segSocialEEE = segSocialEEE(salarioBruto, subAlimNisento, diuturnidadesNisentos);
        int FCT = FCT(salarioBruto, diuturnidadesNisentos);

        OutputData out = new OutputData(
                salarioBruto,
                subAlimNisento,
                diuturnidadesNisentos,
                subAlimIsento,
                abonoFalhasIsento,
                outrosIsentos,
                totalIliquido,
                segSocial,
                retencaoIRS,
                totalLiquido,
                segSocialEEE,
                FCT);
        return out;
    }
}
