package View;

import Model.IRSTables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    @FXML private TextField salarioBruto;
    @FXML private TextField numDependentes;
    @FXML private TextField numDias;
    @FXML private TextField outrosIsentos;
    @FXML private TextField abonoFalhas;
    @FXML private TextField diuturnidadesNisentas;
    @FXML private CheckBox emNumerario;
    @FXML private ChoiceBox tabelaIRS;
    @FXML private ChoiceBox encargosEE;
    @FXML private TextField subsidioAlim;
    @FXML private TextField outrosNisentos;

    public Input(){
        List<String> coiso = Arrays.stream(IRSTables.IRSTableType.values()).map(IRSTables.IRSTableType::toString).collect(Collectors.toList());
        ObservableList<String> coiso2 = FXCollections.observableList(coiso);
        tabelaIRS.setItems(coiso2);
    }
    public void calculate(){
        int salariobruto = Integer.parseInt(salarioBruto.getText());
        int numdependentes = Integer.parseInt(numDependentes.getText());
        int numdias = Integer.parseInt(numDias.getText());
        int outrosisentos = Integer.parseInt(outrosIsentos.getText());
        int abonofalhas = Integer.parseInt(abonoFalhas.getText());
        int diuturnidadesnisentas = Integer.parseInt(diuturnidadesNisentas.getText());
        boolean emnumerario = emNumerario.isSelected();

        int subsidioalim = Integer.parseInt(subsidioAlim.getText());
        int outrosnisentos = Integer.parseInt(outrosNisentos.getText());


    }
}
