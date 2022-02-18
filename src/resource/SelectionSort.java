package resource;

import sort.SortPanel;

public class SelectionSort implements ISortRunnable {
    @Override
    public void startSorting(SortPanel data) {
        for (int i = 0; i < data.getArraySize() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < data.getArraySize(); j++) {
                if(data.getArrayIndex(j) < data.getArrayIndex(min)) {
                    min = j;
                }
            }
            data.swap(min, i);
        }
    }
}
