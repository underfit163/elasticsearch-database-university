package rdbms.nosql.nosqlelasticsearch.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import rdbms.nosql.nosqlelasticsearch.entities.Mark;
import rdbms.nosql.nosqlelasticsearch.entities.Subject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MarkRepository extends ElasticsearchRepository<Mark, UUID> {
    Optional<List<Mark>> searchMarksByExamSubject(Subject subject);
    Optional<List<Mark>> findAllMarkByStudentFio(String fio);


}
