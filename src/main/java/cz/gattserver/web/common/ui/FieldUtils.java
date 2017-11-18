package cz.gattserver.web.common.ui;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;
import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.server.UserError;
import com.vaadin.ui.AbstractField;
import com.vaadin.ui.TextField;

public class FieldUtils {

	public static String formatMoney(BigDecimal money) {
		if (money == null)
			return null;
		NumberFormat priceFormat = NumberFormat.getCurrencyInstance(new Locale("cs", "CZ"));
		((DecimalFormat) priceFormat).setMaximumFractionDigits(2);
		((DecimalFormat) priceFormat).setMinimumFractionDigits(2);
		return priceFormat.format(money);
	}

	public static <T> void addValidator(AbstractField<T> field, Validator<T> validator) {
		field.addValueChangeListener(event -> {
			ValidationResult result = validator.apply(event.getValue(), new ValueContext(field));

			if (result.isError()) {
				UserError error = new UserError(result.getErrorMessage());
				field.setComponentError(error);
			} else {
				field.setComponentError(null);
			}
		});
	}

	public static void addValidator(TextField field, IntegerRangeValidator validator) {
		field.addValueChangeListener(event -> {
			Integer val = null;
			try {
				Integer.parseInt(event.getValue());
			} catch (NumberFormatException e) {
				UserError error = new UserError("Hodnota není celé číslo");
				field.setComponentError(error);
				return;
			}

			ValidationResult result = validator.apply(val, new ValueContext(field));

			if (result.isError()) {
				UserError error = new UserError(result.getErrorMessage());
				field.setComponentError(error);
			} else {
				field.setComponentError(null);
			}
		});
	}

}