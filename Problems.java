public class Problems{
    /*
    We have an array of heights, representing the altitude along a walking trail.
    Given start/end indexes into the array, return the sum of the changes for a walk
    beginning at the start index and ending at the end index. For example, with the heights {5, 3, 6, 7, 2}
    and start=2, end=4 yields a sum of 1 + 5 = 6. The start end end index will both be valid indexes
    into the array with start <= end.

    sumHeights([5, 3, 6, 7, 2], 2, 4) → 6
    sumHeights([5, 3, 6, 7, 2], 0, 1) → 2
    sumHeights([5, 3, 6, 7, 2], 0, 4) → 11
    */
    public int sumHeights(int[] heights, int start, int end){
        int result = 0;
        for(int i = start; i < end; i++){
            if(heights[i] > heights[i+1]){
                result += heights[i] - heights[i+1];
            }
            else{
                result += heights[i+1] - heights[i];
            }
        }
        return result;
    }
    /*
    (A variation on the sumHeights problem.) We have an array of heights, representing the altitude
    along a walking trail. Given start/end indexes into the array, return the sum of the changes for
    a walk beginning at the start index and ending at the end index, however increases in height count
    double. For example, with the heights {5, 3, 6, 7, 2} and start=2, end=4 yields a sum of 1*2 + 5 = 7.
    The start end end index will both be valid indexes into the array with start <= end.

    sumHeights2([5, 3, 6, 7, 2], 2, 4) → 7
    sumHeights2([5, 3, 6, 7, 2], 0, 1) → 2
    sumHeights2([5, 3, 6, 7, 2], 0, 4) → 15
    */
    public int sumHeights2(int[] heights, int start, int end){
        int result = 0;
        for(int i = start; i < end; i++){
            if(heights[i] > heights[i+1]){
                result += heights[i] - heights[i+1];
            }
            else{
                result += (heights[i+1] - heights[i]) * 2;
            }
        }
        return result;
    }
    /*
    (A variation on the sumHeights problem.) We have an array of heights, representing the altitude along
    a walking trail. Given start/end indexes into the array, return the number of "big" steps for a walk
    starting at the start index and ending at the end index. We'll say that step is big if it is 5 or more
    up or down. The start end end index will both be valid indexes into the array with start <= end.

    bigHeights([5, 3, 6, 7, 2], 2, 4) → 1
    bigHeights([5, 3, 6, 7, 2], 0, 1) → 0
    bigHeights([5, 3, 6, 7, 2], 0, 4) → 1
    */
    public int bigHeights(int[] heights, int start, int end) {
        int steps = 0;
        for(int i = start; i < end; i++){
            if(heights[i] - heights[i+1] >= 5 || heights[i] - heights[i+1] <= -5){
                steps++;
            }
        }
        return steps;
    }
    /*
    Given two arrays, A and B, of non-negative int scores. A "special" score is one which is a multiple of 10,
    such as 40 or 90. Return the sum of largest special score in A and the largest special score in B.

    scoresSpecial([12, 10, 4], [2, 20, 30]) → 40
    scoresSpecial([20, 10, 4], [2, 20, 10]) → 40
    scoresSpecial([12, 11, 4], [2, 20, 31]) → 20
    */
    public int scoresSpecial(int[] a, int[] b){
        int scoreA = 0, scoreB = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] % 10 == 0 && a[i] > scoreA){
                scoreA = a[i];
            }
        }
        for(int i = 0; i < b.length; i++){
            if(b[i] % 10 == 0 && b[i] > scoreB){
                scoreB = b[i];
            }
        }
        return scoreA + scoreB;
    }
    /*
    Given an array of strings, return a new array without the strings that are equal to the target string.
    One approach is to count the occurrences of the target string, make a new array of the correct length,
    and then copy over the correct strings.

    wordsWithout(["a", "b", "c", "a"], "a") → ["b", "c"]
    wordsWithout(["a", "b", "c", "a"], "b") → ["a", "c", "a"]
    wordsWithout(["a", "b", "c", "a"], "c") → ["a", "b", "a"]
    */
    public String[] wordsWithout(String[] words, String target){
        int size = 0;
        for(int i = 0; i < words.length; i++){
            if(!words[i].equals(target)){
                size++;
            }
        }
        String[] arr = new String[size];
        int index = 0;
        for(int i = 0; i < words.length; i++){
            if(!words[i].equals(target)){
                arr[index] = words[i];
                index++;
            }
        }
        return arr;
    }
    /*
    The "key" array is an array containing the correct answers to an exam, like {"a", "a", "b", "b"}.
    the "answers" array contains a student's answers, with "?" representing a question left blank.
    The two arrays are not empty and are the same length. Return the score for this array of answers,
    giving +4 for each correct answer, -1 for each incorrect answer, and +0 for each blank answer.

    scoreUp(["a", "a", "b", "b"], ["a", "c", "b", "c"]) → 6
    scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "c"]) → 11
    scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "b"]) → 16
    */
    public int scoreUp(String[] key, String[] answers){
        int score = 0;
        for(int i = 0; i < key.length; i++){
            if(answers[i].charAt(0) == '?'){
                score = score;
            }
            else if(key[i].charAt(0) == answers[i].charAt(0)){
                score = score + 4;
            }
            else{
                score = score -1;
            }
        }
        return score;
    }
    /*
    Given 2 arrays that are the same length containing strings, compare the 1st string in one array
    to the 1st string in the other array, the 2nd to the 2nd and so on. Count the number of times
    that the 2 strings are non-empty and start with the same char. The strings may be any length,
    including 0.

    matchUp(["aa", "bb", "cc"], ["aaa", "xx", "bb"]) → 1
    matchUp(["aa", "bb", "cc"], ["aaa", "b", "bb"]) → 2
    matchUp(["aa", "bb", "cc"], ["", "", "ccc"]) → 1
    */
    public int matchUp(String[] a, String[] b){
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if((a[i].length() > 0 && b[i].length() > 0) && a[i].charAt(0) == b[i].charAt(0)){
                count++;
            }
        }
        return count;
    }
    /*
    We'll say that a positive int n is "endy" if it is in the range 0..10 or 90..100 (inclusive).
    Given an array of positive ints, return a new array of length "count" containing the first endy
    numbers from the original array. Decompose out a separate isEndy(int n) method to test if a number
    is endy. The original array will contain at least "count" endy numbers.

    copyEndy([9, 11, 90, 22, 6], 2) → [9, 90]
    copyEndy([9, 11, 90, 22, 6], 3) → [9, 90, 6]
    copyEndy([12, 1, 1, 13, 0, 20], 2) → [1, 1]
    */
    public int[] copyEndy(int[] nums, int count){
        int[] arr = new int[count];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 1 && nums[i] <= 10 && index < arr.length){
                arr[index] = nums[i];
                index++;
            }
            else if(nums[i] >= 90 && nums[i] <= 100 && index < arr.length){
                arr[index] = nums[i];
                index++;
            }
        }
        return arr;
    }
    /*
    Given an array of positive ints, return a new array of length "count" containing the first even numbers
    from the original array. The original array will contain at least "count" even numbers.

    copyEvens([3, 2, 4, 5, 8], 2) → [2, 4]
    copyEvens([3, 2, 4, 5, 8], 3) → [2, 4, 8]
    copyEvens([6, 1, 2, 4, 5, 8], 3) → [6, 2, 4]
    */
    public int[] copyEvens(int[] nums, int count){
        int[] even = new int[count];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0 && index < even.length){
                even[index] = nums[i];
                index++;
            }
        }
        return even;
    }
}

