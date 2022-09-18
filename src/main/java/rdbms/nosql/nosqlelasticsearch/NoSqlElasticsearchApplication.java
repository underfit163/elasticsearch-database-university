package rdbms.nosql.nosqlelasticsearch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import rdbms.nosql.nosqlelasticsearch.entities.*;
import rdbms.nosql.nosqlelasticsearch.repositories.*;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableElasticsearchRepositories
public class NoSqlElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoSqlElasticsearchApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ExamRepository examRepository,
                                        MarkRepository markRepository,
                                        StudentRepository studentRepository,
                                        SubjectRepository subjectRepository,
                                        TeacherRepository teacherRepository) {
        return args -> {
            examRepository.deleteAll();
            markRepository.deleteAll();
            studentRepository.deleteAll();
            subjectRepository.deleteAll();
            teacherRepository.deleteAll();


            Student student1 = new Student(
                    UUID.randomUUID(), "Андрей", LocalDate.of(1999, 3, 20), "м", "4354543");
            Student student2 = new Student(
                    UUID.randomUUID(), "Алексей", LocalDate.of(1998, 12, 31), "м", "784654");
            studentRepository.save(student1);
            studentRepository.save(student2);

            Subject subject1 = new Subject(UUID.randomUUID(), "noSql");
            Subject subject2 = new Subject(UUID.randomUUID(), "Java");
            subjectRepository.save(subject1);
            subjectRepository.save(subject2);

            Teacher teacher1 = new Teacher(
                    UUID.randomUUID(), "Анфиса", LocalDate.of(1989, 3, 20), "ж", "доцент",
                    "кандидат наук", "4354543");
            Teacher teacher2 = new Teacher(
                    UUID.randomUUID(), "Алексей", LocalDate.of(1978, 3, 20), "м", "доцент",
                    "кандидат наук", "111111");
            teacherRepository.save(teacher1);
            teacherRepository.save(teacher2);

            Exam exam1 = new Exam(UUID.randomUUID(), "экзамен", 54, 1, subject1, teacher1);
            Exam exam2 = new Exam(UUID.randomUUID(), "экзамен", 54, 2, subject2, teacher2);
            examRepository.save(exam1);
            examRepository.save(exam2);

            Mark mark1 = new Mark(UUID.randomUUID(), "5", LocalDate.of(2019, 1, 14), student1, exam1);
            Mark mark2 = new Mark(UUID.randomUUID(), "4", LocalDate.of(2019, 1, 14), student1, exam2);
            Mark mark3 = new Mark(UUID.randomUUID(), "3", LocalDate.of(2019, 1, 14), student2, exam1);
            Mark mark4 = new Mark(UUID.randomUUID(), "3", LocalDate.of(2019, 1, 14), student2, exam2);

            markRepository.save(mark1);
            markRepository.save(mark2);
            markRepository.save(mark3);
            markRepository.save(mark4);

            subjectRepository.findAll().forEach(System.out::println);
            examRepository.findAll().forEach(System.out::println);
            studentRepository.findAll().forEach(System.out::println);
            teacherRepository.findAll().forEach(System.out::println);
            markRepository.findAll().forEach(System.out::println);
            System.out.println("Оценки студентов:");
            studentRepository.findStudentsByFioContaining("А")
                    .ifPresent(students -> students.forEach(student -> {
                        System.out.println(student.getFio());
                        markRepository
                                .findAllMarkByStudentFio(student.getFio())
                                .ifPresent(marks ->
                                        marks.forEach(mark -> System.out.println("Оценка: " + mark.getEvaluation())));
                    }));

            System.out.println("Оценки до:");
            markRepository.findAll().forEach(mark -> System.out.println(mark.getEvaluation()));

            mark4.setEvaluation("4");
            markRepository.save(mark4);

            markRepository.deleteById(mark1.getId());

            System.out.println("Оценки после:");
            markRepository.findAll().forEach(mark -> System.out.println(mark.getEvaluation()));
        };
    }
}
