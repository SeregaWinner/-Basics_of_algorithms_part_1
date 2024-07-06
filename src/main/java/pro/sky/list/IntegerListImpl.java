package pro.sky.list;

import pro.sky.exception.InvalidIndexException;
import pro.sky.exception.NullItemException;

import java.util.Arrays;

import static pro.sky.Main.swapElements;

public class IntegerListImpl implements IntegerList {

    private Integer[] repository;
    private int size;

    public IntegerListImpl() {
        repository = new Integer[10];
    }

    public IntegerListImpl(int initSize) {
        repository = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        return add(size, item);
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateIndex(index);
        validateItem(item);
        if (index == size) {
            repository[size++] = item;
            return item;
        }
        System.arraycopy(repository, index, repository, index + 1, size - index);
        repository[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        repository[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        Integer item = repository[index];
        if (index != size) {
            System.arraycopy(repository, index + 1, repository, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] copy = toArray();
        quickSort(copy,0, copy.length - 1);
        return contains(copy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            Integer s = repository[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            Integer s = repository[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return repository[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(repository, size);
    }

//    private static void sortInsertion(Integer[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            Integer temp = arr[i];
//            int j = i;
//            while (j > 0 && arr[j - 1].compareTo(temp) >= 0) {
//                arr[j] = arr[j - 1];
//                j--;
//            }
//            arr[j] = temp;
//        }
//    }

    private static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }

    }

    private static int partition(Integer[] arr, int begin, int end) {
        Integer pivot = arr[end];
        int i = begin - 1;
        for (int j = begin - 1; j < end; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int left, int right) {
        Integer temp = arr[left];
        arr[left] = arr[right];
        arr[right]= temp;
    }


    private void grow() {
        Arrays.copyOf(repository, repository.length * 3 / 2);
    }

    private static boolean contains(Integer[] arr, Integer element) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (element.equals(arr[mid])) {
                return true;
            }
            if (element.compareTo(arr[mid]) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void validateSize() {
        if (size == repository.length) {
            grow();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

}
