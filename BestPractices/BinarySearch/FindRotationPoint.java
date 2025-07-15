package BestPractices.BinarySearch;
public class FindRotationPoint {
    
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        if (arr[left] < arr[right]) {
            return 0;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid < right && arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }
            if (mid > left && arr[mid] < arr[mid - 1]) {
                return mid;
            }
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    
    public static void main(String[] args) {
        int[] rotatedArray = {7, 9, 11, 12, 15, 2, 5, 6};
        int rotationPoint = findRotationPoint(rotatedArray);
        System.out.println("Rotated Array: ");
        for (int num : rotatedArray) {
            System.out.print(num + " ");
        }
        System.out.println("\nRotation point index: " + rotationPoint);
        System.out.println("Smallest element: " + rotatedArray[rotationPoint]);
    }
}