package entity;

import java.io.IOException;
import java.util.ArrayList;

public abstract class OperationsWrite {
	//T�m update ve delete durumlar�  writetoFile  imzas�n� OverRiding ediyor
	public abstract void writetoFile(ArrayList<String> list) throws IOException;
}