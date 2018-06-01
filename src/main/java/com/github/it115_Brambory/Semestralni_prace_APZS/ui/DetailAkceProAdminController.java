package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.main.Start;

import java.util.Observer;

import java.sql.SQLException;
import java.util.Observable;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou a logikou - slouží
 * pro načtení detailu buddyho
 * 
 * @author Jan Mandík
 *
 */
public class DetailAkceProAdminController extends Pane implements Observer {

	private IBuddyAplikace buddyAplikace;
	private Akce detailAkce;
	@FXML
	private TextField nazev;
	@FXML
	private TextField cena;
	@FXML
	private TextField typ;
	@FXML
	private TextField casOd;
	@FXML
	private TextField popis;
	@FXML
	private TextField casDo;
	@FXML
	private TextField misto;
	@FXML
	private TextField maxUcast;

	@FXML
	private TextArea prihlasen;
	
	/**
	 * Metoda k inicializaci hry. Načte všechny potřebné prvky GUI a přidá
	 * observery.
	 * 
	 * @throws SQLException
	 *             - to je kvůli těm testům na konci metody
	 */
	public void inicializuj(IBuddyAplikace buddyAplikace, Akce vybranaAkce) throws SQLException {
		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());

		this.buddyAplikace = buddyAplikace;
		prihlasen.setEditable(false);
		detailAkce = vybranaAkce;
		nazev.setText(detailAkce.getNazev());
		cena.setText( String.valueOf(detailAkce.getCena()));
		typ.setText(detailAkce.getTypAkce());
		casOd.setText(detailAkce.getCasOd());
		popis.setText(detailAkce.getPopis());
		casDo.setText(detailAkce.getCasDo());
		misto.setText(detailAkce.getMisto());
		maxUcast.setText(String.valueOf(detailAkce.getMaxUcast()));


	}

	@FXML	
	private void sceneZpetNaPrehledAkci (ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledAkciProAdmina.fxml"));
		Parent tableViewParent = loader.load();
    	
		Scene tableViewScene = new Scene(tableViewParent);
		
		PrehledAkciProAdminaController controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

	
	
	public void uloz() throws SQLException {
		buddyAplikace.getBuddyAplikace().getDatabazeOperace().updateAkci(detailAkce.getAkceId(), typ.getText(),
				nazev.getText(), casOd.getText(), casDo.getText(), misto.getText(),
				popis.getText(), Integer.parseInt(cena.getText()), Integer.parseInt(maxUcast.getText()));

	}
	
	public void odstran() throws SQLException {
		buddyAplikace.getBuddyAplikace().getDatabazeOperace().deleteAkce(detailAkce.getAkceId());
		Stage curretStage = (Stage) nazev.getScene().getWindow();
		curretStage.close();
	}

}
