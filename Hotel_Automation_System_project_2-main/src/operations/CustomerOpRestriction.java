package operations;

import entity.JavafxEntity;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class CustomerOpRestriction extends JavafxEntity{
	//OPERATÝONS EKRANI ÝÇÝN TEXTFÝELDLARA ÖZELLÝK VE KISITLAMA EKLEME ALANI
	public void customerOp() {

		getTfPhone().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,11}([\\.]\\d{0,4})?")) {
                	getTfPhone().setText(oldValue);
                }
            }
        });
		getTfRoom().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,4}([\\.]\\d{0,4})?")) {
                	getTfRoom().setText(oldValue);
                }
            }
        });
		getTfId().textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,11}([\\.]\\d{0,4})?")) {
                	getTfId().setText(oldValue);
                }
            }
        });
	}
}