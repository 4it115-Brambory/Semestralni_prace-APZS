package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import java.util.Observer;

import javax.persistence.Table;
import javafx.event.ActionEvent;
import java.sql.SQLException;
import java.util.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou a logikou - slouží
 * pro načtení přehledu buddy
 * 
 * @author Jan Mandík
 *
 */
public class PrehledakcibuddyController extends Pane implements Observer {

	// zjistit, jak se používá tableview
	private IBuddyAplikace buddyAplikace;
	@FXML
	private Pane thisPane;
	@FXML
	private Button odhlasit;
	@FXML
	private TableView<Table> tableView;
	@FXML
	private TableColumn<Table, String> typ;
	@FXML
	private TableColumn<Table, String> nazev;
	@FXML
	private TableColumn<Table, String> casOd;
	@FXML
	private TableColumn<Table, String> casDo;
	@FXML
	private TableColumn<Table, String> misto;
	@FXML
	private TableColumn<Table, Integer> cena;
	@FXML
	private TextArea prihlasen;

	/**
	 * Metoda k inicializaci hry. Načte všechny potřebné prvky GUI a přidá
	 * observery.
	 * 
	 * @throws SQLException
	 *             - to je kvůli těm testům na konci metody
	 */
	public void inicializuj(IBuddyAplikace buddyAplikace) throws SQLException {
		this.buddyAplikace = buddyAplikace;
		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());
		prihlasen.setEditable(false);

		//nacti data do tabulky
		typ.setCellValueFactory(new PropertyValueFactory("firstName"));
		
		
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

	// odhlašovací metoda, hádám, že bude stačit zabít celou aplikaci
	// -------- a nebo, musi se nastavit aktualniUzivatel v buddyAplikaci na null
	// -------- a vratit se na prihlasovaci okno. Zkusim tuhle cestu, protoze zatim
	// -------- vam zmena okna nikde nefunguje, tak at to pak zkopirujete
	@FXML
	public void odhlasit(ActionEvent event) throws Exception {
		
		this.buddyAplikace.getBuddyAplikace().logOut();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("prihlaseni.fxml"));
		Parent tableViewParent = loader.load();
    	
		Scene tableViewScene = new Scene(tableViewParent);
		
		PrihlaseniController controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
		
	}

}
