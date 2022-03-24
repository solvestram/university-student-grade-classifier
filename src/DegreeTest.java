import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

class DegreeTest {

	@Nested
	class InvalidGradesList {
		@Test
		void nullGradeList() {
			List<Grade> year2 = new ArrayList<>();
			year2.add(new Grade(7));
			year2.add(new Grade(11));
			year2.add(new Grade(10));
			year2.add(new Grade(9));
			
			List<Grade> year3 = null; // null list
			
			IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {	
				Degree degree = new Degree(year2, year3);
			});
		}
		
		@Test
		void notFourGradeList() {
			List<Grade> year2 = new ArrayList<>(); // List with 8 grades
			year2.add(new Grade(11));
			year2.add(new Grade(9));
			year2.add(new Grade(8));
			year2.add(new Grade(14));
			year2.add(new Grade(12));
			year2.add(new Grade(6));
			year2.add(new Grade(8));
			year2.add(new Grade(14));
			
			List<Grade> year3 = new ArrayList<>();
			year3.add(new Grade(7));
			year3.add(new Grade(11));
			year3.add(new Grade(11));
			year3.add(new Grade(9));
			
			IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {	
				Degree degree = new Degree(year2, year3);
			});
		}
		
		@Test
		void failGrade() {
			List<Grade> year2 = new ArrayList<>();
			year2.add(new Grade(8));
			year2.add(new Grade(14));
			year2.add(new Grade(12));
			year2.add(new Grade(6));
			
			List<Grade> year3 = new ArrayList<>();
			year3.add(new Grade(7));
			year3.add(new Grade(11));
			year3.add(new Grade(18)); // fail grade
			year3.add(new Grade(9));
			
			IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {	
				Degree degree = new Degree(year2, year3);
			});
		}
	}
	
	@Nested
	class ClassifyTest {
		@Test
		void first() {
			List<Grade> year2 = new ArrayList<>();
			year2.add(new Grade(3)); // first
			year2.add(new Grade(4)); // first
			year2.add(new Grade(4)); // first
			year2.add(new Grade(5)); // upper second
			
			List<Grade> year3 = new ArrayList<>();
			year3.add(new Grade(7)); // upper second
			year3.add(new Grade(6)); // upper second
			year3.add(new Grade(2)); // first
			year3.add(new Grade(6)); // upper second
			
			Degree degree = new Degree(year2, year3);
			assertEquals(Classification.First, degree.classify());
		}
		
		@Test
		void upperSecond() {
			List<Grade> year2 = new ArrayList<>();
			year2.add(new Grade(3)); // first
			year2.add(new Grade(5)); // upper second
			year2.add(new Grade(6)); // upper second
			year2.add(new Grade(9)); // lower second
			
			List<Grade> year3 = new ArrayList<>();
			year3.add(new Grade(7)); // upper second
			year3.add(new Grade(6)); // upper second
			year3.add(new Grade(2)); // first
			year3.add(new Grade(6)); // upper second
			
			Degree degree = new Degree(year2, year3);
			assertEquals(Classification.UpperSecond, degree.classify());
		}
		
		@Test
		void lowerSecond() {
			List<Grade> year2 = new ArrayList<>();
			year2.add(new Grade(9)); // lower second
			year2.add(new Grade(7)); // upper second
			year2.add(new Grade(14)); // third
			year2.add(new Grade(9)); // lower second
			
			List<Grade> year3 = new ArrayList<>();
			year3.add(new Grade(7)); // upper second
			year3.add(new Grade(10)); // lower second
			year3.add(new Grade(11)); // lower second
			year3.add(new Grade(11)); // lower second
			
			Degree degree = new Degree(year2, year3);
			assertEquals(Classification.LowerSecond, degree.classify());
		}
		
		@Test
		void third() {
			List<Grade> year2 = new ArrayList<>();
			year2.add(new Grade(13)); // third
			year2.add(new Grade(7)); // upper second
			year2.add(new Grade(14)); // third
			year2.add(new Grade(9)); // lower second
			
			List<Grade> year3 = new ArrayList<>();
			year3.add(new Grade(11)); // lower second
			year3.add(new Grade(13)); // third
			year3.add(new Grade(14)); // third
			year3.add(new Grade(14)); // third
			
			Degree degree = new Degree(year2, year3);
			assertEquals(Classification.Third, degree.classify());
		}
		
		@Test
		void discretion() {
			List<Grade> year2 = new ArrayList<>();
			year2.add(new Grade(8)); // upper second
			year2.add(new Grade(7)); // upper second
			year2.add(new Grade(6)); // upper second
			year2.add(new Grade(7)); // upper second
			
			List<Grade> year3 = new ArrayList<>();
			year3.add(new Grade(11)); // lower second
			year3.add(new Grade(13)); // third
			year3.add(new Grade(14)); // third
			year3.add(new Grade(14)); // third
			
			Degree degree = new Degree(year2, year3);
			assertEquals(Classification.Discretion, degree.classify());
		}
	}
}
