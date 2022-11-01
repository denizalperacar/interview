# Sorting Algorithms

Rearrange N items to put them in ascending order.

## Bubble Sort

## Insertion Sort

Induction:

* Keep a sorted subsection from index 0 to i-1.

* For i search the first i for the correct location for element i say j <= i.

* swap element by element until element initially at i is moved to j.  


1. Move down through the array
2. Each item is transferred above the larger ones above it.
3. everything above the current item are sorted.
4. Everything below is unsorted.

```C++
#include <algorithm>
#include <vector>

template<typename T>
std::vector<T> insertionSort(const Std::vector<T> & vec) {
    for (int i = 1; i < vec.size(); i++) {
        for (int j = i; j > 0; j--) {
            if (vec[j] < vec[j-1]) 
                std::swap(vec[j], vec[j-1]);
            else 
                break;
        }
    }
}

```

## Merge Sort

* The merge sort has two componenets the fisrt one is merging the second one is division.

* The merge part assumes the subdivisions are each sorted.

```C++

template<typename T>
void merge(std::vector<T> &vec, int low, int mid, int high) {

    int i = low;
    int j = mid;
    int n = high - low;
    std::vector<T> temp(n);

    for (int k = 0; k < n; k++) {
        // handle base cases
        if (i == mid) temp[k] = vec[j++];
        else if (j == high) temp[k] = vec[i++];
        // handle inner cases
        else if (vec[i] < vec[j]) temp[k] = vec[i++];
        else vec[j++]; 
    }

    // copy everything
    for (int k = 0; k < n; k++) {
        vec[k + low] = temp[k];
    }
}

template<typename T>
void sort(std::vector<T> &a) {
    mergesort(a, 0, a.size());
}

template<typename T>
void mergeSort(std::vector<T> &a, int low, int high) {
    
    int n = high - low;
    if (n <= 1) return;

    int mid = (low + high) / 2;
    mergeSort(a, low, mid);
    mergeSort(a, mid, high);
    merge(a, low, mid,high);
}

```




## Quick Sort

## Tim Sort
