package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;

import java.util.Observer;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou a logikou - slouží
 * pro načtení přehledu buddy
 * 
 * @author Samuel Koyš, Libor Zíka
 *
 */
public class PrehledZadostiController extends Pane implements Observer {
	// zjistit, jak se používá tableview
	private IBuddyAplikace buddyAplikace;
	@FXML
	private TableColumn<TableViewRequest, Integer> id;
	@FXML
	private TableColumn<TableViewRequest, String> jmeno;
	@FXML
	private TableColumn<TableViewRequest, String> prijmeni;
	@FXML
	private TableColumn<TableViewRequest, String> telefon;
	@FXML
	private TableColumn<TableViewRequest, String> stat;
	@FXML
	private TableColumn<TableViewRequest, String> datumNarozeni;
	@FXML
	private TableColumn<TableViewRequest, String> nazevAkce;
	@FXML
	private TableColumn<TableViewRequest, Integer> prihlasenych;
	@FXML
	private TableColumn<TableViewRequest, Integer> maxUcast;
	@FXML
	private TableColumn<TableViewRequest, String> zaplaceno;
	@FXML
	private TableColumn<TableViewRequest, String> schvaleno;
	@FXML
	private TableView<TableViewRequest> myTable;
	@FXML
	private TextArea prihlasen;
	@FXML
	private ListView<Request> seznamRequestu;

	/**
	 * Metoda k inicializaci hry. Načte všechny potřebné prvky GUI a přidá
	 * observery.
	 * 
	 * @throws SQLException
	 *             - to je kvůli těm testům na konci metody
	 */
	public void inicializuj(IBuddyAplikace buddyAplikace) throws SQLException {
		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());

		this.buddyAplikace = buddyAplikace;
		prihlasen.setEditable(false);

		// seznamRequestu.getItems().addAll(buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamRequestuKolekce());
		// buddyAplikace.getBuddyAplikace().getDatabazeOperace().addObserver(this);
		final ObservableList<TableViewRequest> dataTabulka = FXCollections.observableArrayList();

		Map<Integer, TableViewRequest> vyber = new HashMap<Integer, TableViewRequest>();
		vyber = this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamTableViewRequestu();
		for (Map.Entry<Integer, TableViewRequest> entry : vyber.entrySet()) {
			TableViewRequest jeden = new TableViewRequest(entry.getValue().getJmeno(), entry.getValue().getPrijmeni(),
					entry.getValue().getTelefon(), entry.getValue().getStat(), entry.getValue().getDatumNarozeni(),
					entry.getValue().getNazevAkce(), entry.getValue().getPrihlasenych(), entry.getValue().getMaxUcast(),
					entry.getValue().getId(), entry.getValue().getZaplaceno(), entry.getValue().getSchvaleno());
			dataTabulka.add(jeden);
		}

		jmeno.setCellValueFactory(new PropertyValueFactory<TableViewRequest, String>("jmeno"));
		prijmeni.setCellValueFactory(new PropertyValueFactory<TableViewRequest, String>("prijmeni"));
		telefon.setCellValueFactory(new PropertyValueFactory<TableViewRequest, String>("telefon"));
		stat.setCellValueFactory(new PropertyValueFactory<TableViewRequest, String>("stat"));
		datumNarozeni.setCellValueFactory(new PropertyValueFactory<TableViewRequest, String>("datumNarozeni"));
		nazevAkce.setCellValueFactory(new PropertyValueFactory<TableViewRequest, String>("nazevAkce"));
		prihlasenych.setCellValueFactory(new PropertyValueFactory<TableViewRequest, Integer>("prihlasenych"));
		maxUcast.setCellValueFactory(new PropertyValueFactory<TableViewRequest, Integer>("maxUcast"));
		id.setCellValueFactory(new PropertyValueFactory<TableViewRequest, Integer>("id"));
		zaplaceno.setCellValueFactory(new PropertyValueFactory<TableViewRequest, String>("zaplaceno"));
		schvaleno.setCellValueFactory(new PropertyValueFactory<TableViewRequest, String>("schvaleno"));

		myTable.setItems(dataTabulka);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

	@FXML
	private void scenePrehledAkci(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledAkciProAdmina.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);

		PrehledAkciProAdminaController controller = loader.getController();
		controller.inicializuj(buddyAplikace);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	@FXML
	private void scenePrehledCeskych(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledBuddyStudentuProAdmina.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);

		PrehledBuddyStudentuController controller = loader.getController();
		controller.inicializuj(buddyAplikace);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	@FXML
	private void scenePrehledZadosti(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledZadostiProAdmina.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);

		PrehledZadostiController controller = loader.getController();
		controller.inicializuj(buddyAplikace);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	@FXML
	private void scenePrehledZahranicnich(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledExchangeStudentuProAdmina.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);

		PrehledExchangeStudentuController controller = loader.getController();
		controller.inicializuj(buddyAplikace);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	/**
	 * Matoda na odhlášení uživatele po kliknutí na tlačítko "odhlásit". Aktuální
	 * uživatel se nastaví na null a scéna se změní na přihlášení.
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void odhlasit(ActionEvent event) throws Exception {

		this.buddyAplikace.getBuddyAplikace().logOut();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("Prihlaseni.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);

		PrihlaseniController controller = loader.getController();
		controller.inicializuj(buddyAplikace);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();

	}

	// ToDo: Metoda pro schválení žádosti
	@FXML
	private void schvaleni(ActionEvent event) throws Exception {
		TableViewRequest selectedRequest = myTable.getSelectionModel().getSelectedItem();
		// schvalit jen to co u ceho je ---
		if (selectedRequest != null) {
			if (selectedRequest.getSchvaleno() == "---") {
				this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().setRequestSchvaleno(selectedRequest.getId());
				scenePrehledZadosti(event);
			} else if (selectedRequest.getSchvaleno() == "ano") {
				ukazAlertGood("Žádost byla již schválena.");
			} else if (selectedRequest.getSchvaleno() == "ne") {
				this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().setRequestSchvaleno(selectedRequest.getId());
				scenePrehledZadosti(event);
			}
		} else
			ukazAlertGood("Označte žádost.");
	}

	/**
	 * Metoda ukáže modální okno s upozorněním
	 */
	public void ukazAlertGood(String text) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Upozornění");
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
	}

	// ToDo: Metoda pro zamitnuti žádosti
	@FXML
	private void odmitnuti(ActionEvent event) throws Exception {
		TableViewRequest selectedRequest = myTable.getSelectionModel().getSelectedItem();
		// zamitnout jen to co u ceho je ---
		if (selectedRequest != null) {
			if (selectedRequest.getSchvaleno() == "---") {
				this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().setRequestZamitnuto(selectedRequest.getId());
				scenePrehledZadosti(event);
			} else if (selectedRequest.getSchvaleno() == "ne") {
				ukazAlertGood("Žádost byla již zamítnuta.");
			} else if (selectedRequest.getSchvaleno() == "ano" && selectedRequest.getZaplaceno() == "ne") {
				this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().setRequestZamitnuto(selectedRequest.getId());
				scenePrehledZadosti(event);
			} else if (selectedRequest.getSchvaleno() == "ano" && selectedRequest.getZaplaceno() == "ano") {
				ukazAlertGood("Nelze zamítnout již zaplacenou žádost.");
			}
		} else
			ukazAlertGood("Označte žádost.");
	}

	// ToDo: Metoda pro nastavení zaplacení žádosti
	@FXML
	private void zaplaceni(ActionEvent event) throws Exception {
		// jen pokud je ve schvaleno ano a zaplaceno uz neni nastaveno
		TableViewRequest selectedRequest = myTable.getSelectionModel().getSelectedItem();
		if (selectedRequest != null) {
			if (selectedRequest.getSchvaleno() != "ano") {
				ukazAlertGood("Žádost lze označit jako zaplacenou jen pokud je schválená.");
			} else if (selectedRequest.getSchvaleno() == "ano" && selectedRequest.getZaplaceno() == "ano") {
				ukazAlertGood("Žádost byla již označena za zaplacenou.");
			} else if (selectedRequest.getSchvaleno() == "ano" && selectedRequest.getZaplaceno() == "ne") {
				this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().setRequestZaplaceno(selectedRequest.getId());
				scenePrehledZadosti(event);
			}
		} else
			ukazAlertGood("Označte žádost.");
	}
}
