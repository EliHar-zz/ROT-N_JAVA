/**
 * This class runs the logic of the GUI
 * @author Elias Haroun 6241824  
 *
 */

import javax.swing.*;
import java.awt.*;

public class Logic {
	
	private static boolean isPressed = false; // checks if go button was pressed 


	
	public static boolean isPressed() {
		return isPressed;
	}



	public static void setPressed(boolean isPressed) {
		Logic.isPressed = isPressed;
	}



	/**
	 * This method takes the following parameters:
	 * @param scrollBeforeText The scrollbar of the beforeText text area
	 * @param scrollAfterText  The scrollbar of the afterText text area
	 * @param afterText  Text are of the original text
	 * @param beforeText  Text area of the processed text
	 * @param bg1  ButtonGroup for the radiobuttons
	 * @param combo  Jcombobox of the crypto type
	 * @param digitsCheck  JCheckBox of the process digits
	 */
	public static void appLogic (JScrollPane scrollBeforeText, JScrollPane scrollAfterText, JTextArea afterText, JTextArea beforeText, 
			ButtonGroup bg1, JComboBox combo, JCheckBox digitsCheck){

		// Sync Scroll bars
		scrollBeforeText.getVerticalScrollBar().setModel(scrollAfterText.getVerticalScrollBar().getModel());

		String text = beforeText.getText();

		char [] myChars = text.toCharArray();

		String newText;

		if (bg1.getSelection().getActionCommand().equals("encrypt")){

			switch (combo.getSelectedIndex()) {

			case 1: 
				for (int i = 0; i<myChars.length; i++){
					if (myChars[i] >= 'A' && myChars[i] <= 'Z')
						if ((myChars[i] + 5) > 'Z')
							myChars[i] = (char) ('A'+ 5 - ('Z' - myChars[i]) - 1);
						else
							myChars[i] += 5;
					else if (myChars[i] >= 'a' && myChars[i] <= 'z')
						if ((myChars[i] + 5) > 'z')
							myChars[i] = (char) ('a'+ 5 - ('z' - myChars[i]) - 1);
						else
							myChars[i] += 5;
					else if (digitsCheck.isSelected() == true && myChars[i] >= '0' && myChars[i] <= '9')
						if ((myChars[i] + 5) > '9')
							myChars[i] = (char) ('0'+ 5 - ('9' - myChars[i]) - 1);
						else
							myChars[i] += 5;
				}
				isPressed = true;
				break;
			case 2:
				for (int i = 0; i<myChars.length; i++){
					if (myChars[i] >= 'A' && myChars[i] <= 'Z')
						if ((myChars[i] + 7) > 'Z')
							myChars[i] = (char) ('A'+ 7 - ('Z' - myChars[i]) - 1);
						else
							myChars[i] += 7;
					else if (myChars[i] >= 'a' && myChars[i] <= 'z')
						if ((myChars[i] + 7) > 'z')
							myChars[i] = (char) ('a'+ 7 - ('z' - myChars[i]) - 1);
						else
							myChars[i] += 7;
					else if (digitsCheck.isSelected() == true && myChars[i] >= '0' && myChars[i] <= '9')
						if ((myChars[i] + 7) > '9')
							myChars[i] = (char) ('0'+ 7 - ('9' - myChars[i]) - 1);
						else
							myChars[i] += 7;
				}
				isPressed = true;
				break;
			case 3:
				for (int i = 0; i<myChars.length; i++){
					if (myChars[i] >= 'A' && myChars[i] <= 'Z')
						if ((myChars[i] + 13) > 'Z')
							myChars[i] = (char) ('A'+ 13 - ('Z' - myChars[i]) - 1);
						else
							myChars[i] += 13;
					else if (myChars[i] >= 'a' && myChars[i] <= 'z')
						if ((myChars[i] + 13) > 'z')
							myChars[i] = (char) ('a'+ 13 - ('z' - myChars[i]) - 1);
						else
							myChars[i] += 13;
					else if (digitsCheck.isSelected() == true && myChars[i] >= '0' && myChars[i] <= '9')
						if ((myChars[i] + 3) > '9')
							myChars[i] = (char) ('0'+ 3 - ('9' - myChars[i]) - 1);
						else
							myChars[i] += 3;
				}
				isPressed = true;
				break;
			case 4:
				for (int i = 0; i<myChars.length; i++){
					if (myChars[i] >= 'A' && myChars[i] <= 'Z')
						if ((myChars[i] + 17) > 'Z')
							myChars[i] = (char) ('A'+ 17 - ('Z' - myChars[i]) - 1);
						else
							myChars[i] += 17;
					else if (myChars[i] >= 'a' && myChars[i] <= 'z')
						if ((myChars[i] + 17) > 'z')
							myChars[i] = (char) ('a'+ 17 - ('z' - myChars[i]) - 1);
						else
							myChars[i] += 17;
					else if (digitsCheck.isSelected() && myChars[i] >= '0' && myChars[i] <= '9')
						if ((myChars[i] + 7) > '9')
							myChars[i] = (char) ('0'+ 7 - ('9' - myChars[i]) - 1);
						else
							myChars[i] += 7;
				}
				isPressed = true;
				break;
			}

		} else if (bg1.getSelection().getActionCommand().equals("decrypt")) {

			switch (combo.getSelectedIndex()) {

			case 1: 
				for (int i = 0; i<myChars.length; i++){

					if (myChars[i] >= 'A' && myChars[i] <= 'Z')
						if ((myChars[i] - 5) < 'A')
							myChars[i] = (char) ('Z'- 5 + (myChars[i] - 'A') + 1);
						else
							myChars[i] -= 5;
					else if (myChars[i] >= 'a' && myChars[i] <= 'z')
						if ((myChars[i] - 5) < 'a')
							myChars[i] = (char) ('z'- 5 + (myChars[i] - 'a') + 1);
						else
							myChars[i] -= 5;
					else if (digitsCheck.isSelected() == true && myChars[i] >= '0' && myChars[i] <= '9')
						if ((myChars[i] - 5) < '0')
							myChars[i] = (char) ('9'- 5 + (myChars[i] - '0') + 1);
						else
							myChars[i] -= 5;
				}
				isPressed = true;
				break;
			case 2:
				for (int i = 0; i<myChars.length; i++){
					if (myChars[i] >= 'A' && myChars[i] <= 'Z')
						if ((myChars[i] - 7) < 'A')
							myChars[i] = (char) ('Z'- 7 + (myChars[i] - 'A') + 1);
						else
							myChars[i] -= 7;
					else if (myChars[i] >= 'a' && myChars[i] <= 'z')
						if ((myChars[i] - 7) < 'a')
							myChars[i] = (char) ('z'- 7 + (myChars[i] - 'a') + 1);
						else
							myChars[i] -= 7;
					else if (digitsCheck.isSelected() == true && myChars[i] >= '0' && myChars[i] <= '9')
						if ((myChars[i] - 7) < '0')
							myChars[i] = (char) ('9'- 7 + (myChars[i] - '0') + 1);
						else
							myChars[i] -= 7;
				}
				isPressed = true;
				break;
			case 3:
				for (int i = 0; i<myChars.length; i++){
					if (myChars[i] >= 'A' && myChars[i] <= 'Z')
						if ((myChars[i] - 13) < 'A')
							myChars[i] = (char) ('Z'- 13 + (myChars[i] - 'A') + 1);
						else
							myChars[i] -= 13;
					else if (myChars[i] >= 'a' && myChars[i] <= 'z')
						if ((myChars[i] - 13) < 'a')
							myChars[i] = (char) ('z'- 13 + (myChars[i] - 'a') + 1);
						else
							myChars[i] -= 13;
					else if (digitsCheck.isSelected() == true && myChars[i] >= '0' && myChars[i] <= '9')
						if ((myChars[i] - 3) < '0')
							myChars[i] = (char) ('9'- 3 + (myChars[i] - '0') + 1);
						else
							myChars[i] -= 3;
				}
				isPressed = true;
				break;
			case 4:
				for (int i = 0; i<myChars.length; i++){
					if (myChars[i] >= 'A' && myChars[i] <= 'Z')
						if ((myChars[i] - 17) < 'A')
							myChars[i] = (char) ('Z'- 17 + (myChars[i] - 'A') + 1);
						else
							myChars[i] -= 17;
					else if (myChars[i] >= 'a' && myChars[i] <= 'z')
						if ((myChars[i] - 17) < 'a')
							myChars[i] = (char) ('z'- 17 + (myChars[i] - 'a') + 1);
						else
							myChars[i] -= 17;
					else if (digitsCheck.isSelected() == true && myChars[i] >= '0' && myChars[i] <= '9')
						if ((myChars[i] - 7) < '0')
							myChars[i] = (char) ('9'- 7 + (myChars[i] - '0') + 1);
						else
							myChars[i] -= 7;
				}
				isPressed = true;
				break;
			}
		}

		if(combo.getSelectedIndex() != 0) {
			newText = new String(myChars);
			afterText.setText(newText);
		}

	}
}