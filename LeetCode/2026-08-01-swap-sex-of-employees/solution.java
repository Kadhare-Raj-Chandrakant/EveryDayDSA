// Time complexity: O(1)
// Space complexity: O(1)
public class Solution {
    public void swapSex(Salary obj) {
        obj.sex = obj.sex.equals("m") ? "f" : "m";
    }
}