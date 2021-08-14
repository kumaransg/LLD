package service.iservice;

import exceptions.ShowAlreadyExistsException;
import exceptions.ShowNotFoundException;
import model.Show;

public interface IShowService {
    Show getShowById(Long id) throws ShowNotFoundException;
    Boolean addShow(Show show) throws ShowAlreadyExistsException;
}
