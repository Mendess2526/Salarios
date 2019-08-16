package View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Output implements Initializable {
    @FXML private Label salarioBrutoL;
    @FXML private Label fctL;
    @FXML private Label outrosIsentosL;
    @FXML private Label abonoFalhasIsentoL;
    @FXML private Label subsidioAlimIsentoL;
    @FXML private Label diuturnidadesNaoIsentasL;
    @FXML private Label subAlimNaoIsentoL;
    @FXML private Label retencaoIRSL;
    @FXML private Label segSocialL;
    @FXML private Label totalIliquidoL;
    @FXML private Label outrosNaoIsentosL;
    @FXML private Label segSocialEEEL;
    @FXML private Label totalLiquidoL;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.salarioBrutoL.setText(Input.output.getSalarioBruto() / 100.0 + "");
        this.fctL.setText(Input.output.getFCT() + "");
        this.outrosIsentosL.setText(Input.output.getOutrosIsentos() / 100.0 + "");
        this.abonoFalhasIsentoL.setText(Input.output.getAbonoFalhasIsento() / 100.0 + "");
        this.subsidioAlimIsentoL.setText(Input.output.getSubAlimentacaoIsento() / 100.0 + "");
        this.diuturnidadesNaoIsentasL.setText(Input.output.getDiuturnidadesNaoIsentos() / 100.0 + "");
        this.subAlimNaoIsentoL.setText(Input.output.getSubAlimentacaoNaoIsento() / 100.0 + "");
        this.retencaoIRSL.setText(Input.output.getRetencaoIRS() / 100.0 + "");
        this.segSocialL.setText(Input.output.getSegSocial() / 100.0 + "");
        this.totalIliquidoL.setText(Input.output.getTotalIliquido() / 100.0 + "");
        this.outrosNaoIsentosL.setText(Input.output.getOutrosNaoIsentos() / 100.0 + "");
        this.segSocialEEEL.setText(Input.output.getSegSocialEEE() / 100.0 + "");
        this.totalLiquidoL.setText(Input.output.getTotalLiquido() / 100.0 + "");
    }

    public void goback() {
        Salarios.redirectTo(SceneLoader.View.InputWindow);
    }

    public void exitAll(){
        System.exit(0);
    }
}
