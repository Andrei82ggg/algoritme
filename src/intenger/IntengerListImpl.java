package intenger;

import algoritm.*;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private final Integer[] storage;
    private int size;

    public IntegerListImpl() {
        storage = new Integer[10];
    }

    public IntegerListImpl(Integer initSize) {
        storage = new Integer[initSize];
    }


    @Override
    public Integer add(Integer item) {
        validateIten(item);
        validateSize();
        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateIten(item);
        validateIndex(index);
        if (index == size) {
            storage[size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index + 1, index - 1);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateIten(item);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateIten(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new itemNotFoundException();
        }
        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public Integer remove(Integer index) {
        validateIndex(index);
        Integer item = storage[index];
        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] storageCopy = toArray();
        sort(storageCopy);
        return binarySearch(storageCopy,item);
    }


    @Override
    public Integer indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)){
                return 1;
            }
        }
        return -1;
    }

    @Override
    public Integer lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(Integer index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntengerList otherList) {
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

        return Arrays.copyOf(storage,size);
    }

    private void validateIten(Integer iten){
        if (iten == null){
            throw new NullItemException();
        }
    }
    private void validateSize(){
        if (size == storage.length){
            throw  new StorageInFullException();
        }
    }
    private void validateIndex(Integer index){
        if (index < 0 || index > size){
            throw new InvalidIndexException();
        }
    }
    private void sort(Integer[] arr){
        for (int i = 1; i < arr.length; i++) {
        int temp = arr[i];
        int j = i;
        while (j > 0 && arr[j - i] > temp){
            arr[j] = arr[j - 1];
            j--;
        }
        arr[j] = temp;
        }
    }
    private boolean binarySearch(Integer[] arr, Integer item){
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
    }

