package linkedList;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListItem<T> {

    public T key;
    public ListItem<T> next;

    public ListItem(T key) {
        this.key = key;
    }
    public ListItem() { }
    @Override
    public String toString() {
        return "(" + Stream.iterate(this, i -> i != null, i -> i.next).map(i -> i.key).map(Objects::toString).collect(Collectors.joining(",")) + ")";
    }
    public void autoFill(T[] t){
        ListItem<T> p = this;
        for(int i = 0; i<t.length; i++)
            p.add(t[i]);
    }

    public void add(T key){
        if(key==null||this==null){
            return;
        }
        if(this.key == null){this.key = key; return;}

        ListItem<T> p = this;
        while(p.next!=null){
            p=p.next;
        }
        p.next = new ListItem<>(key);
    }

    public static void main(String[]args){
        ListItem<Integer> test = new ListItem<>();
        Integer[] arr = {1,20,30,4,5,60,7};
        test.autoFill(arr);
        System.out.println(test.toString());
    }
}
