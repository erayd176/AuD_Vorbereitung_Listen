package linkedList;

import java.util.List;
import java.util.Objects;

public class Inspiration {

    static <T> boolean find(ListItem<T> list, T key){
        if(list==null){
            return false;
        }
        ListItem<T> p = list;
        while (p!=null){
            if(p.key==key){
                return true;
            }
            p=p.next;
        }

        return false;
    }

    static <T> boolean overwrite(ListItem<T> list, T key, T o){
        if(list==null)
            return false;

        ListItem<T> p = list;
        while(p!=null){
            if(p.key==o){
                p.key=key;
                return true;
            }
            p = p.next;
        }
        return false;
    }

    static <T> boolean overwriteAll(ListItem<T> list, T key, T o){
        if(list==null)
            return false;
        boolean isThere = false;
        while (list!=null){
            if(list.key==o){
                isThere = true;
                list.key = key;
            }
            list = list.next;
        }
        return isThere;
    }

    static <Integer> ListItem<Integer> inFlat (ListItem<ListItem<Integer>> listOfLists, Integer i){
        if(listOfLists==null){
            return null;
        }
        ListItem<Integer> head = null;
        ListItem<Integer> tail = null;
        ListItem<ListItem<Integer>> p = listOfLists;

        while (p!=null){
            ListItem<Integer> listInList = p.key;
            ListItem<Integer> tmp = new ListItem<>();
            tmp.key = listInList.key;
            while(listInList!=null){
                if(head==null){
                    head = tail = tmp;
                }else{
                    tail.next = new ListItem<>();
                    tail = tail.next;
                    tail.key = listInList.key;
                }
                if(listInList.next==null&&(int)listInList.key%5==0){
                    tail.next = new ListItem<>();
                    tail = tail.next;
                    tail.key = i;
                }
                listInList = listInList.next;
            }

            p=p.next;
        }
        return head;
    }

    public static void main(String[]args){
        ListItem<Integer> test = new ListItem<>();
        Integer[] arr = {1,20,30,4,20,60,20};
        test.autoFill(arr);
        System.out.println(test.toString());
        System.out.println("ist eine 6 in test? "+ find(test,6)+" und 20? wenn 1234 replace  "+overwriteAll(test,1234,20));

        System.out.println(test.toString());
    }

}
