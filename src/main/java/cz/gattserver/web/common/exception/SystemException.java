package cz.gattserver.web.common.exception;

public class SystemException extends ApplicationException {

	private static final long serialVersionUID = -4145772650410085612L;

	public SystemException(String errorMessage) {
		super(errorMessage);
	}

	public SystemException(String errorMessage, Throwable originalException) {
		super(errorMessage, originalException);
	}

	@Override
	public String toString() {
		return "\nSystemException {\n" + "  id:                           " + id + "\n"
				+ "  timestamp:                    " + timeStamp + "\n" + "  localizedErrorMessage:        "
				+ localizedErrorMessage + "\n" + "  originalExceptionStackTrace:  " + "{\n" + "    "
				+ originalExceptionStackTrace + "  }\n" + "}";
	}
}
