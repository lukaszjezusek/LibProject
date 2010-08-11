/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlOutputText;

/**
 * @author root
 *
 */
public class Books3 extends PageCodeBase {

	protected HtmlSelectOneMenu menu1;
	protected HtmlForm form1;
	protected UISelectItems selectItems1;
	protected HtmlOutputText text1;
	protected HtmlSelectOneMenu getMenu1() {
		if (menu1 == null) {
			menu1 = (HtmlSelectOneMenu) findComponentInRoot("menu1");
		}
		return menu1;
	}

	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}

	protected UISelectItems getSelectItems1() {
		if (selectItems1 == null) {
			selectItems1 = (UISelectItems) findComponentInRoot("selectItems1");
		}
		return selectItems1;
	}

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

}