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
@Document(indexName = "index_teacher")
public class Teacher {
    @Id
    private UUID id;
    @Field(type = FieldType.Text)
    private String fio;
    @Field(type = FieldType.Date, format=DateFormat.basic_date)
    private LocalDate birthday;
    @Field(type = FieldType.Text)
    private String gender;
    @Field(type = FieldType.Text)
    private String title;
    @Field(type = FieldType.Text)
    private String teacherdegree;
    @Field(type = FieldType.Text)
    private String phone;
}
