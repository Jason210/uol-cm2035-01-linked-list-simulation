package LinkedLists;

public class LList
{
    int head;
    Vmemory memory;
    
    int [] address = {0, 5, 10, 13, 14}; // These are arbitrary "memory" addresses
    int index = 0;

    LList(Vmemory memory, int head)
    {
        this.head = head;
        this.memory = memory;
        System.out.println("In LList class.");
        System.out.println("Creating new Linked List in the memory block:");
        System.out.println("start: " + memory.start);
        System.out.println("end: " + memory.end);
        System.out.println("head: " + head);
        System.out.println("");

        if (head < memory.start || head > memory.end)
        {
            System.out.println("Head is " + head);
            System.out.println("Head address is out of range. It must be within memory block.");
            System.exit(1);
        }       
    }
   
    void insertAtHead(int x)
    {
        System.out.println("Calling insertAtHead using value: " + x);
        
        Node newNode = new Node(x); // create new object carrying value x        
                
        if (memory.node[head] != null)
        {        
            newNode.next = head; // set the new object's 'next' field to the original 'head' value of the linked list object
        }
        head = address[index]; // set this list's head value to new object memory location. This memory location is abitrary.   
        index = index + 1;
        
        memory.node[head] = newNode; // assign new object to array
    }
   
    // see 7.103 Linked lists: Delete operation
    // uses model based on 'prev' and 'temp'
    void delete(int x)
    {
        System.out.println("Calling delete() on value " + x);
        Node temp =  memory.node[head]; // now temp and memory.node[head] point to same data
        Node prev;
        
        if (temp == null)
        {
            System.out.println("There is nothing to delete.");
            return;
        }

        if (temp.value == x)
        {
            head = temp.next; // special case for if value is in head
            System.out.println(x + " has been found in head");
        }
        else
        {
            // move on to next objects in list
            prev = temp; 
            temp = memory.node[temp.next];
            
            while (temp != null)
            {
                if (temp.value == x)
                {
                    System.out.println("Value found and deleted.");
                    prev.next = temp.next; // remember temp.next points to original object                                     
                    return;
                }
                prev = temp; // move
                if (temp.value != x && temp.next == null) // check if at tail 
                {
                    System.out.println(x + " is not Present in the list.");
                    return;
                }
                temp = memory.node[temp.next];
            }
        } 
    }
        
    void search(int x)
    {
        System.out.println("Searching for value " + x);
        Node temp =  memory.node[head]; // now temp and memory.node[head] point to same data
        Node prev;
        
        if (temp == null)
        {
            System.out.println("The list is empty.");
            return;
        }

        if (temp.value == x)
        {
            System.out.println(x + " has been found in head, address " + head);
        }
        else
        {
            // move on to next objects in list
            prev = temp; 
            temp = memory.node[temp.next]; // move on
            
            while (temp != null)
            {
                if (temp.value == x)
                {
                    System.out.println("Value found at address " + prev.next);                                  
                    return;
                }
                prev = temp;
                if (temp.value != x && temp.next == null) // check if we are at tail 
                {
                    System.out.println(x + " is not Present in the list.");
                    return;
                }
                temp = memory.node[temp.next]; // move on
            }
        }
    }
    
    void displayList()
    {
        System.out.println("Displaying linked-list...");
        System.out.println("Current head address: " + head);
        int i = head;
        
        if (memory.node[i] == null)
        {
            System.out.println("List is empty."); 
            return;
        }
        
        while (memory.node[i].next != null)
        {
            System.out.println(memory.node[i].value); 
            i = memory.node[i].next;
        }
        System.out.println(memory.node[i].value); 
    }
    
    void displayMemory()
    {
        System.out.println("In displayMemory() method");
        System.out.println("Displaying memory block...");
        System.out.println("Current head address: " + head);
        for (int i = 0; i < 16; i++)
        {
            if (memory.node[i] != null)
            {
                System.out.print(memory.node[i].value + "," + memory.node[i].next + "  ");
            }
            else
            {
                System.out.print("null  ");
            }
        }
        System.out.println("");
        System.out.println("");
    }
}
