import java.time.LocalTime;
import java.util.Scanner;

public class EmployeeAttendance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define official start time and grace period (in minutes)
        LocalTime officialStart = LocalTime.of(9, 0); // 9:00 AM
        int gracePeriodMinutes = 15;

        // Input employee arrival time
        String inputTime = sc.nextLine();
        LocalTime arrivalTime = LocalTime.parse(inputTime);
        System.out.print("Enter arrival time (08:00): ");
        
        // Calculate grace cutoff
        LocalTime graceCutoff = officialStart.plusMinutes(gracePeriodMinutes);

        // Check attendance status
        if (arrivalTime.isBefore(officialStart)) {
            System.out.println("Status: Early");
        } else if (!arrivalTime.isAfter(graceCutoff)) {
            System.out.println("Status: On Time (within grace period)");
        } else {
            System.out.println("Status: Late");
        }

        sc.close();
    }
}