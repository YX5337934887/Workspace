package org.reflect.entity;

public class PublicEntity {
	Object defaultField;
	private Object privateField;
	protected Object protectedField;
	public Object publicField;
	/*public PublicEntity() {
	}*/
	Object getDefaultField() {
		return defaultField;
	}
	void setDefaultField(Object defaultField) {
		this.defaultField = defaultField;
	}
	
	private Object getPrivateField() {
		return privateField;
	}
	private void setPrivateField(Object privateField) {
		this.privateField = privateField;
	}
	
	protected Object getProtectedField() {
		return protectedField;
	}
	protected void setProtectedField(Object protectedField) {
		this.protectedField = protectedField;
	}
	
	public Object getPublicField() {
		return publicField;
	}
	public void setPublicField(Object publicField) {
		this.publicField = publicField;
	}
}
