/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlOutputText;

/**
 * @author root
 *
 */
public class Commentreviewadded extends PageCodeBase {

	protected HtmlOutputText text2;

	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}

}