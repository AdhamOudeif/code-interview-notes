// 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters.

// Explanation:
// If we can use additional data structures, we can use a boolean array to track if each character
// has been seen before. If we cannot use extra data structures, we sort the string and compare adjacent characters.

public boolean isUnique(String str) {
    if (str.length() > 128) return false; // ASCII limit
    boolean[] charSet = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
        int val = str.charAt(i);
        if (charSet[val]) return false;
        charSet[val] = true;
    }
    return true;
} // Time: O(n), Space: O(1)

public boolean isUniqueNoDS(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    for (int i = 1; i < chars.length; i++) {
        if (chars[i] == chars[i - 1]) return false;
    }
    return true;
} // Time: O(n log n), Space: O(1)


// 1.2 Check Permutation: Given two strings, decide if one is a permutation of the other.

// Explanation:
// Count the frequency of each character in both strings and compare.

public boolean checkPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) return false;
    int[] letters = new int[128];
    for (char c : s1.toCharArray()) letters[c]++;
    for (char c : s2.toCharArray()) {
        letters[c]--;
        if (letters[c] < 0) return false;
    }
    return true;
} // Time: O(n), Space: O(1)


// 1.3 URLify: Replace all spaces in a string with '%20'

// Explanation:
// Work from the end to avoid overwriting characters before moving them.

public void urlify(char[] str, int trueLength) {
    int spaceCount = 0;
    for (int i = 0; i < trueLength; i++) {
        if (str[i] == ' ') spaceCount++;
    }
    int index = trueLength + spaceCount * 2;
    for (int i = trueLength - 1; i >= 0; i--) {
        if (str[i] == ' ') {
            str[index - 1] = '0';
            str[index - 2] = '2';
            str[index - 3] = '%';
            index -= 3;
        } else {
            str[index - 1] = str[i];
            index--;
        }
    }
} // Time: O(n), Space: O(1)


// 1.4 Palindrome Permutation: Check if a string is a permutation of a palindrome.

// Explanation:
// A string can form a palindrome if at most one character has an odd count.

public boolean isPermutationOfPalindrome(String phrase) {
    int[] table = new int[128];
    for (char c : phrase.toLowerCase().toCharArray()) {
        if (Character.isLetter(c)) {
            table[c]++;
        }
    }
    boolean foundOdd = false;
    for (int count : table) {
        if (count % 2 == 1) {
            if (foundOdd) return false;
            foundOdd = true;
        }
    }
    return true;
} // Time: O(n), Space: O(1)


// 1.5 One Away: Check if two strings are one (or zero) edits away.

// Explanation:
// Handle insert, remove, and replace cases in one pass.

public boolean oneEditAway(String first, String second) {
    if (Math.abs(first.length() - second.length()) > 1) return false;
    String s1 = first.length() < second.length() ? first : second;
    String s2 = first.length() < second.length() ? second : first;
    int index1 = 0, index2 = 0;
    boolean foundDifference = false;
    while (index1 < s1.length() && index2 < s2.length()) {
        if (s1.charAt(index1) != s2.charAt(index2)) {
            if (foundDifference) return false;
            foundDifference = true;
            if (s1.length() == s2.length()) index1++;
        } else {
            index1++;
        }
        index2++;
    }
    return true;
} // Time: O(n), Space: O(1)


// 1.6 String Compression

// Explanation:
// Count repeated characters and build a new string.

public String compressString(String str) {
    StringBuilder compressed = new StringBuilder();
    int countConsecutive = 0;
    for (int i = 0; i < str.length(); i++) {
        countConsecutive++;
        if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
            compressed.append(str.charAt(i));
            compressed.append(countConsecutive);
            countConsecutive = 0;
        }
    }
    return compressed.length() < str.length() ? compressed.toString() : str;
} // Time: O(n), Space: O(n)


// 1.7 Rotate Matrix (NxN) by 90 degrees

// Explanation:
// Rotate layer by layer, moving four elements at a time.

public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int layer = 0; layer < n / 2; layer++) {
        int first = layer;
        int last = n - 1 - layer;
        for (int i = first; i < last; i++) {
            int offset = i - first;
            int top = matrix[first][i];
            matrix[first][i] = matrix[last - offset][first];
            matrix[last - offset][first] = matrix[last][last - offset];
            matrix[last][last - offset] = matrix[i][last];
            matrix[i][last] = top;
        }
    }
} // Time: O(n^2), Space: O(1)


// 1.8 Zero Matrix

// Explanation:
// First pass to find zero locations, second pass to nullify rows and columns.

public void setZeroes(int[][] matrix) {
    boolean[] rows = new boolean[matrix.length];
    boolean[] cols = new boolean[matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[i][j] == 0) {
                rows[i] = true;
                cols[j] = true;
            }
        }
    }
    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (rows[i] || cols[j]) {
                matrix[i][j] = 0;
            }
        }
    }
} // Time: O(mn), Space: O(m + n)


// 1.9 String Rotation

// Explanation:
// A rotated string will always be a substring of the original concatenated with itself.

public boolean isRotation(String s1, String s2) {
    if (s1.length() == s2.length() && s1.length() > 0) {
        String s1s1 = s1 + s1;
        return s1s1.contains(s2);
    }
    return false;
} // Time: O(n), Space: O(n)
