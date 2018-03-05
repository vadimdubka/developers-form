package com.vadimdubka.form.controller;

import com.vadimdubka.form.dao.DeveloperRepository;
import com.vadimdubka.form.dao.SkillRepository;
import com.vadimdubka.form.entity.Developer;
import com.vadimdubka.form.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SuppressWarnings({"HardCodedStringLiteral", "DuplicateStringLiteralInspection"})
@Controller
public class DevelopersController {
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private SkillRepository     skillRepository;
    
    @RequestMapping("/developer/{id}")
    public String showDeveloper(@PathVariable Long id, Model model) {
        model.addAttribute("developer", developerRepository.findOne(id));
        model.addAttribute("skills", skillRepository.findAll());
        return "developer";
    }
    
    @RequestMapping(value = "/developers", method = RequestMethod.GET)
    public String showAllDevelopers(Model model) {
        model.addAttribute("developers", developerRepository.findAll());
        return "developers";
    }
    
    @RequestMapping(value = "/developers", method = RequestMethod.POST)
    public String saveDeveloper(@RequestParam String email, @RequestParam String firstName,
                                @RequestParam String lastName,
                                Model model) {
        Developer newDeveloper = new Developer(firstName, lastName, email);
        developerRepository.save(newDeveloper);
        return "redirect:/developer/" + newDeveloper.getId();
    }
    
    @RequestMapping(value = "/developer/{id}/skill", method = RequestMethod.POST)
    public String addDeveloperSkill(@PathVariable Long id, @RequestParam Long skillId, Model model) {
        Skill skill = skillRepository.findOne(skillId);
        Developer developer = developerRepository.findOne(id);
        String view;
        if (developer != null) {
            //TODO вынести в cервисы
            if (!developer.hasSkill(skill)) {
                developer.getSkills().add(skill);
                developerRepository.save(developer);
            }
            view = "redirect:/developer/" + id;
        } else {
            view = "redirect:/developers";
        }
        return view;
    }
}
