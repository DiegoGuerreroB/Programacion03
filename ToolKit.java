package models;

public class ToolKit{

	public static final int NUMBER_CHAR = 48;
	public static final int NUMBER_INITIAL = 0;
	public static final int CHAR_POINT = 46;
	public static final int CHAR_SYMBOL = 44;
	private int distanceTotal;


	public int getHoleStreet(String hole){
		int maxHole = NUMBER_INITIAL;
		int counter = NUMBER_INITIAL;	
		for (int i = NUMBER_INITIAL; i < hole.length(); i++) {
			int totalHole = NUMBER_INITIAL;
			if (hole.charAt(i) == CHAR_POINT) {
				counter ++;
				totalHole += counter;
			}else{
				counter = NUMBER_INITIAL;
			}
			if (maxHole < totalHole) {
				maxHole = totalHole;
			}
		}
		return maxHole;
	}

	public String getSumNumber(String number){
		int totalScore = NUMBER_INITIAL;
		String phrase = "";
		int partialScore = NUMBER_INITIAL;
		for (int i = 0; i < number.length(); i += 2 ) {
			if (number.charAt(i) >= 48 && number.charAt(i) <= 57){
				phrase += number.charAt(i);
				partialScore += number.charAt(i) - NUMBER_CHAR;
			}else if (number.charAt(i) == CHAR_SYMBOL) {
				phrase = "";
				partialScore = NUMBER_INITIAL;
			}
			totalScore += partialScore;
		}
		return phrase;
	}
	
		public String getBestStudent(String phrase){
		String bestName = "";
		int higuer = 0;
		String grade = "";
		String name = "";
		boolean isName = true;
		for (int i = 0; i < phrase.length() ; i++) {
			char character = phrase.charAt(i);
			if(isName && character != 44){
				name += character;
			}else if(character >= 48 && character <= 57){
				grade += character;
			}
			if (character == ',') {
				isName = false;
			}else if (character == ';') {
				isName = true;
				int cast = Integer.parseInt(grade);
				if (cast > higuer) {
					bestName = name;
					higuer = cast;
				}
				grade = "";
				name = "";
			}
		}
		return bestName;
	}

	public static void main(String[] args) {
		ToolKit ss = new ToolKit();
		System.out.println("Maximo de huecos seguidos es: " + ss.getHoleStreet("_._...._.-_..-...:-..."));
		System.out.println(ss.getSumNumber("2,1,5"));
		System.out.println(ss.getBestStudent("Diego, 48; Fabio, 34; jose, 21"));
	}
}
