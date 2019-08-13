package View;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
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
    @FXML private Button back;
    @FXML private Button exit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.salarioBrutoL.setText(Input.output.getSalarioBruto() + "");
        this.fctL.setText(Input.output.getFCT() + "");
        this.outrosIsentosL.setText(Input.output.getOutrosIsentos() + "");
        this.abonoFalhasIsentoL.setText(Input.output.getAbonoFalhasIsento() + "");
        this.subsidioAlimIsentoL.setText(Input.output.getSubAlimentacaoIsento() + "");
        this.diuturnidadesNaoIsentasL.setText(Input.output.getDiuturnidadesNaoIsentos() + "");
        this.subAlimNaoIsentoL.setText(Input.output.getSubAlimentacaoNaoIsento() + "");
        this.retencaoIRSL.setText(Input.output.getRetencaoIRS() + "");
        this.segSocialL.setText(Input.output.getSegSocial() + "");
        this.totalIliquidoL.setText(Input.output.getTotalIliquido() + "");
        this.outrosNaoIsentosL.setText(Input.output.getOutrosNaoIsentos() + "");
        this.segSocialEEEL.setText(Input.output.getSegSocialEEE() + "");
        this.totalLiquidoL.setText(Input.output.getTotalLiquido() + "");
    }

    public void goback() throws IOException {
        Redirect.redirectTo(back, "View/InputWindow.fxml");
    }

    public void exitAll(){
        
    }
}
