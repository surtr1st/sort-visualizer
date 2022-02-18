package resource;

import sort.SortPanel;

public class ShakerSort implements ISortRunnable {
    @Override
    public void startSorting(SortPanel data) {
        int left = 0;
        int right = data.getArraySize() - 1;
        int k = 0;
        while(left < right) {
            for (int i = left; i < right; i++) {
                if(data.getArrayIndex(i) > data.getArrayIndex(i + 1)) {
                    data.swap(i, i + 1);
                    k = i;
                }
            }
            right = k;
            for (int i = right; i > left; i--) {
                if(data.getArrayIndex(i) < data.getArrayIndex(i - 1)) {
                    data.swap(i, i - 1);
                    k = i;
                }
            }
            left = k;
        }
    }
}
