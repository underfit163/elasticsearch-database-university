package rdbms.nosql.nosqlelasticsearch.repositories;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import rdbms.nosql.nosqlelasticsearch.entities.Teacher;

import java.util.UUID;

public interface TeacherRepository extends ElasticsearchRepository<Teacher, UUID> {
}
