package com.newagesoft.hinario.service;

import com.newagesoft.hinario.dto.HinoDTO;
import com.newagesoft.hinario.exception.NotFoundException;
import com.newagesoft.hinario.model.Hino;
import com.newagesoft.hinario.repositories.HinoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HinoService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private HinoRepository hinoRepository;

    public HinoDTO toDto(Hino hinoEntity, Class<HinoDTO> hinoDtoClass) {
        return modelMapper.map(hinoEntity, hinoDtoClass);
    }

    public Hino toEntity(HinoDTO hinoDto, Class<Hino> hinoClass) {
        return modelMapper.map(hinoDto, hinoClass);
    }

    public HinoDTO save(HinoDTO hino) {
        return toDto(hinoRepository.save(toEntity(hino, Hino.class)), HinoDTO.class);
    }

    public HinoDTO update(HinoDTO hinoDTO) {
        hinoRepository.findById(hinoDTO.getId()).orElseThrow(() -> new NotFoundException("Hino Não Encontrado"));
        return toDto(hinoRepository.save(toEntity(hinoDTO, Hino.class)), HinoDTO.class);
    }

    public void delete(long idHino) {
        Hino hino = hinoRepository.findById(idHino).orElseThrow(() -> new NotFoundException("Hino Não Encontrado"));
        hinoRepository.delete(hino);
    }

    public HinoDTO find(long idHino) {
        return toDto(hinoRepository.findById(idHino).orElseThrow(() -> new NotFoundException("Hino não encontrado.")), HinoDTO.class);
    }

    public Page<HinoDTO> findAllDto(Pageable pageable) {
        return hinoRepository
                .findAll(pageable)
                .map(hino -> modelMapper.map(hino, HinoDTO.class));
    }

}
