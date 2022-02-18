package resource;

import sort.SortPanel;

public class OddEvenSort implements ISortRunnable {
    @Override
    public void startSorting(SortPanel data) {
        boolean isSorted = false;
        while(!isSorted) {
            isSorted = true;
            for (int i = 1; i <= data.getArraySize() - 2; i += 2) {
                if(data.getArrayIndex(i) > data.getArrayIndex(i + 1)) {
                    data.swap(i, i + 1);
                    isSorted = false;
                }
            }
            for (int i = 0; i <= data.getArraySize() - 2; i += 2) {
                if(data.getArrayIndex(i) > data.getArrayIndex(i + 1)) {
                    data.swap(i, i + 1);
                    isSorted = false;
                }
            }
        }
        return;
    }
}
