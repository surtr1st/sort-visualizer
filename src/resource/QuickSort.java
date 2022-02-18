package resource;

import sort.SortPanel;

public class QuickSort implements ISortRunnable {
    @Override
    public void startSorting(SortPanel data) {
        quickSort(data, 0, data.getArraySize() - 1);
    }
    public int partition(SortPanel data, int low, int high) {
        int pivot = data.getArrayIndex(high);
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if(data.getArrayIndex(j) < pivot)
            {
                i++;
                data.swap(i, j);
            }
        }
        data.swap(i + 1, high);
        return i + 1;
    }

    public void quickSort(SortPanel data, int low, int high) {
        if(low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }
}
