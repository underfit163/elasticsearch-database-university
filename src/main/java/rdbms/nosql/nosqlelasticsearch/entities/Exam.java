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
@Document(indexName = "index_exam")
public class Exam {
    @Id
    private UUID id;
    @Field(type = FieldType.Text)
    private String passtype;
    @Field(type = FieldType.Integer)
    private Integer totalhours;
    @Field(type = FieldType.Integer)
    private Integer semester;
    @Field(type = FieldType.Object)
    private Subject subject;
    @Field(type = FieldType.Object)
    private Teacher teacher;

}
