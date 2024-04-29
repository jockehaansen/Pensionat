package com.example.pensionat.Services;

import com.example.pensionat.Dtos.DetailedRumDto;
import com.example.pensionat.Dtos.RumDto;
import com.example.pensionat.Models.Bokning;
import com.example.pensionat.Models.Rum;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

public interface RumService {

    public RumDto rumToRumDto(Rum r);
    public Rum rumDtoToRum(RumDto r);
    public DetailedRumDto rumToDetailedRumDto(Rum r);
    public Rum DetailedRumDtoToRum(DetailedRumDto r);
    public List<DetailedRumDto> getAllRum();
    public String addRum(Rum r);
    public String updateRum(RumDto r);
    public String deleteRum(long id);

    public Rum getRumById(Long id);
    String getAllAvailableRooms(String name, String telNr, String email,
                                String startDate, String endDate, int antalPersoner, Model model);
    public List<Rum> getAllRum2();
    List<Long> getNonAvailableRoomsId(List<Bokning> bokningar, LocalDate startDate, LocalDate endDate);
}
