package cz.gattserver.web.common.window;

import cz.gattserver.web.common.ui.ImageIcon;

public class InfoWindow extends MessageWindow {

	private static final long serialVersionUID = -4793025663820815400L;

	public InfoWindow(String labelCaption) {
		super("Info", labelCaption, ImageIcon.INFO_16_ICON.createResource());
	}

}
