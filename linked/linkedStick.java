package linked;

import java.util.EmptyStackException;
import java.util.Scanner;



public class linkedStick<T>{
    int count;
     Node<T> top;
     Node<T> middle;
    public linkedStick(){
        count=0;
        top=null;
    }

    //push//
    public void push(T element){
        Node<T> temp=new Node<>(element);
        temp.setNext(top);
        top=temp;
        count++;
    }

    // size//
    int size(){
        return count;
    }
    boolean IsEmpty(){
        return count==0;
    }
    //pop//
    public T pop(){
        if(IsEmpty()){
            System.out.println("Empty stack");
            return null;
        }

        T removed=top.getElement();
        top= top.getNext();
        count--;
        return removed;
    }
    T peek() {
        if (IsEmpty()) {
            System.out.println("Empty stack");
            return null;
        }
        return top.getElement();
    }


    //display liked elements//

        void display(){
            if(IsEmpty()){
                System.out.println("Empty stack");
            }
            else{
                Node<T> currentAddress= top;
                while(currentAddress!=null){
                    System.out.println(currentAddress.getElement());
                    currentAddress= currentAddress.getNext();
                }

            }
        }
        //search//

        void searchelement(T data){
            boolean found = false;
            int count=0;
            if(IsEmpty()){
                System.out.println("Empty stack");
            }
            else{
                Node<T> currentAddress= top;
                while(currentAddress!=null){
                    if (data.equals(currentAddress.getElement())){
                        found=true;
                        count++;
                    }
                    currentAddress= currentAddress.getNext();
                }

            }
            //display results//
            if (found==false)
                System.out.println("not found");
            else
                System.out.println("found"+count+"times");



        }
    public void removeMiddleElements() {
        if (IsEmpty())
            System.out.println("Stack is empty:");
        else if (count <= 2) {
            System.out.println("Stack has only top and bottom elements does not remave:");
            return;
        }

        // Find the bottom element
        Node<T> current = top;
        Node<T> bottom = top;

        while (bottom.getNext() != null) {
            bottom = bottom.getNext();
        }

        top.setNext(bottom);

        //count= 2;
    }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        linkedStick<String> names=new linkedStick<>();
        names.push("farhio");
        names.push("hassan");
        names.push("saabirin");
        names.push("sara");
        names.push("najmo");
        names.push("muno");

        //System.out.println("size"+names.size());
        //System.out.println("empty"+names.IsEmpty());
        System.out.println("original stack");
        names.display();

        System.out.println("stack after remove middle elements");

        //names.removeElemet();//
        names.removeMiddleElements();
        names.display();

        System.out.println("enter name to search");
        String data = scanner.next();
        names.searchelement(data);




    }






}
