package javam.shivendra;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

// ArrayList, LinkedList Not Synchronized
// Vector Synchronized , as Stack is subclass of vector so it is also synchronized

public class Collections {
    public static void listInterface() {
        // Not synchronized
        ArrayList<Integer>l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.addAll(l);
        l.remove(0);
        l.remove(Integer.valueOf(3));
        System.out.println(l.contains(3));
        System.out.println(l.hashCode());
        System.out.println(l.toString());

        Iterator x = l.iterator();
        while(x.hasNext()) {
            System.out.println(x.next());
        }

        // Synchronized
        Vector<Integer>v = new Vector<>();
        v.addElement(1);
        v.removeElement(0);

        Iterator x1 = v.iterator();
        while(x1.hasNext()) {
            System.out.println(x1.next());
        }
    }

    public static void stack() {
        Stack<Integer>s = new Stack<>();
        s.push(1);
        s.pop();
        s.peek();

        Iterator sI = s.iterator();
        while(sI.hasNext()) {
            System.out.println(sI.next());
        }
    }

    public static void queue() {

        // Iterator applicable to all
        Queue<Integer>q = new LinkedList<>();
        q.add(1);
        q.peek();
        q.poll();

        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addLast(2);
        dq.removeFirst();
        dq.getFirst();
        dq.getLast();
        dq.contains(2);

        Queue<Integer>cq = new ConcurrentLinkedQueue<>();
        cq.add(1);
        cq.peek();
        cq.poll();

        Queue<Integer>pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        pq.poll();
        pq.peek();

        // Priority Queue with comparator
        Queue<Integer>minpq = new PriorityQueue<>((a,b) -> a-b);
        // max heap
        Queue<Integer>maxpq = new PriorityQueue<>((a,b) -> b-a);

    }

    public static void setInterface() {
        Set<Integer>hashSet = new HashSet<>(); // unordered set
        Set<Integer>linkedSet = new LinkedHashSet<>();
        SortedSet<Integer>treeSet = new TreeSet<>((a,b) -> a-b); // ordered set with comparator
        hashSet.add(1);
        hashSet.add(2);
        treeSet.add(1);
        treeSet.add(2);

        Iterator it1 = treeSet.iterator();
        Iterator it2 = hashSet.iterator();

        while(it1.hasNext() && it2.hasNext()) {
            System.out.println(it1.next());
            System.out.println(it2.next());
        }

    }

    public static void mapI() {
        Map<Integer, Integer>m = new HashMap<>(); // unordered map
        Map<Integer, Integer>lm = new LinkedHashMap<>(); // maintains insertion order
        Map<Integer, Integer>tm = new TreeMap<>(); // ordered map
        tm.put(1, 1);
        m.put(1,1);
        tm.get(1);
        m.get(1);

        Iterator it1 = m.keySet().iterator();
        while(it1.hasNext()) {
            System.err.println(m.get(it1.next()));
        }

        for(Map.Entry<Integer, Integer> e : m.entrySet()) {
            System.err.println(e.getKey() + " : " + e.getValue());
        }
    }


    public static void main(String[] args) {
        listInterface();
        stack();
        queue();
        setInterface();
        mapI();
    }
}


/**    Collection Interface  functions     **/


/*
 No.
public boolean add(E e)
It is used to insert an element in this collection.

public boolean addAll(Collection<? extends E> c)
It is used to insert the specified collection elements in the invoking collection.

public boolean remove(Object element)
It is used to delete an element from the collection.

public boolean removeAll(Collection<?> c)
It is used to delete all the elements of the specified collection from the invoking collection.

default boolean removeIf(Predicate<? super E> filter)
It is used to delete all the elements of the collection that satisfy the specified predicate.

public boolean retainAll(Collection<?> c)
It is used to delete all the elements of invoking collection except the specified collection.

public int size()
It returns the total number of elements in the collection.

public void clear()
It removes the total number of elements from the collection.

public boolean contains(Object element)
It is used to search an element.

public boolean containsAll(Collection<?> c)
It is used to search the specified collection in the collection.

public Iterator iterator()
It returns an iterator.

public Object[] toArray()
It converts collection into array.

public <T> T[] toArray(T[] a)
It converts collection into array. Here, the runtime type of the returned array is that of the specified array.

public boolean isEmpty()
It checks if collection is empty.

default Stream<E> parallelStream()
It returns a possibly parallel Stream with the collection as its source.

default Stream<E> stream()
It returns a sequential Stream with the collection as its source.

default Spliterator<E> spliterator()
It generates a Spliterator over the specified elements in the collection.

public boolean equals(Object element)
It matches two collections.

public int hashCode()
It returns the hash code number of the collection.
 */

 /*********************************      Iterator Interface         ******************* */

 /*

public boolean hasNext()
It returns true if the iterator has more elements otherwise it returns false.

public Object next()
It returns the element and moves the cursor pointer to the next element.

public void remove()
It removes the last elements returned by the iterator. It is less used.
  */


/*Iterable Interface
The Iterable interface is the root interface for all the collection classes. 
The Collection interface extends the Iterable interface and 
therefore all the subclasses of Collection interface also implement the Iterable interface.

It contains only one abstract method. i.e.,

Iterator<T> iterator()  
It returns the iterator over the elements of type T. */

/*Collection Interface
The Collection interface is the interface which is implemented by all the classes in the collection framework. 
It declares the methods that every collection will have. In other words,
we can say that the Collection interface builds the foundation on which the collection framework depends.

Some of the methods of Collection interface are Boolean add (Object obj), Boolean addAll (Collection c), 
void clear(), etc. that are implemented by all the subclasses of Collection interface. 
*/

/*
 * Queue Interface
        Queue interface maintains the first-in-first-out order. 
        It can be defined as an ordered list that is used to hold the elements which are about to be processed. 
        There are various classes like PriorityQueue, Deque, and ArrayDeque which implements the Queue interface.
 */

