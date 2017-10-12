package com.pwi.data;

import java.util.List;

public interface DataDao {

	public <T> Integer add(T product);

	public <T> List<T> getList();

	public <T> void getById(Integer id);

	public <T> Integer update(T id);

	public Integer delete(Integer id);

}
