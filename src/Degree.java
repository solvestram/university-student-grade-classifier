import java.util.ArrayList;
import java.util.List;

public class Degree {
	// Your additions/changes below this line
	private Profile levelFiveProfile, levelSixProfile;

	public Degree(List<Grade> year2, List<Grade> year3) {
		if (year2 == null || year2.size() != 4) {
			throw new IllegalArgumentException();
		}

		if (year3 == null || year3.size() != 4) {
			throw new IllegalArgumentException();
		}

		// combined list needed for level 5 profile calculation
		List<Grade> combinedGradesList = new ArrayList<>();
		
		for (Grade grade : year2) {
			if (grade.classify() == Classification.Fail) {
				// throw exception if there is a fail grade
				throw new IllegalArgumentException();
			}
			// add to combined list
			combinedGradesList.add(grade);
		}
		
		for (Grade grade : year3) {
			if (grade.classify() == Classification.Fail) {
				// throw exception if there is a fail grade
				throw new IllegalArgumentException();
			}
			// add to combined list
			combinedGradesList.add(grade);
		}
		
		// Creating profile objects
		levelFiveProfile = new Profile(combinedGradesList);
		levelSixProfile = new Profile(year3);
	}

	public Classification classify() {
		// if both profile classifications are same, then return that classification
		if (levelFiveProfile.classify() == levelSixProfile.classify()) {
			return levelSixProfile.classify();
		}
		
		// if profile 6 is better by one level and clear, return profile 6 classification
		if (levelSixProfile.classify().compareTo(levelFiveProfile.classify()) == 1 && levelSixProfile.isClear()) {
			return levelSixProfile.classify();
		}
		
		// if profile 5 is better by one level and clear, return profile 5 classification
		if (levelFiveProfile.classify().compareTo(levelSixProfile.classify()) == 1  && levelFiveProfile.isClear()) {
			return levelFiveProfile.classify();
		}
		
		// else return Discretion
		return Classification.Discretion;
	}
}
