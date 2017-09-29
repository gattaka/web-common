package cz.gattserver.web.common.ui.converter;

import com.vaadin.data.Converter;
import com.vaadin.data.Result;
import com.vaadin.data.ValueContext;

import cz.gattserver.common.util.StringPreviewCreator;

public class StringToPreviewConverter implements Converter<String, String> {

	private static final long serialVersionUID = -5333583811109685442L;

	private int previewLength;

	public StringToPreviewConverter(int previewLength) {
		this.previewLength = previewLength;
	}

	@Override
	public Result<String> convertToModel(String value, ValueContext context) {
		return Result.ok(value);
	}

	@Override
	public String convertToPresentation(String value, ValueContext context) {
		return StringPreviewCreator.createPreview(value, previewLength);
	}

}
