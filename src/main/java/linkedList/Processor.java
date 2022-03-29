package linkedList;

public class Processor {

    static <Integer> ListItem<ListItem<Integer>> alwaysGreater(ListItem<Integer> list){
        if(list==null){
            return null;
        }
        ListItem<Integer> p = list;
        ListItem<ListItem<Integer>> head = new ListItem<>();
        head.key = new ListItem<>();
        head.key.key = p.key;
        ListItem<Integer> listInList = head.key;
        ListItem<ListItem<Integer>> tail = head;

        while (p.next!=null) {
            int i1 = (int) p.key;
            int i2 = (int) p.next.key;

            if (i1 < i2) {
                listInList.next = new ListItem<>();
                listInList = listInList.next;
                listInList.key = p.next.key;
            }else{
                tail.next = new ListItem<ListItem<Integer>>();
                tail = tail.next;
                tail.key = new ListItem<>();
                listInList = tail.key;
                listInList.key = p.next.key;

            }
            p = p.next;
        }


        return head;
    }

    static <Integer> ListItem<Integer> makeFlatList(ListItem<ListItem<Integer>> list){
        ListItem<ListItem<Integer>> p = list;
        ListItem<Integer> head = null;
        ListItem<Integer> tail = null;
        if(p==null)
            return null;

        while(p!=null){
            ListItem<Integer> listinlist = p.key;
            while(listinlist!=null){
                ListItem<Integer> tmp = new ListItem<>();
                tmp.key = listinlist.key;
                if(head == null){
                    head = tail = tmp;
                }else{
                    tail.next = tmp;
                    tail = tail.next;
                }
                listinlist = listinlist.next;
            }
            if(p.next!=null) {
                tail.next = new ListItem<>();
                tail = tail.next;
                tail.key = null;
            }
            p=p.next;
        }
        return head;
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
        Integer[] arr = {1,20,30,4,5,60,7,15};
        test.autoFill(arr);
        System.out.println(test.toString());
//here comes Greater Test
        ListItem<ListItem<Integer>> test2;
        test2 = alwaysGreater(test);
        System.out.println(test2.toString());
        ListItem<Integer> test5 = inFlat(test2,31);
        //here comes makeFlatList
        //ListItem<Integer> test3;
        //test3 = makeFlatList(test2);
        System.out.println(test5.toString());
    }

}
