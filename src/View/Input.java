package View;

import Model.Constants;
import Model.IRSTables;
import Model.InputData;
import Model.OutputData;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.ResourceBundle;

import static java.lang.Double.parseDouble;

public class Input implements Initializable {
    public static OutputData output;

    @FXML
    public Label salarioBrutoError;
    @FXML
    public Label numDependentesError;
    @FXML
    public Label numDiasError;
    @FXML
    public Label outrosIsentosError;
    @FXML
    public Label abonoParaFalhasError;
    @FXML
    public Label diuturnidadesNaoIsentasError;
    @FXML
    public Label subsidioAlimError;
    @FXML
    public Label outrosNaoIsentosError;
    @FXML
    public Label tabelaIRSError;
    @FXML
    public Label encargosEEError;

    @FXML
    private TextField salarioBruto;
    @FXML
    private TextField numDependentes;
    @FXML
    private TextField numDias;
    @FXML
    private TextField outrosIsentos;
    @FXML
    private TextField abonoFalhas;
    @FXML
    private TextField diuturnidadesNaoIsentas;
    @FXML
    private CheckBox emNumerario;
    @FXML
    private ChoiceBox<IRSTables.IRSTableType> tabelaIRS;
    @FXML
    private ChoiceBox<Constants.EncargosEEmpregadoraSS> encargosEE;
    @FXML
    private TextField subsidioAlim;
    @FXML
    private TextField outrosNaoIsentos;

    private Optional<Integer> getSalarioBruto() {
        try {
            return Optional.of((int) Math.floor(parseDouble(this.salarioBruto.getText()) * 100));
        } catch (NumberFormatException e) {
            this.salarioBrutoError.setText("Invalid number");
        }
        return Optional.empty();
    }

    private Optional<Integer> getNumDependentes() {
        try {
            final int n = Integer.parseInt(this.numDependentes.getText());
            if (n < 0) {
                throw new InvalidParameterException();
            }
            return (n > 6) ? Optional.of(6) : Optional.of(n);
        } catch (NumberFormatException e) {
            this.numDependentesError.setText("Invalid number");
        } catch (InvalidParameterException e) {
            this.numDependentesError.setText("Can't be negative");
        }
        return Optional.empty();
    }

    private Optional<Integer> getNumDias() {
        try {
            final int n = Integer.parseInt(this.numDias.getText());
            if (n < 0 || n > 31) {
                throw new InvalidParameterException();
            }
            return Optional.of(n);
        } catch (NumberFormatException | InvalidParameterException e) {
            this.numDiasError.setText("Invalid number");
        }
        return Optional.empty();
    }

    private Optional<Integer> getOutrosIsentos() {
        try {
            return Optional.of((int) Math.floor(parseDouble(this.outrosIsentos.getText()) * 100));
        } catch (NumberFormatException e) {
            this.outrosIsentosError.setText("Invalid number");
        }
        return Optional.empty();
    }

    private Optional<Integer> getAbonoParaFalhas() {
        try {
            return Optional.of((int) Math.floor(parseDouble(this.abonoFalhas.getText()) * 100));
        } catch (NumberFormatException e) {
            this.abonoParaFalhasError.setText("Invalid number");
        }
        return Optional.empty();
    }

    private Optional<Integer> getDiuturnidadesNaoIsentas() {
        try {
            return Optional.of((int) Math.floor(parseDouble(this.diuturnidadesNaoIsentas.getText()) * 100));
        } catch (NumberFormatException e) {
            this.diuturnidadesNaoIsentasError.setText("Invalid number");
        }
        return Optional.empty();
    }

    private Optional<Integer> getSubsidioAlim() {
        try {
            return Optional.of((int) Math.floor(parseDouble(this.subsidioAlim.getText()) * 100));
        } catch (NumberFormatException e) {
            this.subsidioAlimError.setText("Invalid number");
        }
        return Optional.empty();
    }

    private Optional<Integer> getOutrosNaoIsentos() {
        try {
            return Optional.of((int) Math.floor(parseDouble(this.outrosNaoIsentos.getText()) * 100));
        } catch (NumberFormatException e) {
            this.outrosNaoIsentosError.setText("Invalid number");
        }
        return Optional.empty();
    }

    private Optional<IRSTables.IRSTableType> getTabelaIRS() {
        Optional<IRSTables.IRSTableType> opt = Optional.ofNullable(this.tabelaIRS.getValue());
        if (!opt.isPresent()) {
            this.tabelaIRSError.setText("Please select one");
        }
        return opt;
    }

    private Optional<Constants.EncargosEEmpregadoraSS> getEncargosEE() {
        Optional<Constants.EncargosEEmpregadoraSS> opt = Optional.ofNullable(this.encargosEE.getValue());
        if (!opt.isPresent()) {
            this.encargosEEError.setText("Please select one");
        }
        return opt;
    }

    private void clearLables() {
        Arrays.stream(new Label[]{salarioBrutoError,
                                  numDependentesError,
                                  numDiasError,
                                  outrosIsentosError,
                                  abonoParaFalhasError,
                                  diuturnidadesNaoIsentasError,
                                  subsidioAlimError,
                                  outrosNaoIsentosError}).forEach(x -> x.setText(""));
    }

    public void calculate() {
        clearLables();
        Optional<Integer> salarioBruto = getSalarioBruto();
        Optional<Integer> numDependentes = getNumDependentes();
        Optional<Integer> numDias = getNumDias();
        Optional<Integer> outrosIsentos = getOutrosIsentos();
        Optional<Integer> abonoFalhas = getAbonoParaFalhas();
        Optional<Integer> diuturnidadesNaoIsentas = getDiuturnidadesNaoIsentas();
        Optional<Integer> subsidioAlim = getSubsidioAlim();
        Optional<Integer> outrosNaoIsentos = getOutrosNaoIsentos();
        Optional<IRSTables.IRSTableType> irsTableType = getTabelaIRS();
        Optional<Constants.EncargosEEmpregadoraSS> encargosEEmpregadoraSS = getEncargosEE();
        boolean emNumerario = this.emNumerario.isSelected();
        try {
            InputData id = new InputData(salarioBruto.orElseThrow(),
                                         numDependentes.orElseThrow(),
                                         numDias.orElseThrow(),
                                         outrosIsentos.orElseThrow(),
                                         irsTableType.orElseThrow(),
                                         abonoFalhas.orElseThrow(),
                                         diuturnidadesNaoIsentas.orElseThrow(),
                                         emNumerario,
                                         subsidioAlim.orElseThrow(),
                                         outrosNaoIsentos.orElseThrow(),
                                         encargosEEmpregadoraSS.orElseThrow());
            output = id.solve();
            clearLables();
            Salarios.redirectTo(SceneLoader.View.OutputWindow);
        } catch (NoSuchElementException ignored) {
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabelaIRS.setItems(FXCollections.observableList(Arrays.asList(IRSTables.IRSTableType.values())));
        encargosEE.setItems(FXCollections.observableList(Arrays.asList(Constants.EncargosEEmpregadoraSS.values())));
    }

    public void exitAll() {
        System.exit(0);
    }
}
