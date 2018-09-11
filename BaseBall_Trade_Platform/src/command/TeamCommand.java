package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TeamCommand {
	public void exevute(HttpServletRequest request, HttpServletResponse response);
}
