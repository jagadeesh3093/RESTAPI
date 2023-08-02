package com.example.demo.excephand;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResourceNotFoundException  extends RuntimeException{
	String ResourceName;
	String FieldName;
	int FieldValue;
	public ResourceNotFoundException(String ResourceName,String FieldName,int FieldValue) {
		super(String.format("%s Not Found With %s :%s",ResourceName,FieldName,FieldValue));
		this.ResourceName=ResourceName;
		this.FieldName=FieldName;
		this.FieldValue=FieldValue;	
	}

}
