package cz.gattserver.web.common.ui;

import java.util.ArrayList;
import java.util.List;

import com.fo0.advancedtokenfield.events.TokenRemoveEvent;
import com.fo0.advancedtokenfield.listeners.TokenAddListener;
import com.fo0.advancedtokenfield.listeners.TokenRemoveListener;
import com.fo0.advancedtokenfield.main.AdvancedTokenField;
import com.fo0.advancedtokenfield.main.Token;

/**
 * <p>
 * Vylepšení {@link AdvancedTokenField}, které má v sobě dva zásadní nedostatky.
 * </p>
 * 
 * <p>
 * Prvním je, že listenery, byť jsou přidávány metodou <code>add*</code>, se
 * navzájem přepisují, nepřidávají (mělo by se to jmenovat <code>set*</code>
 * </p>
 * 
 * <p>
 * Druhý nedostatek je, že listenery se volají před samotným efektem akce, na
 * kterou jsou zavěšeny. V důsledku se tak například listener na přidání
 * elementu provede předtím, než je element do tokenFieldu přidán, což
 * komplikuje provádění operací, které jsou na této události zavěšené.
 * </p>
 * 
 * <p>
 * Přidáno v rámci {@link AdvancedTokenField} verze 0.0.63
 * </p>
 * 
 * @author Hynek
 *
 */
public class TokenField extends AdvancedTokenField {
	private static final long serialVersionUID = -4296812397643808604L;

	private List<TokenRemoveListener> myTokenRemoveListenerList = new ArrayList<>();;
	private List<TokenAddListener> myTokenAddListenerList = new ArrayList<>();;

	public TokenField() {
		super();
		getInputField().addValueChangeListener(e -> {
			if (e.getValue() != null)
				addToken(e.getValue());
		});
	}

	@Override
	public void addTokenRemoveListener(TokenRemoveListener listener) {
		myTokenRemoveListenerList.add(listener);
	}

	@Override
	public void addTokenAddListener(TokenAddListener listener) {
		myTokenAddListenerList.add(listener);
	}

	@Override
	public void addToken(Token token) {
		super.addToken(token);
		myTokenAddListenerList.forEach(listener -> listener.action(token));
	}

	@Override
	public void removeTokenFromLayout(TokenRemoveEvent event) {
		super.removeTokenFromLayout(event);
		myTokenRemoveListenerList.forEach(listener -> listener.action(event));
	}

}
