package resource;

import sort.SortPanel;

public class BubbleSort implements ISortRunnable {
    @Override
    public void startSorting(SortPanel data) {
        for(int i = 0; i < data.getArraySize() - 1; i++) {
            for (int j = 0; j < data.getArraySize() - i - 1; j++) {
                if(data.getArrayIndex(j) > data.getArrayIndex(j + 1)) {
                    data.swap(j, j + 1);
                }
            }
        }
    }
}
