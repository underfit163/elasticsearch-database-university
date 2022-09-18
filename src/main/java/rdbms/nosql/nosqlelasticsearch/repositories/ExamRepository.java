package rdbms.nosql.nosqlelasticsearch.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import rdbms.nosql.nosqlelasticsearch.entities.Exam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExamRepository extends ElasticsearchRepository<Exam, UUID> {

    Optional<List<Exam>> findExamBySubjectSubjectname(String subject);
}
