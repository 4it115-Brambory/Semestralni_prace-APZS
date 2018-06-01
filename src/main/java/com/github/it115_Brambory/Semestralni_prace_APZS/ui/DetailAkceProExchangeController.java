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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
public class DetailAkceProExchangeController extends Pane implements Observer {

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
	private TextField misto;
	@FXML
	private TextField popis;
	@FXML
	private TextField casDo;
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
		nazev.setEditable(false);
		cena.setText(String.valueOf(detailAkce.getCena()));
		cena.setEditable(false);
		typ.setText(detailAkce.getTypAkce());
		typ.setEditable(false);
		casOd.setText(detailAkce.getCasOd());
		casOd.setEditable(false);
		popis.setText(detailAkce.getPopis());
		popis.setEditable(false);
		casDo.setText(detailAkce.getCasDo());
		casDo.setEditable(false);
		misto.setText(detailAkce.getMisto());
		misto.setEditable(false);
		maxUcast.setText(String.valueOf(detailAkce.getMaxUcast()));
		maxUcast.setEditable(false);
	}

	@FXML
	public void podejZadostOPrihlaseni() throws SQLException {

		int exchange_id = this.buddyAplikace.getBuddyAplikace().getDatabazeOperace()
				.zjistiExchangeIdPodlemailu(this.buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());

		if (this.buddyAplikace.getBuddyAplikace().getDatabazeOperace()
				.zjistiObsazenaAkceProExchange(detailAkce.getAkceId())) {
			ukazAlertBad("Akce je již plně obsazena.");
		} else if (this.buddyAplikace.getBuddyAplikace().getDatabazeOperace()
				.zjistiExistujiciRequestProExchange(detailAkce.getAkceId(), exchange_id)) {
			ukazAlertBad("Žádost na tuto akci již byla podána.");
		} else {
			this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().insertNovyRequest(detailAkce.getAkceId(),
					exchange_id);
			ukazAlertGood("Žádost o přihlášení byla podána.");
		}
	}

	/**
	 * Metoda ukáže modální okno s upozorněním
	 */
	public void ukazAlertGood(String text) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Upozornění");
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
	}

	public void ukazAlertBad(String text) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Upozornění");
		alert.setHeaderText(null);
		alert.setContentText(text);
		alert.showAndWait();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

}
