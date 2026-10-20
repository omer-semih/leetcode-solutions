class Solution {

    public static int carFleet(int target, int[] position, int[] speed) {
       int length = position.length;
       double[][] cars = new double[length][2];

       for(int i=0;i<length;i++) {
        cars[i] = new double[] {position[i], (double)(target-position[i])/speed[i]};
       }

        // Sort cars descending by position (closest to target first)
       Arrays.sort(cars, (a,b) -> Double.compare(b[0],a[0]));
        double currentMaxTime = 0;
        int total_fleet = 0;

        // Traverse from front to back. If a trailing car takes longer than the fleet ahead,
        // it can't catch up, forming a new fleet.
       for(int i=0;i<length;i++) {
        if(cars[i][1] > currentMaxTime) {
            currentMaxTime = cars[i][1];
            total_fleet++;
        }
       }

       return total_fleet;
    }

}

/*
* Initial Approach: Sorting cars via custom Class and manually skipping merged cars using a nested loop.
*/
// class Solution {
//     static class Car {
//         int pos;
//         int spd;
//         Car(int pos, int spd) {
//             this.pos = pos;
//             this.spd = spd;
//         }
//     }

//     public static int carFleet(int target, int[] position, int[] speed) {
//        int length = position.length;
//         if (length == 0) return 0;

//         Car[] cars = new Car[length];
//         for (int i = 0; i < length; i++) {
//             cars[i] = new Car(position[i], speed[i]);
//         }
//         Arrays.sort(cars, (a, b) -> Integer.compare(b.pos, a.pos));
//         
//         for (int i = 0; i < length; i++) {
//             position[i] = cars[i].pos;
//             speed[i] = cars[i].spd;
//         }

//         int total_fleet = 0;

//        for(int i=0;i<length;i++) {
        
//         float compare = (float)(target-position[i])/speed[i];
//          while(i<length-1 && ((float)(target-position[i+1])/speed[i+1]) <= compare){
//             i++;
            
//          }
//         total_fleet++;
//        }

//        return total_fleet;
//     }
// }