package vn.iotstar.serviceImpl;

import java.util.List;

import vn.iotstar.dao.bookDao_22110446;
import vn.iotstar.daoImpl.bookDaoImpl_22110446;
import vn.iotstar.model.Book_22110446;
import vn.iotstar.service.bookService_22110446;

public class bookServiceImpl_22110446 implements bookService_22110446 {
	bookDao_22110446 dao = new bookDaoImpl_22110446();
	
	@Override
	public List<Book_22110446> getBookByAuthorId(int id)
	{
		return dao.getBookByAuthorId(id);
	}
	
}
