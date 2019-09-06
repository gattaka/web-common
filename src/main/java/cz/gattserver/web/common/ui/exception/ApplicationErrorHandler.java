package cz.gattserver.web.common.ui.exception;

import cz.gattserver.web.common.exception.SystemException;
import cz.gattserver.web.common.ui.exception.ExceptionDialog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.ErrorEvent;
import com.vaadin.flow.server.ErrorHandler;

public class ApplicationErrorHandler implements ErrorHandler {

	private static final long serialVersionUID = -7739910142600177544L;

	private static final Logger logger = LoggerFactory.getLogger(ApplicationErrorHandler.class);

	public void error(ErrorEvent event) {
		error(event.getThrowable());
	}

	public void error(Throwable throwable) {
		String log = new SystemException("V aplikaci došlo k neočekávané chybě", throwable).toString();
		logger.error(log);
		UI ui = UI.getCurrent();
		if (ui != null)
			ui.add(new ExceptionDialog(throwable));
	}

}
