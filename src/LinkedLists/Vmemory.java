package LinkedLists;

public class Vmemory
{
    int size;
    Node [] node;
    int start;
    int end;
    
    Vmemory(int start, int size)
    {
        this.size = size;
        this.start = start;
        this.end = start + size - 1;
        node = new Node[this.size];
        System.out.println("In Vmemory class");
        System.out.println("Creating new memory block...");
        System.out.println("New memory block allocated beginning at " + start + " with size " + this.size);
        System.out.println("");
    }
    
    int peek(String address)
    {
        return 0;
    }   
    
    void poke(String address, int value)
    {
        
    }
    
    int convert(String hex)
    {
        int index = hex.indexOf("x"); 
        hex = hex.substring(index + 1, index + 3); // remove 0x from start
        return Integer.parseInt(hex, 16); // convert to decimal
    }
}
