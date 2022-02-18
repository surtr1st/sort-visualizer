package resource;

import sort.SortPanel;

public class InterchangeSort implements ISortRunnable {
    @Override
    public void startSorting(SortPanel data) {
        for (int i = 0; i < data.getArraySize() - 1; i++) {
            for (int j = i + 1; j < data.getArraySize(); j++) {
                if(data.getArrayIndex(i) > data.getArrayIndex(j))
                    data.swap(i, j);
            }
        }
    }
}
