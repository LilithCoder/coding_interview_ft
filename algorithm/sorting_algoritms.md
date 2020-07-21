# 排序 Sorting Algoritms
>[排序算法基础](#排序算法基础),
>[选择排序(Selection_Sort)](#选择排序(Selection_Sort))
>[插入排序(Insertion_Sort)](#插入排序(Insertion_Sort))
>[希尔排序(Shell_Sort)](#希尔排序(Shell_Sort))

注：带*为没理解的知识点

## 排序算法基础
---
实际上，要排序的数字很少是单独的值。他们通常都是称为记录的数据集的一部分。每个记录包含一个关键字(key)，该关键字是要排序的值。记录的其余部分由卫星数据(satellite data)组成，通常随关键字一同存取的。实际上，当排序算法对关键字进行排列时，它也必须对卫星数据进行排列。如果每个记录都包含大量卫星数据，则我们通常重排记录指针的数组，而不是记录本身，以最大程度地减少数据移动。

如果输入数组中仅有常数个元素需要在排序过程中存储在数组之外，则称排序算法是原址的(in place)

## 选择排序(Selection_Sort)
---
首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小的元素那么它就和自己交换）。再次，在剩下的元素中找到最小的元素，将它与数组中的第二个元素交换位置。如此往复，直到将整个数组排序，这种方法叫选择排序的原因是它在不断地选择剩余元素之中的最小者。

平均和最坏情况的时间复杂度O(n^2)，空间复杂度O(1)

运行时间和输入无关：为了找出最小的元素而扫描一遍数组并不能为下一遍扫描提供什么信息，一个已经有序的数组和一个元素随机排列的数组所用的排序时间一样长。

数据移动是最少的：数组元素交换的次数和数组的大小是线性关系。

```bash
public static void selection_sort(int[] target_arr) {
    int N = target_arr.length;
    for (int i = 0; i < N - 1; i++) {
        int min_idx = i;
        for (int j = i + 1; j < N; j++) {
            if (target_arr[j] < target_arr[min_idx]) {
                min_idx = j;
            }
        }
        int temp = target_arr[min_idx];
        target_arr[min_idx] = arr[i];
        arr[i] = temp;
    }
}
```

## 插入排序(Insertion_Sort)
---
每次将数组元素插入已经有序的部分数组中的合适位置，然后为了给要插入的元素腾出空间，我们需要将剩余的元素在插入之前都向右移动一位。当前索引左边的所有元素都是有序的，当索引到达数组的右端时，数组排序就完成了。

插入排序所需的时间取决于输入中元素的初始顺序。一个有序或接近有序的数组进行排序会随机顺序的数组快。

时间复杂度O(n^2)，空间复杂度O(1)

![](pic/insert_sort.png)
```bash
public static void insertion_sort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```
```bash
def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key
```

## 希尔排序(Shell_Sort)
---
希尔排序是一种基于插入排序的快速的排序算法，是对直接插入排序的一种优化，插入排序对已经排好序的数据操作时效率高，即可达到线性排序的效率。但对于大规模乱序数组插入排序很慢，因为它只会交换相邻的元素，但是希尔排序为了加快速度，将带排序的数组元素按下标的一定增量分组，分成多个子序列，然后对各个子序列进行直接插入排序，然后依次缩减增量再进行排序，直到增量为1时，进行最后一次直接插入排序，排序结束。

原理图示：

![](pic/shellsort.png)
```bash
public static void shell_sort(int[] arr) {
    int n = arr.length;
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            int value = arr[i];
            int j;
            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                arr[j] = arr[j - gap];
            }
            arr[j] = temp;
        }
    }
}
```
上述shellsort实现的时间复杂度为O(n^2)。在上面的实现中，每次迭代的gap减少了一半。

## 归并排序(Merge_Sort)
---
先递归地将目标数组分成两半分别排序，然后将结果归并起来。归并排序能够保证将任意长度为N的数组排序所需时间和NlogN成正比，缺点是它所需的额外空间和N成正比
![](pic/merge_sort.png)

原地归并实现起来很复杂，所以我们使用额外空间，将涉及的所有元素复制到一个辅助数组中，再把归并的结果放回原数组中
```bash
public static void merge(int[] arr, int low, int mid, int high) {
    int n1 = mid - low + 1;
    int n2 = high - mid;
    int[] L = new int[n1];
    int[] R = new int[n2];
    // 将元素复制到辅助数组中
    for (int i = 0; i < n1; i++) {
        L[i] = arr[low + i];
    }
    for (int j = 0; j < n2; j++) {
        R[j] = arr[mid + 1 + j];
    }
    int i = 0;
    int j = 0;
    int k = low;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i++];
        } else {
            arr[k] = R[j++];
        }
        k++;
    }
    // 右半边用尽，取左半边的数组元素
    while (i < n1) {
        arr[k++] = L[i++];
    }
    // 左半边用尽，取右半边的数组元素
    while (j < n2) {
        arr[k++] = R[j++];
    }
}
```
利用分治思想实现归并排序:
```bash
public static void merge_sort(int[] arr, int low, int high) {
    if (low < high) {
        int mid = (low + high) / 2;
        merge_sort(arr, low, mid);
        merge_sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }
}
```
