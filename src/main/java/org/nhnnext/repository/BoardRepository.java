package org.nhnnext.repository;

import org.nhnnext.web.PhotoBoard;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<PhotoBoard, Long>{

}
