import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Tree<T> {
    public class Node<T> {
        public T data;
        public List<Node<T>> children;
        public Node<T> parent;
        /**
         * Default ctor.
         */
        public Node() {
            super();
            this.children=new LinkedList<Node<T>>();
        }
        /**
         * Convenience ctor to create a Node<T> with an instance of T.
         * @param data an instance of T.
         */
        public Node(T data) {
            this();
            setData(data);
            this.children=new LinkedList<Node<T>>();
        }
        public Node(T data,Node<T> parent){
            this.data=data;
            this.parent=parent;
            this.children=new LinkedList<Node<T>>();
        }

        /**
         * Return the children of Node<T>. The Tree<T> is represented by a single
         * root Node<T> whose children are represented by a List<Node<T>>. Each of
         * these Node<T> elements in the List can have children. The getChildren()
         * method will return the children of a Node<T>.
         * @return the children of Node<T>
         */
        public List<Node<T>> getChildren() {
            if (this.children == null) {
                this.parent=this;
                return new LinkedList<Node<T>>();
            }
            return this.children;
        }

        Node<T> find(T data) {
            if (this.data.equals(data)) {
                return this;
            }
            for (Node<T> node : children) {
                Node<T> found = node.find(data);
                if (found != null) {
                    return found;
                }
            }
            return null; // Not found.
        }
        /**
         * Sets the children of a Node<T> object. See docs for getChildren() for
         * more information.
         * @param children the List<Node<T>> to set.
         */
        public void setChildren(List<Node<T>> children) {
            this.children = children;
        }
        public void setParent(Node<T> parent){
            this.parent=parent;
        }

        /**
         * Returns the number of immediate children of this Node<T>.
         * @return the number of immediate children.
         */
        public int getNumberOfChildren() {
            if (children == null) {
                return 0;
            }
            return children.size();
        }

        /**
         * Adds a child to the list of children for this Node<T>. The addition of
         * the first child will create a new List<Node<T>>.
         * @param child a Node<T> object to set.
         */
        public void addChild(Node<T> child) {
            if (children == null) {
                children = new LinkedList<Node<T>>();
            }
            children.add(child);
        }

        /**
         * Inserts a Node<T> at the specified position in the child list. Will     * throw an ArrayIndexOutOfBoundsException if the index does not exist.
         * @param index the position to insert at.
         * @param child the Node<T> object to insert.
         * @throws IndexOutOfBoundsException if thrown.
         */
        public void insertChildAt(int index, Node<T> child) throws IndexOutOfBoundsException {
            if (index == getNumberOfChildren()) {
                // this is really an append
                addChild(child);
                return;
            } else {
                children.get(index); //just to throw the exception, and stop here
                children.add(index, child);
            }
        }

        /**
         * Remove the Node<T> element at index index of the List<Node<T>>.
         * @param index the index of the element to delete.
         * @throws IndexOutOfBoundsException if thrown.
         */
        public void removeChildAt(int index) throws IndexOutOfBoundsException {
            children.remove(index);
        }

        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{").append(getData().toString()).append(",[");
            int i = 0;
            for (Node<T> e : getChildren()) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(e.getData().toString());
                i++;
            }
            sb.append("]").append("}");
            return sb.toString();
        }
    } ///İnnerNode
    private Node<T> rootElement;
    /**
     * Default ctor.
     */
    public Tree() {
        super();
       // rootElement=new Node<T>();
    }
    public Tree(T data){
        rootElement=new Node<T>();
        this.rootElement.setData(data);
    }
    public Node<T> find(T data) {
        return rootElement == null ? null : rootElement.find(data);
    }

    public boolean insert(T parentData, T data) {
       // System.out.println("Data:"+data);
        Node<T> found = find(parentData);
        if (found == null) {
            Node<T> found1=new Node<T>();
            found1.getChildren().add(new Node(data));
            return true;
        }
        found.getChildren().add(new Node(data));
        return true;
    }
    /**
     * Return the root Node of the tree.
     * @return the root element.
     */
    public Node<T> getRootElement() {
        return this.rootElement;
    }

    /**
     * Set the root Element for the tree.
     * @param rootElement the root element to set.
     */
    public void setRootElement(Node<T> rootElement) {
        this.rootElement = rootElement;
    }

    /**
     * Returns the Tree<T> as a List of Node<T> objects. The elements of the
     * List are generated from a pre-order traversal of the tree.
     * @return a List<Node<T>>.
     */
    public List<Node<T>> toList() {
        List<Node<T>> list = new ArrayList<Node<T>>();
        walk(rootElement, list);
        return list;
    }

    /**
     * Returns a String representation of the Tree. The elements are generated
     * from a pre-order traversal of the Tree.
     * @return the String representation of the Tree.
     */
    public String toString() {
        return toList().toString();
    }

    /**
     * Walks the Tree in pre-order style. This is a recursive method, and is
     * called from the toList() method with the root element as the first
     * argument. It appends to the second argument, which is passed by reference     * as it recurses down the tree.
     * @param element the starting element.
     * @param list the output of the walk.
     */
    private void walk(Node<T> element, List<Node<T>> list) {
        list.add(element);
        for (Node<T> data : element.getChildren()) {
            walk(data, list);
        }
    }
} //Tree
