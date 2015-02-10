package cz.gattserver.web.common.util;

public class StringPreviewCreator {

	private StringPreviewCreator() {
	}

	public static String createPreview(String text, int previewLength) {
		if (text.length() > previewLength && text.length() > 3)
			return text.substring(0, previewLength - 3) + "...";
		else
			return text;
	}
}
