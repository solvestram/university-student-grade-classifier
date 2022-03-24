import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.*;

class ProfileTest {

	@Nested
	class InvalidGradesListTest {
		@Test
		void failGrade() {
			List<Grade> grades = new ArrayList<>();
			grades.add(new Grade(8));
			grades.add(new Grade(14));
			grades.add(new Grade(18)); // fail grade
			grades.add(new Grade(6));
			
			IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {	
				Profile profile = new Profile(grades);
			});
		}
		
		@Test
		void emptyGradeList() {
			List<Grade> grades = new ArrayList<>(); // empty list
			
			IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {	
				Profile profile = new Profile(grades);
			});
		}
		
		@Test
		void nullGradeList() {
			List<Grade> grades = null; // null list
			
			IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {	
				Profile profile = new Profile(grades);
			});
		}
	}
	
	@Nested 
	class ClassifyTest {
		@Test
		void first() {
			List<Grade> grades = new ArrayList<>();
			grades.add(new Grade(3)); // first
			grades.add(new Grade(4)); // first
			grades.add(new Grade(7)); // upper second
			grades.add(new Grade(5)); // upper second
			
			Profile profile = new Profile(grades);
			
			assertEquals(Classification.First, profile.classify());
		}
		
		@Test
		void upperSecond() {
			List<Grade> grades = new ArrayList<>();
			grades.add(new Grade(7)); // upper second
			grades.add(new Grade(6)); // upper second
			grades.add(new Grade(4)); // first
			grades.add(new Grade(8)); // upper second
			grades.add(new Grade(9)); // lower second
			grades.add(new Grade(5)); // upper second
			grades.add(new Grade(6)); // upper second
			grades.add(new Grade(10)); // lower second
			
			Profile profile = new Profile(grades);
			
			assertEquals(Classification.UpperSecond, profile.classify());
		}
		
		@Test
		void lowerSecond() {
			List<Grade> grades = new ArrayList<>();
			grades.add(new Grade(10)); // second lower
			grades.add(new Grade(6)); // second upper
			grades.add(new Grade(12)); // second lower
			grades.add(new Grade(14)); // third
			
			Profile profile = new Profile(grades);
			
			assertEquals(Classification.LowerSecond, profile.classify());
		}
		
		@Test
		void third() {
			List<Grade> grades = new ArrayList<>();
			grades.add(new Grade(14)); // third
			grades.add(new Grade(12)); // lower second
			grades.add(new Grade(15)); // third
			grades.add(new Grade(13)); // third
			
			Profile profile = new Profile(grades);
			
			assertEquals(Classification.Third, profile.classify());
		}
		
	}
	
	@Nested
	class IsClearTest {
		@Test
		void clear() {
			List<Grade> grades = new ArrayList<>();
			grades.add(new Grade(2)); // first
			grades.add(new Grade(4)); // first
			grades.add(new Grade(6)); // upper second
			grades.add(new Grade(5)); // upper second
			
			Profile profile = new Profile(grades);
			
			assertTrue(profile.isClear());
		}
		
		@Test
		void notClear() {
			List<Grade> grades = new ArrayList<>();
			grades.add(new Grade(7)); // first
			grades.add(new Grade(6)); // first
			grades.add(new Grade(14)); // third
			grades.add(new Grade(14)); // third
			
			Profile profile = new Profile(grades);
			
			assertFalse(profile.isClear());
		}
	}
}
