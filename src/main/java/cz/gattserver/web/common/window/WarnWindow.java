package cz.gattserver.web.common.window;

import com.vaadin.server.ThemeResource;

import cz.gattserver.web.common.ui.ImageIcons;

public class WarnWindow extends MessageWindow {

	private static final long serialVersionUID = -4793025663820815400L;

	public WarnWindow(String labelCaption) {
		super("Varování", labelCaption, new ThemeResource(ImageIcons.WARNING_16_ICON));
	}

}
