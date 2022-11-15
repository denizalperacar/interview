#pragma once

#include <iostream>

template<typename T> class LinkedList;

template<typename T> std::ostream & operator<<(
	std::ostream os, 
	LinkedList<T> const &list
);

template<typename T>
class LinkedList
{
	public:
		// get the element at index `index`
		const T & operator[](unsigned index) {
			Node *node = head_;
			while (index > 0 && node->next != nullptr) {
				node = node->next;
				index--;
			}
			return node->data;
		}

		// add new elements
		void push_front(const T & data) {
			Node *newNode = new Node(data);
			newNode->next = head_;
			head_ = newNode;
			size_++;
		} 

		// allow cout
		friend std::ostream & operator<<(
				std::ostream &os, 
				const LinkedList<T> &list) {
			Node *node = list.head_;
			os << "Linked List: ";
			while (node != nullptr) {
				os << node->data << " ";
				node = node->next;
			}
			os << std::endl;
			return os;
		} 

		// get current size
		unsigned size() {
			return size_;
		}
		
		LinkedList() : head_(nullptr) {}
		
		~LinkedList() { 
			Node * node = head_;
			while (node != nullptr) {
				Node * toDelete = node;
				node = node->next;
				delete toDelete; toDelete = nullptr;
			}
		}

	private:
		class Node {
			public:
				T data;
				Node *next;
				Node(const T data): data{data}, next{nullptr} {}
		};

		Node *head_;
		unsigned size_ = 0;
};