package com.github.it115_Brambory.Semestralni_prace_APZS.ui;


import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.Akce;
import com.github.it115_Brambory.Semestralni_prace_APZS.logika.IBuddyAplikace;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou a logikou - slouží
 * pro načtení detailu buddyho
 * 
 * @author Jan Mandík
 *
 */
public class DetailAkceProBuddyController extends Pane implements Observer {

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
	private TextField misto;
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
		cena.setText( String.valueOf(detailAkce.getCena()));
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

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}



}
