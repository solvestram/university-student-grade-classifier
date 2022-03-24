public class Grade {
	private final int points;

	public int getPoints() {
		return points;
	}

	public Grade(int p) throws IllegalArgumentException {
		if(p<1 || p>20) 
			throw new IllegalArgumentException();
		points = p;
	}
	
	// Your additions/changes below this line

	public Classification classify() {
		if (points >= 1 && points <= 4) {
			return Classification.First;
		}
		
		if (points >= 5 && points <= 8) {
			return Classification.UpperSecond;
		}
		
		if (points >= 9 && points <= 12) {
			return Classification.LowerSecond;
		}
		
		if (points >= 13 && points <= 16) {
			return Classification.Third;
		}
		
		return Classification.Fail;
	}
	
	public static Grade fromPercentage(int g) throws IllegalArgumentException {		
		if (g >= 79 && g <= 100) {
			return new Grade(1);
		}
		
		if (g >= 76 && g <= 78) {
			return new Grade(2);
		}
		
		if (g >= 73 && g <= 75) {
			return new Grade(3);
		}
		
		if (g >= 70 && g <= 72) {
			return new Grade(4);
		}
		
		if (g >= 67 && g <= 69) {
			return new Grade(5);
		}
		
		if (g >= 65 && g <= 66) {
			return new Grade(6);
		}
		
		if (g >= 62 && g <= 64) {
			return new Grade(7);
		}
		
		if (g >= 60 && g <= 61) {
			return new Grade(8);
		}
		
		if (g >= 57 && g <= 59) {
			return new Grade(9);
		}
		
		if (g >= 55 && g <= 56) {
			return new Grade(10);
		}
		
		if (g >= 52 && g <= 54) {
			return new Grade(11);
		}
		
		if (g >= 50 && g <= 51) {
			return new Grade(12);
		}
		
		if (g >= 47 && g <= 49) {
			return new Grade(13);
		}
		
		if (g >= 45 && g <= 46) {
			return new Grade(14);
		}
		
		if (g >= 42 && g <= 44) {
			return new Grade(15);
		}
		
		if (g >= 40 && g <= 41) {
			return new Grade(16);
		}
		
		if (g >= 35 && g <= 39) {
			return new Grade(17);
		}
		
		if (g >= 30 && g <= 34) {
			return new Grade(18);
		}
		
		if (g >= 0 && g <= 29) {
			return new Grade(19);
		}
		
		if (g == -1) {
			return new Grade(20);
		}
		
		throw new IllegalArgumentException();
	}
}
