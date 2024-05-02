package com.example.pensionat.Services.Imp;

import com.example.pensionat.Dtos.DetailedRumDto;
import com.example.pensionat.Models.Rum;
import com.example.pensionat.Repositories.RumRepo;
import com.example.pensionat.Services.RumService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RumServiceImp implements RumService {

    private final RumRepo rumRepo;

    @Override
    public DetailedRumDto rumToDetailedRumDto(Rum r) {
        return null;
    }

    @Override
    public List<DetailedRumDto> getAllRum() {
        return rumRepo.findAll().stream().map(rum -> rumToDetailedRumDto(rum)).toList();
    }

    @Override
    public List<Rum> getAllRum2() {
        return rumRepo.findAll();
    }
    @Override
    public String addRum(Rum r) {
        rumRepo.save(r);
        return "Rum nr " + r.getRumsnr() + " har sparats.";
    }

    public Rum getRumById(Long id){
        return rumRepo.findById(id).get();
    }

    @Override
    public String deleteRum(Long id) {
        Rum rum = rumRepo.findById(id).get();
        rumRepo.deleteById(id);
        return "Rum nr " + rum.getRumsnr() + " har raderats.";

    }
}
