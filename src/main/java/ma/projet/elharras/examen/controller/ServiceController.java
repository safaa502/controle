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


import ma.projet.elharras.examen.service.ServiceService;
import ma.projet.elharras.examen.entities.Service;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("")
    public List<Service> getAllCities() {
        return serviceService.getAllCities();
    }

    @GetMapping("/{id}")
    public Service getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id);
    }

    @PostMapping("")
    public Service createService(@RequestBody Service Service) {
        return serviceService.saveService(Service);
    }

    @PutMapping("/{id}")
    public Service updateService(@PathVariable Long id, @RequestBody Service Service) {
        Service existingService = serviceService.getServiceById(id);
        if (existingService != null) {
            existingService.setNom(Service.getNom());
            return serviceService.saveService(existingService);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
    }
}
