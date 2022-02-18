package resource;

import sort.SortPanel;

import java.util.Arrays;

public class GnomeSort implements ISortRunnable {
    @Override
    public void startSorting(SortPanel data) {
        gnomeSort(data, data.getArraySize());
    }
    static void gnomeSort(SortPanel data, int n)
    {
        int index = 0;

        while (index < n) {
            if (index == 0)
                index++;
            if (data.getArrayIndex(index) >= data.getArrayIndex(index - 1))
                index++;
            else {
                data.swap(index, index - 1);
                index--;
            }
        }
        return;
    }
}
