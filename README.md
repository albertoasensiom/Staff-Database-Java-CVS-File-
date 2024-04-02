
- **Sorting Algorithm Implementation (QuickSort):**
  - Implemented `quickSort(Staff[] staffs, int low, int high)` method for sorting the array of Staff objects.
  - Utilized `partition(Staff[] staffs, int low, int high)` method for partitioning the array during the QuickSort algorithm.

- **Reading CSV Data:**
  - Used `Scanner` class along with `File` class for reading data from the CSV file.
  - Parsed each line of the CSV file using `Scanner.nextLine()` and `String.split()` methods.

- **Object-Oriented Approach:**
  - Defined a `Staff` class with encapsulated attributes.
  - Implemented getter and setter methods for accessing and modifying attributes (`getEmpNo()`, `setEmpNo()`, `getFName()`, etc.).

- **Comparable Interface Implementation:**
  - Implemented `Comparable<Staff>` interface in the `Staff` class.
  - Overrode the `compareTo(Staff other)` method to enable comparison and sorting based on department and employee number.

- **Equals Method Override:**
  - Overrode the `equals(Object obj)` method in the `Staff` class to ensure correct comparison of Staff objects based on all attributes.

- **File Handling:**
  - Utilized `File` and `Scanner` classes for file handling (`new File(name)`, `new Scanner(new File(name))`).

- **Array Manipulation:**
  - Manipulated arrays to store and sort `Staff` objects (`Staff[] staffs = new Staff[10000]`).

- **String Manipulation:**
  - Utilized string manipulation methods such as `split()` and `compareTo()` for processing CSV data and comparing strings.

- **Error Handling:**
  - Implemented exception handling to deal with potential file reading errors using `throws Exception` in `main()` method.

- **Output Display:**
  - Printed sorted `Staff` objects to the console using `System.out.println(staff)`.

- **Algorithm Optimization:**
  - Optimized QuickSort algorithm for sorting `Staff` objects by handling cases where departments are the same and ordering by employee number within the same department.
