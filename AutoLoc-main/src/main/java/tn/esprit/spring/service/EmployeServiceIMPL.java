package tn.esprit.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.domain.Agence;
import tn.esprit.spring.domain.Employe;
import tn.esprit.spring.repository.AgenceRepository;
import tn.esprit.spring.repository.EmployeRepository;

import java.util.List;


@AllArgsConstructor
@Service
public class EmployeServiceIMPL implements iEmployeService {

    EmployeRepository empRepo;

    AgenceRepository agence;


    @Override
     public Employe creer(Employe employe) {
        return empRepo.save(employe);
    }

    @Override
    public Employe obtenirParId(Long id) {
        return empRepo.findById(id).orElse(null);
    }

    @Override
    public List<Employe> listerTous() {
        return (List<Employe>) empRepo.findAll();
    }

    @Override
    public Employe mettreAJour(Employe employe) {
        return empRepo.save(employe);
    }

    @Override
    public void supprimer(Long id) {
        empRepo.deleteById(id);
    }
@Override
    public Employe affecterAgenceEmploye(long idAgence, long idEmplye) {
        //donnees
    Employe employe = empRepo.findById(idEmplye).orElse(null);
    Agence agance = agence.findById(idAgence).orElse(null);
    assert employe != null;
    employe.setAgence(agance);
    //save
    Employe save = empRepo.save(employe);
    return save;

    }
}
