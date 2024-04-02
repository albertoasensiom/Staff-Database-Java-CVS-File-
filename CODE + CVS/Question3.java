import java.io.File;
import java.util.*;

public class Question3 {

    public static void main(String[] args) throws Exception {
        // parsing and reading the CSV file data into the film (object) array
        // provide the path here...
        File directory = new File(
                "C:\\Users\\Alberto\\Desktop\\NCI\\SEMESTER 2\\Algorithms and Advanced Programming\\CA1");
        String name = directory.getAbsolutePath() + "//Staff.csv";
        Scanner sc = new Scanner(new File(name));
        Staff[] staffs = new Staff[10000];

        // this will just print the header in CSV file
        sc.nextLine();

        int i = 0;
        String st = "";
        while (sc.hasNextLine()) // returns a boolean value
        {
            st = sc.nextLine();
            String[] data = st.split(",");
            staffs[i++] = new Staff(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]),
                    Float.parseFloat(data[5]));
        }
        sc.close(); // closes the scanner

        // Sorting staffs array based on department
        quickSort(staffs, 0, i - 1);

        // Search for data records based on department
        String searchDepartment = "IT"; // Example search department
        searchByDepartment(staffs, searchDepartment);
    }


    // QUICK SORT IMPLEMENTATION
    public static void quickSort(Staff[] staffs, int low, int high) {
        if (low < high) {
            int pi = partition(staffs, low, high);

            quickSort(staffs, low, pi - 1);
            quickSort(staffs, pi + 1, high);
        }
    }

    // Helper function for quick sort - partitioning
    public static int partition(Staff[] staffs, int low, int high) {
        String pivot = staffs[high].getDepartment();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // Compare based on department
            if (staffs[j].getDepartment().compareTo(pivot) < 0 ||
                    (staffs[j].getDepartment().equals(pivot) && staffs[j].getEmpNo() < staffs[high].getEmpNo())) {
                i++;
                swap(staffs, i, j); // Swap staffs[i] and staffs[j]
            }
        }

        swap(staffs, i + 1, high); // Swap staffs[i+1] and staffs[high] (or pivot)

        // Here I move the elements with same department to the start of the partition.
        // Then I sort them
        // based on the EmpNo using a while loop that compares the EmpNo
        int pivotIndex = i + 1;
        int index = pivotIndex - 1;
        while (index >= low && staffs[index].getDepartment().equals(pivot)) {
            if (staffs[index].getEmpNo() > staffs[pivotIndex].getEmpNo()) {
                swap(staffs, index, pivotIndex);
                pivotIndex = index;
            }
            index--;
        }

        return pivotIndex;
    }

    // Helper function for swapping the values of the array
    public static void swap(Staff[] staffs, int i, int j) {
        Staff temp = staffs[i];
        staffs[i] = staffs[j];
        staffs[j] = temp;
    }

    /*-------------------------------QUESTION 3: SEARCHING ALGORITHM: LINEAR SEARCH---------------------------------------- */

    public static void searchByDepartment(Staff[] staffs, String searchDepartment) {
        boolean found = false;
        System.err.println("These are the elements that match with " + searchDepartment);
        for (Staff staff : staffs) {
            if (staff.getDepartment().equals(searchDepartment)) {
                System.out.println(staff);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Not an existing " + searchDepartment + "!");
        }
    }

    /*-------------------------------------------------------------------------------------------- */
}

class Staff implements Comparable<Staff> {

    private int empNo;
    private String fName;
    private String sName;
    private String department;
    private float wage;
    private float projectCompletionRate;

    // constructor
    public Staff(int empNo, String fName, String sName, String department, float wage, float projectCompletionRate) {
        super();
        this.empNo = empNo;
        this.fName = fName;
        this.sName = sName;
        this.department = department;
        this.wage = wage;
        this.projectCompletionRate = projectCompletionRate;
    }

    // setters and getters
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    // getters and setters for the fields
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Staff [EmpNo=" + empNo + ", first name=" + fName + ", last Name=" + sName + ", department="
                + department + ", wage=" + wage + ", project completion rate="
                + projectCompletionRate + "]";
    }
}

