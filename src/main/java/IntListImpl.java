import java.util.Arrays;

public class IntListImpl implements IntList {

    private int[] dataArray = new int[10];
    private int count = 0;

    @Override
    public void add(int i) {
        if (count +1 >= dataArray.length) {
            makeBiggerArray();
        }
        dataArray[count] = i;
        count++;
    }

    @Override
    public void insert(int index, int value) {
        if (count + 1 >= dataArray.length) {
            makeBiggerArray();
        }
        System.arraycopy(dataArray, index, dataArray, index + 1, dataArray.length - 1 - index);
        dataArray[index] = value;
        count++;
    }

    @Override
    public void set(int index, int value) {

        dataArray[index] = value;

    }

    @Override
    public int size() {

        return count;

    }

    @Override
    public int capacity() {

        return dataArray.length;

    }

    @Override
    public int getByIndex(int index) {

        return dataArray[index];

    }

    @Override
    public Integer getIndexByValue(int value) {

        for (int i = 0; i < dataArray.length; i++) {
            if (value == dataArray[i]) {
                return i;
            }
        }
        return null;
    }

    @Override
    public boolean contains(int value) {

        boolean isValueContains = false;
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i] == value) {
                isValueContains = true;
                break;
            }
        }
        return isValueContains;
    }

    @Override
    public void removeValue(int value) {

        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i] == value) {
                int[] temporaryArray = new int[dataArray.length - 1];
                System.arraycopy(dataArray, 0, temporaryArray, 0, i);
                System.arraycopy(dataArray, i + 1, temporaryArray, i, temporaryArray.length - i);
                dataArray = temporaryArray;
                count--;
            }
        }
    }

    @Override
    public void removeByIndex(int index) {
        int[] temporaryArray = new int[dataArray.length - 1];
        System.arraycopy(dataArray, 0, temporaryArray, 0, index);
        System.arraycopy(dataArray, index + 1, temporaryArray, index, dataArray.length - index - 1);
        dataArray = temporaryArray;
        count--;

    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList list = new IntListImpl();
        for (int i = fromIndex; i < toIndex; i++) {
            list.add(dataArray[i]);
        }
        return list;
    }

    @Override
    public int[] toArray() {
        int[] returnArray = new int[count];
        System.arraycopy(dataArray, 0, returnArray, 0, size());
        return returnArray;
    }

    public void makeBiggerArray() {
        int[] newDataArray = new int[dataArray.length * 2];
        System.arraycopy(dataArray, 0, newDataArray, 0, dataArray.length);
        dataArray = newDataArray;
    }

    @Override
    public String toString() {
        return "IntListImpl{" +
                "dataArray=" + Arrays.toString(dataArray) +
                ", count=" + count +
                '}';
    }

    @Override
    public void printTest() {
        System.out.println(Arrays.toString(dataArray));
    }
}