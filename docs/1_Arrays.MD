Array manipulation is a common topic in coding interviews, and many problems follow specific patterns. Here are some of the most commonly asked patterns:

---

### **1. Two Pointers**
- Used when you need to process elements from both ends of an array efficiently.
- **Examples**:
    - Removing duplicates
    - Moving zeros (`moveZeroes`)
    - Reverse an array
    - Check if an array is a palindrome

```java
public void moveZeroes(int[] nums) {
    int i = 0;
    for (int num : nums) {
        if (num != 0) nums[i++] = num;
    }
    while (i < nums.length) nums[i++] = 0;
}
```

---

### **2. Sliding Window**
- Efficient for problems involving sub arrays, like finding the maximum sum, smallest subarray, or longest substring.
- **Examples**:
    - Maximum sum subarray (`maxSubArray`)
    - Longest substring without repeating characters
    - Smallest subarray sum >= target

```java
public int maxSubArray(int[] nums) {
    int maxSum = nums[0], currSum = 0;
    for (int num : nums) {
        currSum = Math.max(num, currSum + num);
        maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
}
```

---

### **3. Prefix Sum**
- Helps solve range sum queries or subarray problems efficiently.
- **Examples**:
    - Range sum queries
    - Finding equilibrium index
    - Subarray sum equals K

```java
public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int sum = 0, count = 0;
    for (int num : nums) {
        sum += num;
        count += map.getOrDefault(sum - k, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return count;
}
```

---

### **4. Kadane’s Algorithm**
- Optimized method for finding the maximum subarray sum.
- **Examples**:
    - Largest sum contiguous subarray (`maxSubArray`)

```java
public int maxSubArray(int[] nums) {
    int maxSum = nums[0], currSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
        currSum = Math.max(nums[i], currSum + nums[i]);
        maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
}
```

---

### **5. Merge Intervals**
- Used when working with overlapping intervals.
- **Examples**:
    - Merging overlapping intervals
    - Insert interval
    - Meeting rooms

```java
public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> res = new ArrayList<>();
    int[] prev = intervals[0];
    for (int i = 1; i < intervals.length; i++) {
        if (prev[1] >= intervals[i][0]) {
            prev[1] = Math.max(prev[1], intervals[i][1]);
        } else {
            res.add(prev);
            prev = intervals[i];
        }
    }
    res.add(prev);
    return res.toArray(new int[res.size()][]);
}
```

---

### **6. Cyclic Sort**
- Used for problems involving numbers in a given range `[1, N]`.
- **Examples**:
    - Find missing number
    - Find duplicate numbers
    - First missing positive

```java
public int missingNumber(int[] nums) {
    int i = 0;
    while (i < nums.length) {
        int correct = nums[i];
        if (correct < nums.length && nums[i] != nums[correct]) {
            int temp = nums[i];
            nums[i] = nums[correct];
            nums[correct] = temp;
        } else {
            i++;
        }
    }
    for (i = 0; i < nums.length; i++) {
        if (nums[i] != i) return i;
    }
    return nums.length;
}
```

---

### **7. Monotonic Stack / Next Greater Element**
- Used to find the next greater or smaller element efficiently.
- **Examples**:
    - Next greater element
    - Largest rectangle in a histogram

```java
public int[] nextGreaterElement(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[nums.length];
    Arrays.fill(res, -1);
    for (int i = 0; i < nums.length; i++) {
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
            res[stack.pop()] = nums[i];
        }
        stack.push(i);
    }
    return res;
}
```

---

### **8. Binary Search on Arrays**
- Efficiently searching or modifying elements in a sorted array.
- **Examples**:
    - Find first and last occurrence of an element
    - Search in rotated sorted array

```java
public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return -1;
}
```

---

### **9. Hashing / Frequency Count**
- Used when checking for duplicates or counts of elements.
- **Examples**:
    - Find duplicate numbers
    - Longest consecutive sequence

```java
public int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);
    int maxLen = 0;
    for (int num : nums) {
        if (!set.contains(num - 1)) {
            int currNum = num;
            int currStreak = 1;
            while (set.contains(currNum + 1)) {
                currNum++;
                currStreak++;
            }
            maxLen = Math.max(maxLen, currStreak);
        }
    }
    return maxLen;
}
```

---

### **10. Matrix Traversal (2D Arrays)**
- Used when working with grid-based problems.
- **Examples**:
    - Rotate a matrix (90 degrees)
    - Spiral matrix traversal

```java
public void rotate(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; i++) {
        for (int j = i; j < n - i - 1; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[n - j - 1][i];
            matrix[j][n - i - 1] = temp;
        }
    }
}
```

---

### **Conclusion**
Mastering these patterns will give you an edge in solving most array-related interview problems efficiently. Do you have any specific problem that you want to practice, or should I provide a custom problem for you to solve? 🚀