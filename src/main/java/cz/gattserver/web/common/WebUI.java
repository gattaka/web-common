package cz.gattserver.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;

import cz.gattserver.web.common.exception.ApplicationErrorHandler;

public abstract class WebUI extends UI {

	private static final long serialVersionUID = -785347532002801786L;
	private static Logger logger = LoggerFactory.getLogger(WebUI.class);

	public WebUI() {
		SpringContextHelper.inject(this);
	}

	public void init(VaadinRequest request) {

		VaadinSession.getCurrent().setErrorHandler(new ApplicationErrorHandler());

		String path = request.getPathInfo();
		String contextPath = request.getContextPath();
		logger.info("Context Path: [" + contextPath + "]");
		logger.info("Path: [" + path + "]");

		WebRequest webRequest = new WebRequest(request);

		Layout content = createPageByPath(webRequest);

		PageState state = webRequest.getPageState();
		if (PageState.CLEAN.equals(state)) {
			setContent(content);
		} else {
			showError(state);
		}

	}

	protected abstract void showError(PageState state);

	protected abstract Layout createPageByPath(WebRequest webRequest);
}
