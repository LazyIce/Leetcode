public class _551_StudentAttendanceRecordI {
    /**
     * time: O(n)
     * space: O(1)
     */
    public boolean checkRecord(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                count++;
            }
            if (i <= s.length() - 3 && s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
                return false;
            }
        }

        return count < 2;
    }
}
