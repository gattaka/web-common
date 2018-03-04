package cz.gattserver.web.common.ui;

import org.apache.commons.lang3.StringUtils;

import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Label;

public class H2Label extends Label {

	private static final long serialVersionUID = 7366248946391250891L;

	public H2Label() {
		this(null);
	}

	public H2Label(String text) {
		setWidth("100%");
		setValue(text);
		setContentMode(ContentMode.HTML);
	}

	@Override
	public void setValue(String text) {
		if (StringUtils.isNotBlank(text))
			super.setValue("<h2>" + text + "</h2>");
		else
			super.setValue(null);
	}

}
