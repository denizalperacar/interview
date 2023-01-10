# Trees

The next three weeks of the course are about trees.

## Contents

- Tree terminology
- Binary tree
- Tree Traversals
- Binary search tree
- BST analysis
- Balanced BST
- AVL tree
- B-Tree insert, search
- heap, insert, remove min, build heap, runtime analysis

A tree us linked structure with ancestory information.

## Terminology of trees

- every element in a tree is denoted as node
- each connection is refered to as a edge
- the edges are directed from root to leafs

- Tree **root**: A tree must have a single root and no edge is directed to the root.

- Tree **leafs** nodes that contain no outgoing edges.

- In a tree `Nodes` contain the data.
- While the `edges` dont store any data.
- every node except the root node has a `parent`.
- nodes `children` are nodes that have that node as thier parent.

For a tree the following must be true:

- the tree must have a root.
- the tree must have directed edges.
- the tree must not contain any loops.

A tree is a `rooted`, `directed`, and `acyclic` structure.

## Binary Trees

A binary tree is a tree that each node has atmost two children.

- A `left` and `right` child is defined for each node in the tree.

Basic signature of a tree is shown below:

```Cpp
template <typename T>
class BinaryTree {
    public:
        // ...
    private:
        class TreeNode {
            public:
                T &data;
                TreeNode *left, *right;
                TreeNode(T &data) : 
                    data(data), left(nullptr), right(nullptr) {} 
        };
        TreeNode *root_;
};
```

### height of a bionary tree

The `height` of a tree a the number of `edges` in the longest path from the `root` to the `leafs`.

### Tree traversals

lets assune there are three following actions for traversal:

- traverse left
- traverse right
- shout

acording to how one does the shout there are three different traversals. which are:

- preorder traversal

```Cpp
void BinaryTree<T>preorder(TreeNode * cur) {
    if (cur != nullptr) {
        shout();
        preorder(cur->right);
        preorder(cur->left);
    }
}
```

- inorder traversal
- It is the exact way how things go in a tree

```Cpp
void BinaryTree<T>inorder(TreeNode * cur) {
    if (cur != nullptr) {
        inorder(cur->right);
        shout();
        inorder(cur->left);
    }
}
```

- postorder traversal

```Cpp
void BinaryTree<T>postorder(TreeNode * cur) {
    if (cur != nullptr) {
        postorder(cur->right);
        postorder(cur->left);
        shout();
    }
}
```

- level order traversal

traverses each layer then goes down.

- For all the traversals all the nodes are visited while in a search only a subset of nodes is visited.

## Binaty Search Tree

It is used as a search structure. It follows a set of ranking instructions to order its nodes.

- Dictionary is one example of BST use case.

### API of BST

- find
- insert
- remove
- empty

#### find

- Traverse the tree to find the address where the key must be
- check the key if it exists.

#### insert

- find the location for the key
- insert at the found location

#### remove

This operation is a bit more complicated. It is divided into three types.

- find the location of the key
- if key has no child remove it and return the data
- if it has a child: remove the child and conenct the parent to the child.
- if it has two children do the following:

```Cpp
// find the closest value below it by inorder traversal.
// sap the current node and the inorder predecessor.
// remove the current element that is swapped.
```

## Balancing trees

A tree that its height balance factor is either 1, 0, -1

### Height balance factor

- The height balance factor `b` of a node is the difference in height between its subtrees.
- $b = H(R) - H(l)$
- let the non existing child has a height(cur) = -1.

### Balanced BST

The trees that are height balanced.

- `mountain` a node that has one right and one left child
- `stick` a node that has two children in the same direction.
- `elbow` the strufcture had b = 2 but is not 'stick` i.e. the children alternate.

The idea is to transform sticks to mountains by a BST rotation.

- generic left rotation

> - find the deepest point of imbalance.
> - the current node has a balance factor of 2. b
> - Its right node has the balance factor of 1. c
> - let parent of b be a and right child of c be d.
> - conenct a->right to c. (lift c)
> - connect b->right to c->left.
> - connect c->left to b.

- if there is an elbow unbend it by swapping intemediate parent and its child node to create a stick.

- generic right-left rotation

> - if balance factor of b is 2 and c is -1 then the right left rotation is performed.
> - connect b->right to c->left to d->right
> - connect d->right to c

### rotation summary

- left rotation: b = 2, c = 1
- right rotation: b = -2, c = -1
- right left rotation: b = 2, c = -1
- left right rotation: b = -2, c = 1

## AVL Tree

The trees that updated by these rotations is called `AVL tree`

- all the rotations are performed locally.
- the rotations do not affect the broader tree.
- rotation run time is O(1).

There are some simple modifications done on the BST to obtain AVL tree.

- add a variable for height of each node.

> - when a node is added/removed update the height of each elements it passes from.

- do some simple extra work for the insertion and remove operations.

