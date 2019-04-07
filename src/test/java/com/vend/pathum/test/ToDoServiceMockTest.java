package com.vend.pathum.test;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;


import java.util.Arrays;
import java.util.List;

public class ToDoServiceMockTest {

    @Test
    public void testRetrieveToDos() {
        ToDoService toDoService = Mockito.mock(ToDoService.class);
        List<String> toDos = Arrays.asList("Spring boot", "Spring security", "Hibernate dao");
        Mockito.when(toDoService.retrieveToDos("pathum")).thenReturn(toDos);

        Assert.assertEquals(3, toDoService.retrieveToDos("pathum").size());
        Assert.assertEquals(toDos, toDoService.retrieveToDos("pathum"));

        System.out.println("dff");
    }


    @Test
    public void testBDD() {
        //Given
        List<String> list = Mockito.mock(List.class);
        BDDMockito.given(list.get(Mockito.anyInt())).willReturn("Pathum");

        //When
        list.get(0);

        //Then
        assertThat("Pathum",  is("Pathum"));
    }
}
