package rdbms.nosql.nosqlelasticsearch.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import rdbms.nosql.nosqlelasticsearch.entities.Subject;

import java.util.UUID;

public interface SubjectRepository extends ElasticsearchRepository<Subject, UUID> {
}
