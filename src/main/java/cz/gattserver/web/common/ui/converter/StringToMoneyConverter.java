package cz.gattserver.web.common.ui.converter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class StringToMoneyConverter extends StringToDoubleConverter {
	private static final long serialVersionUID = -2914696445291603483L;

	private NumberFormat priceFormat;

	public StringToMoneyConverter() {
		this(2, 2);
	}

	public StringToMoneyConverter(int minFractionDigits, int maxFractionDigits) {
		priceFormat = NumberFormat.getCurrencyInstance(new Locale("cs", "CZ"));
		((DecimalFormat) priceFormat).setMaximumFractionDigits(maxFractionDigits);
		((DecimalFormat) priceFormat).setMinimumFractionDigits(minFractionDigits);
	}

	public String format(int price) {
		return priceFormat.format(price);
	}

	public String format(double price) {
		return priceFormat.format(price);
	}

	@Override
	protected NumberFormat getFormat(Locale locale) {
		return priceFormat;
	}

}
