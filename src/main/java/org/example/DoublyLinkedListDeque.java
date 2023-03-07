package org.example;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        DequeNode nuevoNodo = new DequeNode<>(value,null,first);

        if(size == 0){
            first = nuevoNodo;
            last = nuevoNodo;
            size++;
        }else{
            first.setPrevious(nuevoNodo);
            first = nuevoNodo;
            size++;
        }
    }

    @Override
    public void append(T value) {
        DequeNode nuevoNodo = new DequeNode<>(value,last,null);

        if(size == 0){
            first = nuevoNodo;
            last = nuevoNodo;
            size++;
        }else{
            last.setNext(nuevoNodo);
            last = nuevoNodo;
            size++;
        }
    }

    @Override
    public void deleteFirst() {
        if(size > 1){
            first.getNext().setPrevious(null);
            first = first.getNext();
            size--;
        }else if(size == 1){
            first = null;
            last = null;
            size--;
        }
    }

    @Override
    public void deleteLast() {
        if(size > 1){
            last.getPrevious().setNext(null);
            last = last.getPrevious();
        }else if(size == 1){
            first = null;
            last = null;
            size--;
        }
    }

    @Override
    public T first() {
        return first.getItem();
    }

    @Override
    public T last() {
        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }
}
