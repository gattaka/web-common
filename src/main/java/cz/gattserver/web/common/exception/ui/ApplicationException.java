package cz.gattserver.web.common.exception.ui;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.GregorianCalendar;
import java.util.UUID;

public abstract class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = -1504502969392647247L;

	protected final String id;
	protected final String timeStamp;
	protected final String errorCode;
	protected final String localizedErrorMessage;
	protected final String originalExceptionStackTrace;

	public ApplicationException(String errorCode, String localizedErrorMessage) {
		this(errorCode, localizedErrorMessage, null);
	}

	public ApplicationException(String errorCode, String localizedErrorMessage, Throwable throwable) {
		super(throwable);
		this.id = UUID.randomUUID().toString();
		this.timeStamp = DateFormatUtils.format(GregorianCalendar.getInstance(), "yyyy-MM-dd HH:mm:ss");
		this.errorCode = errorCode;
		this.localizedErrorMessage = localizedErrorMessage;
		this.originalExceptionStackTrace = throwable == null ? null : ExceptionUtils.getStackTrace(throwable);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getId() {
		return id;
	}

	public String getLocalizedErrorMessage() {
		return localizedErrorMessage;
	}

	public String getTimeStamp() {
		return timeStamp;
	}
}
