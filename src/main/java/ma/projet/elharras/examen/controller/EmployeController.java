package ma.projet.elharras.examen.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.elharras.examen.entities.Employe;
import ma.projet.elharras.examen.service.EmployeService;



@RestController
@RequestMapping("/api/employes")
@CrossOrigin
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("")
    public List<Employe> getAllEmployes() {
        return employeService.getAllCities();
    }

    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return employeService.getEmployeById(id);
    }

    @PostMapping("")
    public Employe createEmploye(@RequestBody Employe Employe) {
        return employeService.saveEmploye(Employe);
    }

    @PutMapping("/{id}")
    public Employe updateEmploye(@PathVariable Long id, @RequestBody Employe Employe) {
        Employe existingEmploye = employeService.getEmployeById(id);
        if (existingEmploye != null) {
            existingEmploye.setNom(Employe.getNom());
            existingEmploye.setPrenom(Employe.getPrenom());
            existingEmploye.setDateNaissance(Employe.getDateNaissance());
            existingEmploye.setPhoto(Employe.getPhoto());
            return employeService.saveEmploye(existingEmploye);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        employeService.deleteEmploye(id);
    }
}
