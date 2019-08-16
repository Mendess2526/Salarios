package Model;

public class Tests {

    public static void main(String[] args) {
        InputData in = new InputData(
                100000,
                3,
                22,
                60000,
                IRSTables.IRSTableType.Married2,
                4000,
                0,
                true,
                583,
                12300,
                Constants.EncargosEEmpregadoraSS.RegineGeral
        );
        OutputData o = in.solve();
        if (o.getSalarioBruto() != 100000) {
            System.out.println("Salario mal: " + o.getSalarioBruto());
        }
        if (o.getOutrosNaoIsentos() != 12300) {
            System.out.println("Outros nao isentos mal: " + o.getOutrosNaoIsentos());
        }
        if (o.getSubAlimentacaoNaoIsento() != 2332) {
            System.out.println("Sub alim nao is mal: " + o.getSubAlimentacaoNaoIsento());
        }
        if (o.getDiuturnidadesNaoIsentos() != 0) {
            System.out.println("Diu mal: " + o.getDiuturnidadesNaoIsentos());
        }
        if (o.getSubAlimentacaoIsento() != 10494) {
            System.out.println("Sub alim is mal: " + o.getSubAlimentacaoIsento());
        }
        if (o.getAbonoFalhasIsento() != 4000) {
            System.out.println("Abono para falhas mal: " + o.getAbonoFalhasIsento());
        }
        if (o.getOutrosIsentos() != 60000) {
            System.out.println("Outros Isentos mal: " + o.getOutrosIsentos());
        }
        if (o.getTotalIliquido() != 189126) {
            System.out.println("Total Iliquido mal: " + o.getTotalIliquido());
        }
        if (o.getSegSocial() != 12610) {
            System.out.println("Seg Social mal: " + o.getSegSocial());
        }
        if (o.getRetencaoIRS() != 10661) {
            System.out.println("Retencao IRS mal: " + o.getRetencaoIRS());
        }
        if (o.getTotalLiquido() != 165856) {
            System.out.println("Liquido mal: " + o.getTotalLiquido());
        }
        if (o.getSegSocialEEE() != 27225) {
            System.out.println("EEE mal: " + o.getSegSocialEEE());
        }
        if (o.getFCT() != 1000) {
            System.out.println("FCT mal: " + o.getFCT());
        }
        System.out.println(o);
    }
}
