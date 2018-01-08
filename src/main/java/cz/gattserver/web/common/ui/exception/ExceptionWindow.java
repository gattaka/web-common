package cz.gattserver.web.common.ui.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;

import cz.gattserver.web.common.ui.ImageIcon;
import cz.gattserver.web.common.ui.window.MessageWindow;

public class ExceptionWindow extends MessageWindow {

	private static final long serialVersionUID = -2077736292967107272L;

	public ExceptionWindow(Throwable throwable) {
		super("Chyba", "Neočekávaná systémová chyba", ExceptionUtils.getStackTrace(throwable),
				ImageIcon.DELETE_16_ICON.createResource());
		addStyleName("error-layout");
		detailsArea.addStyleName("error-text-field");
		detailsArea.setHeight("500px");
		setWidth("1200px");
	}

}
