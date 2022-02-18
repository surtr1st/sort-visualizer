package resource;

import sort.SortPanel;

public class PancakeSort implements ISortRunnable {
    @Override
    public void startSorting(SortPanel data) {
        pancake(data, data.getArraySize());
    }
    private void flip(SortPanel data, int i) {
        int start = 0;
        while(start < i) {
            data.swap(start, i);
            start++;
            i--;
        }
    }
    private int findMax(SortPanel data, int n)
    {
        int mi, i;
        for(mi = 0, i = 0; i < n; ++i)
            if(data.getArrayIndex(i) > data.getArrayIndex(mi))
                mi = i;

        return mi;
    }
    private int pancake(SortPanel data, int n)
    {
        for(int current_size = n; current_size > 1; --current_size)
        {
            int mi = findMax(data, current_size);
            if(mi != current_size - 1) {
                flip(data, mi);
                flip(data, current_size - 1);
            }
        }
        return 0;
    }
}
