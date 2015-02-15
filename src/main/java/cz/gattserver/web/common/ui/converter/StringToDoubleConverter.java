package cz.gattserver.web.common.ui.converter;

import java.text.NumberFormat;
import java.util.Locale;

public class StringToDoubleConverter extends com.vaadin.data.util.converter.StringToDoubleConverter {
	private static final long serialVersionUID = -2914696445291603483L;

	@Override
	protected NumberFormat getFormat(Locale locale) {
		return NumberFormat.getNumberInstance(Locale.forLanguageTag("cs"));
	}

}
