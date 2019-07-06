package com.zipcodewilmington.singlylinkedlist;

import javax.xml.soap.Node;

/**
 * Created by leon on 1/10/18.
 */
    public class SinglyLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {

            data = d;
            next = null;
        }
    }

    public static SinglyLinkedList Insert(SinglyLinkedList list, int data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }

        return list;
    }

    public static void printList(SinglyLinkedList list) {
        Node currNode = list.head;
        System.out.print("SinglyLinkedList: ");

        while (currNode != null) {
            System.out.print(currNode.data + " ");

            currNode = currNode.next;
        }
    }

    public static SinglyLinkedList removeByKey(SinglyLinkedList list, int key) {
        Node currNode = list.head, prev = null;

        if (currNode != null && currNode.data == key) {
            list.head = currNode.next;

            System.out.println(key + " found and deleted");
            return list;
        }

        while (currNode != null && currNode.data != key) {
            prev = currNode;
            currNode = currNode.next;
        }

        if (currNode != null) {
            prev.next = currNode.next;

            System.out.println(key + " found and deleted");
        }

        if (currNode == null) {
            System.out.println(key + " not found");
        }
        return list;
    }

    public static SinglyLinkedList removeByIndex(SinglyLinkedList list, int index) {
        Node currNode = list.head, prev = null;

        if (index == 0 && currNode != null) {
            list.head = currNode.next;

            System.out.println(index + " position element deleted");
            return list;
        }

        int counter = 0;

        while (currNode != null) {
            if (counter == index) {
                prev.next = currNode.next;
                System.out.println(index + " position element deleted");
                break;
            } else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if (currNode == null) {
            System.out.println(index + " position element deleted");
        }
        return list;
    }

    public static Boolean contains(SinglyLinkedList list, int data) {
        Node currNode = list.head;

        while (currNode != null) {
            if (currNode.data == data) {
                return true;
            } else {
                currNode = currNode.next;
            }

        }
        return false;
    }

    public static Integer find(SinglyLinkedList list, int data) {
        Node currNode = list.head;

        while (currNode != null) {
            if (currNode.data == data) {
                return currNode.data;
            } else {
                currNode = currNode.next;
            }

        }
        return -1;
    }
}