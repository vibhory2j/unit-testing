package com.vibhor.testing.unittesting.business;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.ArgumentCaptor.*;

public class ListMockTest {
	
	ArrayList mock = mock(ArrayList.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnParameterValues() {
		when(mock.get(0)).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
	}
	
	@Test
	public void returnGenericParameterValues() {
		when(mock.get(anyInt())).thenReturn("in28Minutes");
		assertEquals("in28Minutes", mock.get(0));
		assertEquals("in28Minutes", mock.get(34));
	}
	
	@Test
	public void verificationBasics() {
		//SUT
		String value = (String) mock.get(0);
		String value2 = (String) mock.get(1);
		
		//Verify
		verify(mock).get(0);
		verify(mock).get(anyInt());
		verify(mock, times(2)).get(anyInt());
	}
	
	@Test
	public void argumentCapturing() {
		//SUT
		mock.add("SomeString");
		
		//Verify
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("SomeString", captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing() {
		//SUT
		mock.add("SomeString1");
		mock.add("SomeString2");
		mock.add("SomeString3");
		
		//Verify
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(3)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
	}
	
	@Test
	public void spying() {
		
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));
		System.out.println(arrayListSpy.size());
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());
		
		verify(arrayListSpy).add("Test4");
	}

}
