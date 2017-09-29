package cz.gattserver.web.common.window;

import com.vaadin.server.ThemeResource;

import cz.gattserver.web.common.ui.ImageIcons;

public class InfoWindow extends MessageWindow {

	private static final long serialVersionUID = -4793025663820815400L;

	public InfoWindow(String labelCaption) {
		super("Info", labelCaption, new ThemeResource(ImageIcons.INFO_16_ICON));
	}

}
