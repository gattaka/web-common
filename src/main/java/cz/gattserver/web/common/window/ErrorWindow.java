package cz.gattserver.web.common.window;

import cz.gattserver.web.common.ui.ImageIcon;

public class ErrorWindow extends MessageWindow {

	private static final long serialVersionUID = -4793025663820815400L;

	public ErrorWindow(String labelCaption) {
		super("Problém", labelCaption, ImageIcon.DELETE_16_ICON.createResource());
	}

}
