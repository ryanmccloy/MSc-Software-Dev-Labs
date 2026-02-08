/**
 * 
 */
package saveourplanet;

/**
 * 
 */
public class Dice {

	public void rollDiceAnimation(int result1, int result2) {

		String dice1;
		String dice2;
		
//		String[] faces = {
//		        // 1
//		        "┌───────┐\n" +
//		        "│       │\n" +
//		        "│   ●   │\n" +
//		        "│       │\n" +
//		        "└───────┘\n",
//
//		        // 2
//		        "┌───────┐\n" +
//		        "│ ●     │\n" +
//		        "│       │\n" +
//		        "│     ● │\n" +
//		        "└───────┘\n",
//
//		        // 3
//		        "┌───────┐\n" +
//		        "│ ●     │\n" +
//		        "│   ●   │\n" +
//		        "│     ● │\n" +
//		        "└───────┘\n",
//
//		        // 4
//		        "┌───────┐\n" +
//		        "│ ●   ● │\n" +
//		        "│       │\n" +
//		        "│ ●   ● │\n" +
//		        "└───────┘\n",
//
//		        // 5
//		        "┌───────┐\n" +
//		        "│ ●   ● │\n" +
//		        "│   ●   │\n" +
//		        "│ ●   ● │\n" +
//		        "└───────┘\n"
//		    };
		
		String[] faces = {
		        // 1
		        "\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510\n" +
		        "\u2502       \u2502\n" +
		        "\u2502   \u25CF   \u2502\n" +
		        "\u2502       \u2502\n" +
		        "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518\n",

		        // 2
		        "\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510\n" +
		        "\u2502 \u25CF     \u2502\n" +
		        "\u2502       \u2502\n" +
		        "\u2502     \u25CF \u2502\n" +
		        "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518\n",

		        // 3
		        "\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510\n" +
		        "\u2502 \u25CF     \u2502\n" +
		        "\u2502   \u25CF   \u2502\n" +
		        "\u2502     \u25CF \u2502\n" +
		        "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518\n",

		        // 4
		        "\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510\n" +
		        "\u2502 \u25CF   \u25CF \u2502\n" +
		        "\u2502       \u2502\n" +
		        "\u2502 \u25CF   \u25CF \u2502\n" +
		        "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518\n",

		        // 5
		        "\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510\n" +
		        "\u2502 \u25CF   \u25CF \u2502\n" +
		        "\u2502   \u25CF   \u2502\n" +
		        "\u2502 \u25CF   \u25CF \u2502\n" +
		        "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518\n"
		    };

		try {
			// set UI for dice 1
			switch (result1) {
			case 1:
				dice1 = faces[0];
				break;
			case 2:
				dice1 = faces[1];;
				break;
			case 3:
				dice1 = faces[2];
				break;
			case 4:
				dice1 = faces[3];
				break;
			case 5:
				dice1 = faces[4];
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + result1);
			}

			// set UI for dice 2
			switch (result2) {
			case 1:
				dice2 = faces[0];
				break;
			case 2:
				dice2 = faces[1];
				break;
			case 3:
				dice2 = faces[2];
				break;
			case 4:
				dice2 = faces[3];
				break;
			case 5:
				dice2 = faces[4];
				break;

			default:
				throw new IllegalArgumentException("Unexpected value: " + result1);
			}
			
			
			System.out.println(dice1 + dice2);
			
			System.out.println("You rolled " + (result1 + result2) + "!");
			
			
		} catch (Exception e) {
			System.err.println("Invalid roll!");
		}
		
	

	}
}