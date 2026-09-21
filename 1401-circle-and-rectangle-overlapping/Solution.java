// LeetCode 1401: Circle and Rectangle Overlapping
// https://leetcode.com/problems/circle-and-rectangle-overlapping/description/


// My initial solution Brute Force (Check all integer grid points inside the rectangle)
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        // Iterate through all points inside the rectangle
        for(int i=x1;i<=x2;i++) {
            for(int j=y1;j<=y2;j++) {
                if( (Math.sqrt(Math.pow(xCenter-i,2)+Math.pow(yCenter-j,2))) <= radius) return true;
            }
        }

        // Check if the circle is strictly inside the rectangle
        if( xCenter-radius > x1 && 
            xCenter+radius < x2 &&
            yCenter-radius > y1 &&
            yCenter+radius < y2 ) return true;

        return false;
    }
}


// Perfect Time: O(1), Space: O(1) solution
//// Find the point on/inside the rectangle closest to the circle's center. 

// class Solution {
//     public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {

//         int x_n, y_n;
//         if(xCenter < x1) x_n = x1;
//         else if(xCenter > x2) x_n = x2;
//         else x_n = xCenter;
        
//         if(yCenter < y1) y_n = y1;
//         else if(yCenter > y2) y_n = y2;
//         else y_n = yCenter;
            // Compare distance with radius
//         return (Math.sqrt(Math.pow(xCenter-x_n,2)+Math.pow(yCenter-y_n,2)) > radius) ? false : true;

//     }
// }