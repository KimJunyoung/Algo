package listpractice.arraylistprac;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] data;

    public MyArrayList(int initialCapacity){
        data = new Object[initialCapacity];
    }

    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public int size(){
        return size;
    }

    public void add(E element){
        if(size == data.length)
            growCapacity();
        data[size++] = element;
    }

    private void growCapacity(){
        int newCapacity = data.length + (data.length >> 1);
        data = Arrays.copyOf(data, newCapacity);
    }

    public E get(int idx){
        if(idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size " + size);
        return (E) data[idx];
    }

    public void set(int idx, E element){
        if(idx < 0 || idx >= size){
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size " + size);
        }
        data[idx] = element;
    }

    public void insert(int idx, E element){
        if(idx < 0 || idx >= size){
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size " + size);
        }

        if(size == data.length) growCapacity();
        int copyLength = size - idx;
        System.arraycopy(data, idx, data, idx+1, copyLength);
        data[idx] = element;
        size ++;
    }

    public void remove(int idx){
        if(idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("Index: " + idx + ", Size " + size);
        int copyLength = data.length - idx - 1;
        System.arraycopy(data, idx + 1, data, idx, copyLength);
        size --;
    }
}
