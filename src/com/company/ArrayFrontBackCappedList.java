
import java.util.*;

public class ArrayFrontBackCappedList <T>  implements FrontBackCappedListInterface <T>{
    private T[] list;
    private int numberOfElements;

    /*
(3 points) constructor(int)
take in the maximum size (capacity) as a parameter
* */
    public ArrayFrontBackCappedList(int capacity){
        list = (T[]) new Object[capacity];
        numberOfElements = 0;
    }
    // end of constructor
    /*  (4 points) String toString()
see the driver program for the format of the text representation
your display must match this format!
    *
    *
    * */
    public String toString() {
        String n = "Size = " + numberOfElements + "; capacity = " + list.length + "; [";
        if (numberOfElements <= 0) {
            n += "]";
        } else {
            int i = 0;
            while (i < numberOfElements - 1) {
                n += list[i] + ", ";
                i++;
            }
            n += list[numberOfElements - 1] + "]";
        }
        return n;
    }
    // end of toString() method;


/*
*  boolean addBack(T)
when there is room to add an element, the new element is added to the end of the list and true is returned
when the list is full, no changes are made to the array and false is returned
*
* */
    public boolean addBack (T newEntry) {
        if (isFull()){
            return false;
        }
        list[numberOfElements++]=newEntry;
        return true;

    }
    // end of addBack() method
/*
* ) boolean addFront(T)
when there is room to add an element, the current elements in the list
* are shifted to make room and the new
*  element is added to the beginning of the list; true is returned
*
* */
    public boolean addFront (T newEntry) {
        if (isFull()){
            return false;
        }
        for (int i = numberOfElements - 1; i >= 0; i--){
            list[i+1] = list[i];
        }
        numberOfElements++;
        list[0] = newEntry;
        return true;
    }
 // end of addFront Method.
/*
* T removeBack()
null is returned from an empty list
*
*
* */
    public T removeBack () {
        if (isEmpty()){ // check is the list is empthy firts
            return null;
        }
        T removeBack = list[numberOfElements -1];
        list[numberOfElements - 1] = null;
        numberOfElements--;
        return removeBack;
    }
    // end of removeBack()
/*
*
*  T removeFront()
elements in the list are shifted down after the element is removed from the front
null is returned from an empty list
*
*
* */

    public T removeFront () {
        if (isEmpty()){
            return null;
        }
        T removeFront = list[0];
        for (int i = 0; i < numberOfElements -1; i++){
            list[i] = list[i+ 1];
        }
        numberOfElements--;
        return removeFront;
    }
// end of removeFront() method

    //
    public boolean contains (T anEntry) {
        int i = 0;
        while (i < numberOfElements) {
            if (list[i].equals(anEntry)){
                return true;
            }
            i++;
        }
        return false;
    }


    public int indexOf (T anEntry) {
        int index = 0;
        if (contains(anEntry) != false) {
            for (int i = 0; i < numberOfElements; i++) {
                if (list[i].equals(anEntry)) {
                    return index;
                }
                index++;
            }
            return index;
        } else {
            return -1;
        }
    }


    public int lastIndexOf (T anEntry) {
        int index = numberOfElements -1;
        if (contains(anEntry) == false){
            return -1;

        }
        int i = numberOfElements - 1;
        while (i >=0) {
            if (!list[i].equals(anEntry)) {
                index--;
                i--;
            } else {
                return index;
            }
        }
        return index;
    }


    public T getEntry (int givenPosition) {
        if (!isEmpty() && givenPosition <= list.length && givenPosition >= 0) {
            return list[givenPosition];
        }
        return null;
    }


    public void clear () {
     int sizeMaxim = list.length;
     list = (T[]) new Object[sizeMaxim];
     numberOfElements = 0;
    }


    public boolean isEmpty () {
        return numberOfElements == 0;
    }


    public boolean isFull () {
        return numberOfElements >= list.length;
    }


    public int size () {
        return  numberOfElements;
    }
    //Finished with style
}