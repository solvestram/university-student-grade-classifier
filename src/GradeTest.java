import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class GradeTest {

	@Nested
	class GradeRangeTest {
		@Test
		void aboveValidRange() {
			IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
				Grade grade = new Grade(25);
			});
		}

		@Test
		void belowValidRange() {
			IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
				Grade grade = new Grade(-5);
			});
		}

		@Test
		void validRange() {
			Grade grade = new Grade(10);
			assertEquals(10, grade.getPoints());
		}
	}

	@Nested
	class ClassifyTest {
		@Test
		void first() {
			Grade grade = new Grade(3);
			assertEquals(Classification.First, grade.classify());
		}
		
		@Test
		void upperSecond() {
			Grade grade = new Grade(6);
			assertEquals(Classification.UpperSecond, grade.classify());
		}
		
		@Test
		void lowerSecond() {
			Grade grade = new Grade(11);
			assertEquals(Classification.LowerSecond, grade.classify());
		}
		
		@Test
		void third() {
			Grade grade = new Grade(14);
			assertEquals(Classification.Third, grade.classify());
		}
		
		@Test
		void fail() {
			Grade grade = new Grade(18);
			assertEquals(Classification.Fail, grade.classify());
		}
	}

	@Nested
	class FromPercentageTest {
		@Test
		void aboveValidRange() {
			IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
				Grade.fromPercentage(105);
			});
		}

		@Test
		void belowValidRange() {
			IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
				Grade.fromPercentage(-4);
			});
		}

		@Test
		void toGradeOne() {
			Grade grade = Grade.fromPercentage(88);
			assertEquals(1, grade.getPoints());
		}
		
		@Test
		void toGradeTwo() {
			Grade grade = Grade.fromPercentage(76);
			assertEquals(2, grade.getPoints());
		}
		
		@Test
		void toGradeThree() {
			Grade grade = Grade.fromPercentage(75);
			assertEquals(3, grade.getPoints());
		}
		
		@Test
		void toGradeFour() {
			Grade grade = Grade.fromPercentage(71);
			assertEquals(4, grade.getPoints());
		}
		
		@Test
		void toGradeFive() {
			Grade grade = Grade.fromPercentage(67);
			assertEquals(5, grade.getPoints());
		}
		
		@Test
		void toGradeSix() {
			Grade grade = Grade.fromPercentage(65);
			assertEquals(6, grade.getPoints());
		}
		
		@Test
		void toGradeSeven() {
			Grade grade = Grade.fromPercentage(63);
			assertEquals(7, grade.getPoints());
		}
		
		@Test
		void toGradeEight() {
			Grade grade = Grade.fromPercentage(60);
			assertEquals(8, grade.getPoints());
		}
		
		@Test
		void toGradeNine() {
			Grade grade = Grade.fromPercentage(58);
			assertEquals(9, grade.getPoints());
		}
		
		@Test
		void toGradeTen() {
			Grade grade = Grade.fromPercentage(55);
			assertEquals(10, grade.getPoints());
		}
		
		@Test
		void toGradeEleven() {
			Grade grade = Grade.fromPercentage(54);
			assertEquals(11, grade.getPoints());
		}
		
		@Test
		void toGradeTwelve() {
			Grade grade = Grade.fromPercentage(50);
			assertEquals(12, grade.getPoints());
		}
		
		@Test
		void toGradeThirteen() {
			Grade grade = Grade.fromPercentage(48);
			assertEquals(13, grade.getPoints());
		}
		
		@Test
		void toGradeFourteen() {
			Grade grade = Grade.fromPercentage(45);
			assertEquals(14, grade.getPoints());
		}
		
		@Test
		void toGradeFifteen() {
			Grade grade = Grade.fromPercentage(44);
			assertEquals(15, grade.getPoints());
		}
		
		@Test
		void toGradeSixteen() {
			Grade grade = Grade.fromPercentage(41);
			assertEquals(16, grade.getPoints());
		}
		
		@Test
		void toGradeSeventeen() {
			Grade grade = Grade.fromPercentage(37);
			assertEquals(17, grade.getPoints());
		}
		
		@Test
		void toGradeEighteen() {
			Grade grade = Grade.fromPercentage(32);
			assertEquals(18, grade.getPoints());
		}
		
		@Test
		void toGradeNineteen() {
			Grade grade = Grade.fromPercentage(20);
			assertEquals(19, grade.getPoints());
		}
		
		@Test
		void toGradeTwenty() {
			Grade grade = Grade.fromPercentage(-1);
			assertEquals(20, grade.getPoints());
		}
	}

}
