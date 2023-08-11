package org.example.LeetCode;

/**
 * @author TWAVE
 * @date 2023/8/11 17:12
 */
public class S2027 {
    public int minimumMoves(String s) {
        char[] charArray = s.toCharArray();
        int result = 0, i = 0, length = s.length();
        while (i < length) {
            boolean add3 = false;
            if (charArray[i] == 'X') {
                for (int j = 0; j < 3; j++) {
                    if (j < length) {
                        charArray[j] = 'O';
                    } else {
                        break;
                    }
                }
                result += 1;
                add3 = true;
            }
            if (add3) {
                i += 3;
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        S2027 solution = new S2027();
        System.out.println(solution.minimumMoves("XOXOXOXOOOXXXXOO"));
        System.out.println(solution.minimumMoves("XXX"));
        System.out.println(solution.minimumMoves("OOOO"));
        System.out.println(solution.minimumMoves("XXOX"));
    }
}
