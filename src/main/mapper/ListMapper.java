package main.mapper;

import main.dto.ListDTO;
import main.model.List;
import org.mapstruct.Mapper;

@Mapper
public interface ListMapper {
    ListDTO toListDTO(List list);

    List toList(ListDTO listDTO);
}
