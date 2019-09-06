package cz.gattserver.web.common.ui.window;

import cz.gattserver.web.common.ui.ImageIcon;

public class WarnWindow extends MessageDialog {

	private static final long serialVersionUID = -4793025663820815400L;

	public WarnWindow(String labelCaption) {
		this(labelCaption, null);
	}

	public WarnWindow(String labelCaption, String details) {
		super(labelCaption, details, ImageIcon.WARNING_16_ICON.createResource());
	}

}
