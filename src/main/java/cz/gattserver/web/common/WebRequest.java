package cz.gattserver.web.common;

import java.io.Serializable;

import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.JavaScript;

/**
 * Třída poskytující veškeré informace o requestu od Vaadinu, upravené tak, aby šli snadno používat v objektech stránek
 * 
 * @author gatt
 * 
 */
public class WebRequest implements Serializable {

	private static final long serialVersionUID = -5174886410110466625L;

	private VaadinRequest vaadinRequest;
	private URLPathAnalyzer analyzer;
	private String contextRoot;
	private String currentPage;

	/**
	 * Stav stránky
	 */
	private PageState pageState = PageState.CLEAN;

	public WebRequest(VaadinRequest vaadinRequest) {
		this.vaadinRequest = vaadinRequest;
		this.currentPage = vaadinRequest.getPathInfo();
		this.analyzer = new URLPathAnalyzer(currentPage);
		this.contextRoot = vaadinRequest.getContextPath();
	}

	/**
	 * Nastaví adresu v adresovém řádku dle stránky
	 * 
	 * @param path
	 */
	public void updateURL(String path) {
		String url = getPageURL(path);
		JavaScript.eval("window.history.pushState(\"" + url + "\", \"Title\", \"" + url + "\");");
		currentPage = url;
	}

	/**
	 * Přejde na stránku
	 */
	public void redirect(String uri) {
		Page.getCurrent().setLocation(uri);
	}

	public String getContextRoot() {
		return contextRoot;
	}

	/**
	 * Získá URL stránky. Kořen webu + suffix
	 */
	public String getPageURL(String suffix) {
		return contextRoot + "/" + suffix;
	}

	/**
	 * Přesměruje na členskou stránku
	 */
	public void redirectToPage(String relativeURL) {
		redirect(getPageURL(relativeURL));
	}

	public VaadinRequest getVaadinRequest() {
		return vaadinRequest;
	}

	public URLPathAnalyzer getAnalyzer() {
		return analyzer;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public PageState getPageState() {
		return pageState;
	}

	/**
	 * Nastavuje stav stránky - lze nastavit pouze pokud je čistá, pokud je už u stránky vedena nějaká chyba, další
	 * chyby jí nepřepisují, protože mohou být důsledky první chyby
	 */
	private void setPageState(PageState newState) {
		if (pageState == PageState.CLEAN)
			pageState = newState;
	}

	/**
	 * Vyhodí chybu
	 */
	public void setError500() {
		setPageState(PageState.E500);
	}

	/**
	 * Vyhodí chybu
	 */
	public void setError404() {
		setPageState(PageState.E404);
	}

	/**
	 * Vyhodí chybu
	 */
	public void setError403() {
		setPageState(PageState.E403);
	}

}
