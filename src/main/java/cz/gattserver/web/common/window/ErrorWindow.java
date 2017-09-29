package cz.gattserver.web.common.window;

import com.vaadin.server.ThemeResource;

import cz.gattserver.web.common.ui.ImageIcons;

public class ErrorWindow extends MessageWindow {

	private static final long serialVersionUID = -4793025663820815400L;

	public ErrorWindow(String labelCaption) {
		super("Problém", labelCaption, new ThemeResource(ImageIcons.DELETE_16_ICON));
	}

}
