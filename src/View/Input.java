package View;

import Model.Constants;
import Model.IRSTables;
import Model.InputData;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Input implements Initializable {
    @FXML private TextField salarioBruto;
    @FXML private TextField numDependentes;
    @FXML private TextField numDias;
    @FXML private TextField outrosIsentos;
    @FXML private TextField abonoFalhas;
    @FXML private TextField diuturnidadesNaoIsentas;
    @FXML private CheckBox emNumerario;
    @FXML private ChoiceBox<IRSTables.IRSTableType> tabelaIRS;
    @FXML private ChoiceBox<Constants.EncargosEEmpregadoraSS> encargosEE;
    @FXML private TextField subsidioAlim;
    @FXML private TextField outrosNaoIsentos;

    public void calculate(){
        int salarioBruto = Integer.parseInt(this.salarioBruto.getText());
        int numDependentes = Integer.parseInt(this.numDependentes.getText());
        int numDias = Integer.parseInt(this.numDias.getText());
        int outrosIsentos = Integer.parseInt(this.outrosIsentos.getText());
        int abonoFalhas = Integer.parseInt(this.abonoFalhas.getText());
        int diuturnidadesNaoIsentas = Integer.parseInt(this.diuturnidadesNaoIsentas.getText());
        boolean emNumerario = this.emNumerario.isSelected();

        int subsidioAlim = Integer.parseInt(this.subsidioAlim.getText());
        int outrosNaoIsentos = Integer.parseInt(this.outrosNaoIsentos.getText());
        IRSTables.IRSTableType irsTableType = tabelaIRS.getValue();
        Constants.EncargosEEmpregadoraSS encargosEEmpregadoraSS = encargosEE.getValue();
        InputData id = new InputData(
                salarioBruto,
                numDependentes,
                numDias,
                outrosIsentos,
                irsTableType,
                abonoFalhas,
                diuturnidadesNaoIsentas,
                emNumerario,
                subsidioAlim,
                outrosNaoIsentos,
                encargosEEmpregadoraSS);
        System.out.println(id);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabelaIRS.setItems(FXCollections.observableList(Arrays.asList(IRSTables.IRSTableType.values())));
        encargosEE.setItems(FXCollections.observableList(Arrays.asList(Constants.EncargosEEmpregadoraSS.values())));
    }
}
