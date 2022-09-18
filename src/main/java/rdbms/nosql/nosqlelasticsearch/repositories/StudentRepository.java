package rdbms.nosql.nosqlelasticsearch.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import rdbms.nosql.nosqlelasticsearch.entities.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends ElasticsearchRepository<Student, UUID> {
     Optional<List<Student>> findStudentsByFioContaining(String fio);
}
