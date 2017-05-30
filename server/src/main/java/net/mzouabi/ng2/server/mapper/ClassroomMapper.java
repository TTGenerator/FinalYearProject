package net.mzouabi.ng2.server.mapper;

import net.mzouabi.ng2.server.dto.ClassroomDTO;
import net.mzouabi.ng2.server.model.Classroom;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.TargetType;

/**
 * Created by Jayani on 05/30/17.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClassroomMapper {

    public ClassroomDTO toDTO(Classroom classroom);

    public Classroom toEntity(ClassroomDTO classroom);

    public void mapToEntity(ClassroomDTO classroomDTO, @MappingTarget Classroom classroom);

}
