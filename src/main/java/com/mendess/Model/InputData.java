package com.mendess.Model;

import com.mendess.util.Pair;

public class InputData {
    private final int salarioBruto;
    private final int numDependentes;
    private final IRSTables.IRSTableType maritalStatus;
    private final int numDias;
    private final int outrosIsentos;
    private final int abonoParaFalhas;
    private final int diuturnidadesNaoIsentos;
    private final boolean emNumerario;
    private final int subAlimentacaoBase;
    private final int outrosNaoIsento;
    private final Constants.EncargosEEmpregadoraSS encargosEEmpregadoraSS;

    public InputData(
            int salarioBruto,
            int numDependentes,
            int numDias,
            int outrosIsentos,
            IRSTables.IRSTableType maritalStatus,
            int abonoParaFalhas,
            int diuturnidadesNaoIsentos,
            boolean emNumerario,
            int subAlimentacaoBase,
            int outrosNaoIsentos,
            Constants.EncargosEEmpregadoraSS encargosEEmpregadoraSS
                    ) {
        this.salarioBruto = salarioBruto;
        this.numDependentes = numDependentes;
        this.numDias = numDias;
        this.outrosIsentos = outrosIsentos;
        this.maritalStatus = maritalStatus;
        this.abonoParaFalhas = abonoParaFalhas;
        this.diuturnidadesNaoIsentos = diuturnidadesNaoIsentos;
        this.emNumerario = emNumerario;
        this.subAlimentacaoBase = subAlimentacaoBase;
        this.outrosNaoIsento = outrosNaoIsentos;
        this.encargosEEmpregadoraSS = encargosEEmpregadoraSS;
    }

    private int subAlimentacaoNaoIsento() {
        int isencao = Constants.isencaoMetodoRenumeracao(this.emNumerario);
        if (this.subAlimentacaoBase > isencao) {
            return (this.subAlimentacaoBase - isencao) * this.numDias;
        } else {
            return 0;
        }
    }

    private int subAlimentacaoIsento() {
        int isencao = Constants.isencaoMetodoRenumeracao(this.emNumerario);
        if (this.subAlimentacaoBase <= isencao) {
            return this.numDias * this.subAlimentacaoBase;
        } else {
            return isencao * this.numDias;
        }
    }

    private int abonoFalhasIsento() {
        return Math.min(this.abonoParaFalhas, (int) (0.05 * this.salarioBruto));
    }

    private int totalNaoIsento(int subAlimentacaoNaoIsento) {
        return this.salarioBruto + this.outrosNaoIsento + subAlimentacaoNaoIsento + this.diuturnidadesNaoIsentos;
    }

    private int totalIliquido(int totalNaoIsento, int subAlimentacaoIsento, int abonoParaFalhasIsento) {
        return totalNaoIsento + subAlimentacaoIsento + abonoParaFalhasIsento + this.outrosIsentos;
    }

    private int segSocial(int totalNaoIsento) {
        return (int) Math.round(totalNaoIsento * Constants.SocialSecurityTaxWorker);
    }

    private Pair<Integer, Double> retencaoIRS(int totalNaoIsento) {
        Pair<Double, Double> values = IRSTables.getInstance()
                                               .deducaoSalario(this.maritalStatus, totalNaoIsento, this.numDependentes);
        return values.mapFirst(a -> (int) Math.round(a));
    }

    private int totalLiquido(int totalIliquido, int segSocial, int retencaoIRS) {
        return totalIliquido - segSocial - retencaoIRS;
    }

    private int segSocialEE(int totalNaoIsento) {
        return (int) Math.round((totalNaoIsento * this.encargosEEmpregadoraSS.getTaxa()));
    }

    private int FCT() {
        return (int) Math.round((this.salarioBruto + this.diuturnidadesNaoIsentos) * Constants.FCT);
    }

    public OutputData solve() {
        // Nao isento
        int subAlimentacaoNaoIsento = subAlimentacaoNaoIsento();
        int totalNaoIsento = totalNaoIsento(subAlimentacaoNaoIsento);
        // Isento
        int subAlimentacaoIsento = subAlimentacaoIsento();
        int abonoFalhasIsento = abonoFalhasIsento();

        int totalIliquido = totalIliquido(totalNaoIsento, subAlimentacaoIsento, abonoFalhasIsento);
        int segSocial = segSocial(totalNaoIsento);
        Pair<Integer, Double> retencaoIRS = retencaoIRS(totalNaoIsento);

        return new OutputData(
                this.salarioBruto,
                this.outrosNaoIsento,
                subAlimentacaoNaoIsento(),
                this.diuturnidadesNaoIsentos,
                subAlimentacaoIsento(),
                abonoFalhasIsento(),
                this.outrosIsentos,
                totalIliquido,
                segSocial,
                retencaoIRS,
                totalLiquido(totalIliquido, segSocial, retencaoIRS.getFirst()),
                segSocialEE(totalNaoIsento),
                FCT());
    }
}
