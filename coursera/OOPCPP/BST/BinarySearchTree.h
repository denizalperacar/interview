#ifndef BINARYSEARCHTREE_H
#define BINARYSEARCHTREE_H

#pragma once

template<typename K, typename V>
class BinarySearchTree
{
public:
	BinarySearchTree();
	~BinarySearchTree();

private:
	class TreeNode {
		const K &key;
		const V &value;
		TreeNode *left;
		TreeNode *right;
		TreeNode(const K &key, const V &value) : 
				key(key), value(value), left(nullptr), right(nullptr) {}
	};
	
	TreeNode * _find(const K &key);
	TreeNode root_;
};

#endif