package cz.gattserver.web.common.ui.converter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class StringToFixedSizeDoubleConverter extends com.vaadin.data.converter.StringToDoubleConverter {
	private static final long serialVersionUID = -2914696445291603483L;

	private NumberFormat format;

	public StringToFixedSizeDoubleConverter() {
		this(2, 2);
	}

	public StringToFixedSizeDoubleConverter(int minFractionDigits, int maxFractionDigits) {
		super(0.0, "Nezdařilo se převést hodnotu");
		format = new DecimalFormat("#,##0", new DecimalFormatSymbols(new Locale("cs")));
		((DecimalFormat) format).setMaximumFractionDigits(maxFractionDigits);
		((DecimalFormat) format).setMinimumFractionDigits(minFractionDigits);
	}

	public String format(int number) {
		return format.format(number);
	}

	public String format(double number) {
		return format.format(number);
	}

	@Override
	protected NumberFormat getFormat(Locale locale) {
		return format;
	}

}
