/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlOutputText;

/**
 * @author root
 *
 */
public class Bookreview extends PageCodeBase {

	protected HtmlOutputText text1;
	protected HtmlOutputText text2;
	protected HtmlOutputText text3;

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
	}

}