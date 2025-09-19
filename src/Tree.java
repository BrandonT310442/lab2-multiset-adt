import java.util.ArrayList;

public class Tree {
    // We recommend attempting this class last, as it hasn't been scaffolded for your team.
    // Even if your team doesn't have time to implement this class, it is a useful exercise
    // to think about how you might split up the work to get the Tree and TreeMultiSet
    // implemented.


    private Integer root;
    private ArrayList<Tree> subtrees;

    public Tree() {
        this.root = null;
        this.subtrees = new ArrayList<>();
    }

    public Tree(int root) {
        this.root = root;
        this.subtrees = new ArrayList<>();
    }

    public Tree(int root, ArrayList<Tree> subtrees) {
        this.root = root;
        this.subtrees = subtrees;
    }

    public void setRoot(int value) {
        this.root = value;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int length() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int count = 1;
            for (Tree subtree  : this.subtrees) {
                count += subtree.length();
            }
            return count;
        }
    }

    public int count(int value) {
        if (this.isEmpty()) {
            return 0;
        } else {
            int count = this.root == value ? 1 : 0;
            for (Tree subtree  : this.subtrees) {
                count += subtree.count(value);
            }
            return count;
        }
    }

    public void add(int item) {
        this.subtrees.add(new Tree(item));
    }

    public void remove(int value) {
        if (this.isEmpty()) {
            return;
        }

        if (this.root.equals(value)) {
            this.removeRoot();
            return;
        }

        Tree target = null;
        for (Tree subtree : this.subtrees) {
            if (subtree.root == value) {
                target = subtree;
                break;
            }
            subtree.remove(value);
        }

        if (target != null) {
            this.subtrees.addAll(target.subtrees);
            this.subtrees.remove(target);
        }
    }

    public void removeRoot() {
        if (this.subtrees.isEmpty()) {
            this.root = null;
        } else {
            this.root = this.subtrees.getFirst().root;
            this.subtrees.removeFirst();
        }
    }

    public void toString(Tree node) {
        if (node == null) return;

        System.out.print(node.root + " ");

        for (Tree child : node.subtrees) {
            toString(child);
        }
    }
}
