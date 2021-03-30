package com.example;

import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;

class EmployeeManagerTest {


    public static void main(String[] args) {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("This list does not really exist");
        System.out.println(mockedList.get(0));
    }
}