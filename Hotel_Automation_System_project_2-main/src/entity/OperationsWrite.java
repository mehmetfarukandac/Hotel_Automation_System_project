package entity;

import java.io.IOException;
import java.util.ArrayList;

public abstract class OperationsWrite {
	//Tüm update ve delete durumlarý  writetoFile  imzasýný OverRiding ediyor
	public abstract void writetoFile(ArrayList<String> list) throws IOException;
}