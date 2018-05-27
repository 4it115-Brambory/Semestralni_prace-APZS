/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package com.github.it115_Brambory.Semestralni_prace_APZS.main;

import com.github.it115_Brambory.Semestralni_prace_APZS.App;
import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.ui.PrehledakciexchangeController;
import com.github.it115_Brambory.Semestralni_prace_APZS.ui.PrihlaseniController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/*******************************************************************************
 * Třída Start je hlavní třídou projektu,
 *
 */
public class Start extends Application {
	/***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
    	if (args.length == 0) {
            launch(args);
        } else {
        	System.out.println("Neplatný parametr");
        }
    }


	
    /**
	 * Metoda, ve které se konstruuje okno, kontroler a buddyAplikace,
	 * která se předává kontroleru
	 */
    	@Override
		public void start (Stage primaryStage) throws Exception {
			FXMLLoader loader = new FXMLLoader();
			//loader.setLocation(this.getClass().getResource("/com/github/it115_Brambory/Semestralni_prace_APZS/ui/MainWindow.fxml"));
			loader.setLocation(this.getClass().getResource("/com/github/it115_Brambory/Semestralni_prace_APZS/ui/prihlaseni.fxml"));
			
	    	Parent root = loader.load();
	
	    	PrihlaseniController controller = loader.getController();
	    	IBuddyAplikace buddyAplikace = new BuddyAplikace();
			controller.inicializuj(buddyAplikace);
	    	
	    	primaryStage.setScene(new Scene(root));
	    	primaryStage.show();
	    	primaryStage.setTitle("Brambory - aplikace");
	    	//primaryStage.setResizable(false);
	    	}
    	
    	
		
    	
    	
}