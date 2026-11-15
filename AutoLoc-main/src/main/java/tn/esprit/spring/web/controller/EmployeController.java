package tn.esprit.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.domain.Employe;
import tn.esprit.spring.service.iEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/EmployeController")
public class EmployeController  {

    iEmployeService employeeService;




    @PostMapping ("/create")
    public Employe creer(@RequestBody Employe employe) {
        return employeeService.creer(employe);
    }
@GetMapping("/getemployee/{id}")
    public Employe obtenirParId(@PathVariable long id) {
        return employeeService.obtenirParId(id);
    }

    @GetMapping("/getAll")
    public List<Employe> listerTous() {
        return employeeService.listerTous();
    }
@PutMapping("/update")
    public Employe mettreAJour(@RequestBody Employe employe) {
        return employeeService.mettreAJour(employe);
    }
@DeleteMapping("/delete/{id}")
    public void supprimer( @PathVariable Long id) {
        employeeService.supprimer(id);
    }
    @PutMapping("/affecterAgenceEmploye/{idAgence}/{idEmploye}")
    public Employe affecterAgenceEmploye(@PathVariable long idAgence, @PathVariable long idEmploye) {
        return employeeService.affecterAgenceEmploye(idAgence, idEmploye);
    }


}
