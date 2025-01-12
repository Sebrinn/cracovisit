package com.cracovisit.data;

import java.util.List;
import java.util.Optional;


public interface DataAccessInterface <T, A>{
	
	public T getByID(long id);
	public List<T> getAll();
	public List<T> search(A searchTerm);
	public long addNew(T e);
	public boolean deleteByID(long id);
	public T updateByID(T e, long id);
	public Optional<T> getByUniqueValue(A value);

}
