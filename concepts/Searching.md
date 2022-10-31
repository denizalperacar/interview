# Searching Algorithms

The ideas for searching algorithms and their problems.

## random search O(n)

Randomly search the data until you find a match.

* If the value is exclusive then it never stops.

## Sequential Search O(n)

Search it element by element from start of the list to its end.

```java

public  static int sequentialSearch(double[] array, double val) {
    for (int i = 0; i < array.length(); i++)
        if (array[i] == val) return val;
    return -1;
}

```

## Binary Search O(log(n))

- Used in a sorted list.

- Let the interval be $I = [low, High)$
- Divide the list in half and select the half which has the val.
- Do the above process until the lower and upper bounds are same or the upper bound is less than the lower bound.
- the mid is checked once so it is exclusive if any of the divisions are going to be used. For instance if `val != vec[mid]` then either the new interval is `[low, mid)` or `[mid+1, high)`.

**the recursive soution**:

```C++
#include vector

template <typename T> 
int search(const std::vector<T> & vec, const T val) {
    return binarySearch(vec, val, 0, vec.size());
}

template <typename T>
int binarySearch(const std::vector<T> & vec, T val, int low, int high) {

    // base case
    if (high <= low) return -1;

    // get the mid
    int mid = low + (high - low) / 2;
    
    // divide the array
    if (vec[mid] == val) return mid; 
    else if (vec[mid] > val) return binarySearch(vec, val, low, mid);
    else binarySearch(vec, val, mid + 1, high);

}

```

**The non recursive solution**:

```python
def binary_search(vec, val):

    low, high = 0, len(vec)

    while (high > low):
        mid = int((high + low) / 2)
        if vec[mid] == val: 
            return mid
        elif vec[mid] > val: 
            low = mid
        else 
            high = mid +1
    return -1
```
