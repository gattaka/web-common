package cz.gattserver.web.common.ui;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;

public class BoldLabel extends Label {

	private static final long serialVersionUID = 7526089060607305886L;

	public BoldLabel(String value) {
		super("<strong>" + value + "</strong>");
		setContentMode(ContentMode.HTML);
		setSizeUndefined();
	}
}
