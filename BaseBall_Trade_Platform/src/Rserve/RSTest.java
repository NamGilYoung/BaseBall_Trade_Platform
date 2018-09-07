package Rserve;

import java.io.IOException;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;

public class RSTest {
	public static void main(String[] args) throws REngineException, REXPMismatchException, IOException {
		RConnection c = new RConnection();
		REXP x = c.eval("R.version.string");
		System.out.println(x.asString());
	}
}
