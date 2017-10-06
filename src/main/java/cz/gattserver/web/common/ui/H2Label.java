package cz.gattserver.web.common.ui;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;

public class H2Label extends Label {

	private static final long serialVersionUID = 7366248946391250891L;

	public H2Label() {
	}

	public H2Label(String text) {
		setWidth("100%");
		setContentMode(ContentMode.HTML);
		if (text != null)
			setValue(text);
	}

	@Override
	public void setValue(String text) {
		super.setValue("<h2>" + text + "</h2>");
	}

}
