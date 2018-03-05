package com.vadimdubka.form;

import com.vadimdubka.form.dao.DeveloperRepository;
import com.vadimdubka.form.dao.SkillRepository;
import com.vadimdubka.form.entity.Developer;
import com.vadimdubka.form.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@SuppressWarnings("HardCodedStringLiteral")
@SpringBootApplication
public class Application implements CommandLineRunner {
    
    @Autowired
    private DeveloperRepository developerRepository;
    
    @Autowired
    private SkillRepository skillRepository;
    
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
        Skill java = new Skill("Java", "Java programming language");
        Skill spring = new Skill("Spring", "Spring framework");
        Skill jpa = new Skill("JPA", "JPA technology");
        Skill hibernate = new Skill("Hibernate", "Hibernate framework");
        Skill rest = new Skill("REST", "REST architecture");
        Skill javascript = new Skill("Javascript", "Javascript programming language");
        Skill css = new Skill("CSS", "CSS programming language");
        Skill html = new Skill("HTML", "HTML programming language");
        
        skillRepository.save(java);
        skillRepository.save(spring);
        skillRepository.save(jpa);
        skillRepository.save(hibernate);
        skillRepository.save(rest);
        skillRepository.save(javascript);
        skillRepository.save(css);
        skillRepository.save(html);
        
        Collection<Developer> developers = new ArrayList<>();
        developers.add(new Developer("John", "Smith", "john.smith@example.com",
                                     Arrays.asList(java, spring, rest)));
        developers.add(new Developer("Mark", "Johnson", "mjohnson@example.com",
                                     Arrays.asList(jpa, hibernate)));
        developers.add(new Developer("Michael", "Williams", "michael.williams@example.com",
                                     Arrays.asList(java, spring)));
        developers.add(new Developer("Fred", "Miller", "f.miller@example.com",
                                     Arrays.asList(javascript, css, html)));
        developers.add(new Developer("Bob", "Brown", "brown@example.com",
                                     Arrays.asList(java, javascript)));
        developerRepository.save(developers);
    }
    
}
