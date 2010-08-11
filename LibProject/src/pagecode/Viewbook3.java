/**
 * 
 */
package pagecode;

import javax.faces.component.html.HtmlOutputText;

/**
 * @author root
 *
 */
public class Viewbook3 extends PageCodeBase {

	protected HtmlOutputText text1;

	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}

}