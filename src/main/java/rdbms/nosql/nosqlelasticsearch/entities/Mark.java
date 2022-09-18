package rdbms.nosql.nosqlelasticsearch.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@Document(indexName = "index_mark")
public class Mark {
    @Id
    private UUID id;
    @Field(type = FieldType.Text)
    private String evaluation;
    @Field(type = FieldType.Date, format=DateFormat.basic_date)
    private LocalDate passdate;
    @Field(type = FieldType.Object)
    private Student student;
    @Field(type = FieldType.Object)
    private Exam exam;
}
