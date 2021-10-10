package LinkedLists;

public class Test
{
    public static void main(String[] args)
    {
        Vmemory m1 = new Vmemory(0, 64);
        
        LList list1 = new LList(m1, 0);
        list1.insertAtHead(7);   
        list1.insertAtHead(9);
        list1.insertAtHead(12);
        list1.insertAtHead(17);
        list1.insertAtHead(23);
        list1.displayMemory();
        list1.displayList();
        list1.delete(7);
        list1.displayList();
        list1.displayMemory();
        list1.search(9);
        list1.displayMemory();
        list1.displayList();
    }
}
