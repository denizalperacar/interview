#pragma once

#include <iostream>

template <typename T>
class Queue {
  public:

		void push_back(const T &item) {
			Node *node = new Node(item);
			if (head_ == nullptr && tail_ == nullptr) {
				tail_ = node;
				head_ = tail_;
			}
			else {
				node->prev = head_;
				head_->next = node;
				head_ = node;
			}
		}

		T pop_front() {
			T data = tail_->data;
			Node *nextNode = tail_->next; 
			nextNode->prev = nullptr;
			delete tail_; tail_ = nextNode;
			return data;
		}

		friend std::ostream &operator<<(std::ostream& os, const Queue &q) {

			Node* start = q.tail_;
			while (start != nullptr) {
				os << start->data << " ";
				start = start->next;
			}
			return os;
		} 

  	Queue(): tail_(nullptr), head_(nullptr) {}
		
		~Queue() {
			Node* start = this->tail_;
			Node* current = start;
			while (start != nullptr) {
				start = start->next;
				delete current; current = nullptr;
				current = start;
			}
		}

	private:
		class Node {
			public:
				T data;
				Node *next;
				Node *prev;
				Node(const T &data): data(data), next(nullptr), prev(nullptr) {};
		};

		Node *tail_;	
		Node *head_;
};