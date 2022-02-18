package resource;

import sort.SortPanel;

public class HeapSort implements ISortRunnable {
    @Override
    public void startSorting(SortPanel data) {
        sort(data);
    }

    public void heap(SortPanel data, int n, int i) {
        int largest = i;
        int l = 2 * i;
        int r = 2 * i + 1;

        if(l < n && data.getArrayIndex(l) > data.getArrayIndex(largest)) {
            largest = l;
        }
        if(r < n && data.getArrayIndex(r) > data.getArrayIndex(largest))
            largest = r;

        if(largest != i) {
            data.swap(i, largest);
            heap(data, n , largest);
        }
    }
    public void sort(SortPanel data) {
        int n = data.getArraySize();
        for (int i = n / 2 - 1; i >= 0 ; i--) {
            heap(data, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            data.swap(0, i);
            heap(data, i, 0);
        }
    }
}
