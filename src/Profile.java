import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Profile {
	// Your additions/changes below this line
	private final List<Classification> classifiedGrades;
	private final int countFirst, countUpperSecond, countLowerSecond, countThird;

	public Profile(List<Grade> g) {
		if (g == null) {
			throw new IllegalArgumentException();
		}

		if (g.size() == 0) {
			throw new IllegalArgumentException();
		}
		
		// Checking for fail grade and creating array of grade classifications
		List<Classification> classifiedGrades = new ArrayList<>();

		for (Grade grade : g) {
			if (grade.classify() == Classification.Fail) {
				throw new IllegalArgumentException();
			} else {
				classifiedGrades.add(grade.classify());
			}
		}
		
		this.classifiedGrades = classifiedGrades;
		
		// Counting number of each classifications
		int countFirst = 0, countUpperSecond = 0, countLowerSecond = 0, countThird = 0;
		
		for (Classification gradeClassification : classifiedGrades) {
			if (gradeClassification == Classification.First) {
				countFirst++;
				continue;
			}

			if (gradeClassification == Classification.UpperSecond) {
				countUpperSecond++;
				continue;
			}

			if (gradeClassification == Classification.LowerSecond) {
				countLowerSecond++;
				continue;
			}

			if (gradeClassification == Classification.Third) {
				countThird++;
				continue;
			}
		}
		
		this.countFirst = countFirst;
		this.countUpperSecond = countUpperSecond;
		this.countLowerSecond = countLowerSecond;
		this.countThird = countThird;
	}

	public Classification classify() {
		if ((float)countFirst/(float)classifiedGrades.size() >= 0.5) {
			return Classification.First;
		}
		
		if ((float)(countFirst + countUpperSecond)/(float)classifiedGrades.size() >= 0.5) {
			return Classification.UpperSecond;
		}
		
		if ((float)(countFirst + countUpperSecond + countLowerSecond)/(float)classifiedGrades.size() >= 0.5) {
			return Classification.LowerSecond;
		}
		
		return Classification.Third;
	}

	public boolean isClear() {
		if ((float)countThird/(float)classifiedGrades.size() > 0.25) {
			return false;
		} else {
			return true;
		}
	}
}
