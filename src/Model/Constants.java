package Model;

public class Constants {
    static final double SocialSecurityTaxWorker = 0.11;
    static final double FCT = 0.01;

    static int isencaoMetodoRenumeracao(boolean emCartao) {
        if (emCartao) {
            return 477;
        } else {
            return 763;
        }
    }

    public enum EncargosEEmpregadoraSS {
        RegineGeral(.2375),
        PrimeiroEmprego(.2375 / 2),
        ;

        private final double taxa;

        EncargosEEmpregadoraSS(double taxa) {
            this.taxa = taxa;
        }

        public double getTaxa() {
            return this.taxa;
        }
    }
}
