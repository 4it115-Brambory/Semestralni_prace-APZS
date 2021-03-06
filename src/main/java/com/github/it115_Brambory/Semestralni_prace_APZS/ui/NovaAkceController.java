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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou a logikou - slouží
 * pro načtení detailu buddyho
 * 
 * @author Samuel Koyš
 *
 */
public class NovaAkceController extends Pane implements Observer {

	private IBuddyAplikace buddyAplikace;
	@FXML
	private TextField nazev;
	@FXML
	private TextField cena;
	@FXML
	private TextField typ;
	@FXML
	private TextField casOd;
	@FXML
	private TextField casDo;
	@FXML
	private TextField maxUcast;
	@FXML
	private TextField misto;
	@FXML
	private TextField popis;

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
		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());

		this.buddyAplikace = buddyAplikace;
		prihlasen.setEditable(false);
		

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

	
	public void uloz() throws SQLException {
		buddyAplikace.getBuddyAplikace().getDatabazeOperace().insertNovaAkce(typ.getText(),nazev.getText(),casOd.getText(),
				casDo.getText(), misto.getText(), popis.getText(), Integer.parseInt(cena.getText()), Integer.parseInt(maxUcast.getText()));
		 

	}
	

}
