package vn.iotstar.serviceImpl;

import java.util.List;

import vn.iotstar.dao.authorDao_22110446;
import vn.iotstar.daoImpl.authorDaoImpl_22110446;
import vn.iotstar.model.Author_22110446;
import vn.iotstar.service.authorService_22110446;

public class authorSeviceImpl_22110446 implements authorService_22110446{
	authorDao_22110446 dao = new authorDaoImpl_22110446();

	@Override
	public List<Author_22110446> getAuthor()
	{
		return dao.getAuthor();
	}
}
