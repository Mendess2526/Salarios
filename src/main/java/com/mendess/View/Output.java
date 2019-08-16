package com.mendess.View;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Output {
    @FXML
    private Label retencaoIRSTaxL;
    @FXML
    private Label salarioBrutoL;
    @FXML
    private Label fctL;
    @FXML
    private Label outrosIsentosL;
    @FXML
    private Label abonoFalhasIsentoL;
    @FXML
    private Label subsidioAlimIsentoL;
    @FXML
    private Label diuturnidadesNaoIsentasL;
    @FXML
    private Label subAlimNaoIsentoL;
    @FXML
    private Label retencaoIRSL;
    @FXML
    private Label segSocialL;
    @FXML
    private Label totalIliquidoL;
    @FXML
    private Label outrosNaoIsentosL;
    @FXML
    private Label segSocialEEEL;
    @FXML
    private Label totalLiquidoL;


    @FXML
    public void initialize() {
        OutputChangeEvents.register(() -> {
            this.salarioBrutoL.setText(String.format("%,.2f€", Input.getOutput().getSalarioBruto() / 100.0));
            this.fctL.setText(String.format("%,.2f€", Input.getOutput().getFCT() / 100.0));
            this.outrosIsentosL.setText(String.format("%,.2f€", Input.getOutput().getOutrosIsentos() / 100.0));
            this.abonoFalhasIsentoL.setText(String.format("%,.2f€", Input.getOutput().getAbonoFalhasIsento() / 100.0));
            this.subsidioAlimIsentoL.setText(String.format(
                    "%,.2f€",
                    Input.getOutput().getSubAlimentacaoIsento() / 100.0));
            this.diuturnidadesNaoIsentasL.setText(String.format(
                    "%,.2f€",
                    Input.getOutput().getDiuturnidadesNaoIsentos()
                    / 100.0));
            this.subAlimNaoIsentoL.setText(String.format(
                    "%,.2f€",
                    Input.getOutput().getSubAlimentacaoNaoIsento() / 100.0));
            this.retencaoIRSL.setText(String.format("%,d.00€", Input.getOutput().getRetencaoIRS().getFirst() / 100));
            this.retencaoIRSTaxL.setText(String.format(
                    "%.2f%%",
                    Input.getOutput().getRetencaoIRS().getSecond() * 100.0));
            this.segSocialL.setText(String.format("%,.2f€", Input.getOutput().getSegSocial() / 100.0));
            this.totalIliquidoL.setText(String.format("%,.2f€", Input.getOutput().getTotalIliquido() / 100.0));
            this.outrosNaoIsentosL.setText(String.format("%,.2f€", Input.getOutput().getOutrosNaoIsentos() / 100.0));
            this.segSocialEEEL.setText(String.format("%,.2f€", Input.getOutput().getSegSocialEEE() / 100.0));
            this.totalLiquidoL.setText(String.format("%,.2f€", Input.getOutput().getTotalLiquido() / 100.0));
        });
    }

    public void save() {
        String csv = String.format("retencaoIRSTax,%s\n"
                                   + "salarioBruto,%s\n"
                                   + "fct,%s\n"
                                   + "outrosIsentos,%s\n"
                                   + "abonoFalhasIsento,%s\n"
                                   + "subsidioAlimIsento,%s\n"
                                   + "diuturnidadesNaoIsentas,%s\n"
                                   + "subAlimNaoIsento,%s\n"
                                   + "retencaoIRS,%s\n"
                                   + "segSocial,%s\n"
                                   + "totalIliquido,%s\n"
                                   + "outrosNaoIsentos,%s\n"
                                   + "segSocialEEE,%s\n"
                                   + "totalLiquido,%s",
                                   retencaoIRSTaxL.getText(),
                                   salarioBrutoL.getText(),
                                   fctL.getText(),
                                   outrosIsentosL.getText(),
                                   abonoFalhasIsentoL.getText(),
                                   subsidioAlimIsentoL.getText(),
                                   diuturnidadesNaoIsentasL.getText(),
                                   subAlimNaoIsentoL.getText(),
                                   retencaoIRSL.getText(),
                                   segSocialL.getText(),
                                   totalIliquidoL.getText(),
                                   outrosNaoIsentosL.getText(),
                                   segSocialEEEL.getText(),
                                   totalLiquidoL.getText());

        try {
            PrintWriter out = new PrintWriter("Simulacao_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("YY-MM-dd-HH:mm")) +".csv");
            out.println(csv);
            out.close();
        } catch (FileNotFoundException e) {
            Salarios.popUp(e.getMessage());
        }
    }

    public void goback() {
        Salarios.redirectTo(SceneLoader.View.InputWindow);
    }

    public void exitAll() {
        System.exit(0);
    }
}
