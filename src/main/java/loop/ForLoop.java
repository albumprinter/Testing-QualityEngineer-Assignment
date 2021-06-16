package loop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForLoop {
    private static final List<Integer> intList = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));

    public int Sum() {
        int sum = 0;
        int size = intList.size();
        for (int i = 0; i < size; i++) {
            sum = sum + intList.get(i);
        }
        return sum;
    }
}
