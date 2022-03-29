package linkedList;

public class Inspiration {




    public static void main(String[]args){
        ListItem<Integer> test = new ListItem<>();
        Integer[] arr = {1,20,30,4,5,60,7};
        test.autoFill(arr);
        System.out.println(test.toString());


    }

}
