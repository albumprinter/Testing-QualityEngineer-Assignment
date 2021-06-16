package filterAndOrder;

import filterAndOrder.models.Gender;
import filterAndOrder.models.Student;
import java.util.HashMap;
import java.util.Map;

public class StudentData {
    public static final Map<Integer, Student> STUDENT_MAP = new HashMap<Integer, Student>() {
        {
            put(101, new Student("Mike", Gender.male, 9));
            put(102, new Student("Rose", Gender.female, 10));
            put(103, new Student("James", Gender.male, 7));
            put(104, new Student("William", Gender.male, 8));
            put(105, new Student("Sophia", Gender.female, 6));
            put(106, new Student("Ava", Gender.female, 8));
        }
    };
}