package rdbms.nosql.nosqlelasticsearch.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.UUID;

@Data
@AllArgsConstructor
@Document(indexName = "index_subject")
public class Subject {
    @Id
    private UUID id;
    @Field(type = FieldType.Text)
    private String subjectname;
}
