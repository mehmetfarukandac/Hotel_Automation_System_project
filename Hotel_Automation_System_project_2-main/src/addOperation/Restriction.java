package addOperation;

import entity.JavafxEntity;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Restriction extends JavafxEntity{
	//Just To Get Integer Value From TextField
	//Start.

	public void customer() {
		getPhoneinput().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,11}([\\.]\\d{0,4})?")) {
                	getPhoneinput().setText(oldValue);
                }
            }
        });
		getRoomAddinput().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,4}([\\.]\\d{0,4})?")) {
                	getRoomAddinput().setText(oldValue);
                }
            }
        });
		getIdinput().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,11}([\\.]\\d{0,4})?")) {
                	getIdinput().setText(oldValue);
                }
            }
        });
		getRoominput().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,4}([\\.]\\d{0,4})?")) {
                	getRoominput().setText(oldValue);
                }
            }
        });

		//Over
	
	}
}
