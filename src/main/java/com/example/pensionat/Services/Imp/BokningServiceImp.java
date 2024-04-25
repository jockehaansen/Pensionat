package com.example.pensionat.Services.Imp;


import com.example.pensionat.Dtos.*;
import com.example.pensionat.Models.Bokning;
import com.example.pensionat.Models.Kund;
import com.example.pensionat.Models.Rum;
import com.example.pensionat.Repositories.BokningRepo;
import com.example.pensionat.Repositories.KundRepo;
import com.example.pensionat.Repositories.RumRepo;
import com.example.pensionat.Services.BokningService;
import com.example.pensionat.Services.KundService;
import com.example.pensionat.Services.RumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BokningServiceImp implements BokningService {

    private final BokningRepo br;

    private final KundService kundService;
    private final RumService rumService;

    public String addBokning() {
        return "addBokning";
    }

    //String valueOf och LocalDate parse på nedan metoder, behöver kontroll testas så dom fungerar
    @Override
    public BokningDto BokningToBokningDto(Bokning b) {
        return BokningDto.builder().id(b.getId()).startdatum(String.valueOf(b.getStartdatum())).
                slutdatum(String.valueOf(b.getSlutdatum())).numOfBeds(b.getNumOfBeds()).build();
    }

    @Override
    public Bokning detailedBokningDtoToBokning(DetailedBokningDto b, Kund kund, Rum rum) {
        return Bokning.builder().id(b.getId()).startdatum(LocalDate.parse(b.getStartdatum())).
                slutdatum(LocalDate.parse(b.getSlutdatum())).numOfBeds(b.getNumOfBeds())
                .kund(kund).rum(rum).build();
    }

    @Override
    public DetailedBokningDto bokningToDetailedBokningDto(Bokning b) {
        return DetailedBokningDto.builder().id(b.getId()).startdatum(String.valueOf(b.getStartdatum())).
                slutdatum(String.valueOf(b.getSlutdatum())).numOfBeds(b.getNumOfBeds())
                .kund(new KundDto(b.getKund().getId(), b.getKund().getNamn(), b.getKund().getTel(), b.getKund().getEmail()))
                .rum(new RumDto(b.getRum().getId(), b.getRum().getRumsnr())).build();
    }

    @Override
    public List<DetailedBokningDto> getAllBokningar() {
        return br.findAll().stream().map(bok -> bokningToDetailedBokningDto(bok)).toList();
    }


    /* Kommenterar ut denna för tillfället då jag har samma länkad till thymeleaf
    @Override
    public String addBokning(Bokning b) {
        return null;
    }

     */


    /*
            Kund kund = kr.findById(k.getId()).get();
        if (k.getNamn() != null && !k.getNamn().isEmpty())
            kund.setNamn(k.getNamn());
        if (k.getTel() != null && !k.getTel().isEmpty())
            kund.setTel(k.getTel());
        if (k.getEmail() != null && !k.getEmail().isEmpty())
            kund.setEmail(k.getEmail());
        kr.save(kund);
        return "Kunden har uppdaterats.";


                Rum rum = rr.findById(r.getId()).get();
        if (r.getRumsnr() != 0)
            rum.setRumsnr(r.getRumsnr());
        //Vet inte hur man ska testa denna, får återkomma senare
        rum.setDubbelrum(r.isDubbelrum());
        if (r.getStorlek() != 0)
            rum.setStorlek(r.getStorlek());
        rr.save(rum);
        return "Rummet har uppdaterats.";
     */


    @Override
    public String updateBokning(BokningDto b) {
        return null;
    }

    @Override
    public String deleteBokning(long id) {
        Bokning b = br.findById(id).get();
        if (b != null){
            br.deleteById(id);
            return "Bokningen borttagen";
        }
        return "Bokningen hittas inte";
    }

    @Override
    public String newBokning(String namn, String tel, String email, LocalDate startdatum, LocalDate slutdatum, DetailedRumDto rum) {
        KundDto kundDto = kundService.checkIfKundExistByName(namn, email, tel);
        Kund kund = kundService.kundDtoToKund(kundDto);
        Rum r = rumService.DetailedRumDtoToRum(rum);
        Bokning b = new Bokning(kund, r, startdatum, slutdatum);
        br.save(b);
        return "Bokning gjord";
    }
}
