package org.sillysociety.service.impl;

import org.sillysociety.models.Stylist;
import org.sillysociety.repository.StylistRepository;
import org.sillysociety.service.StylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StylistServiceImpl implements StylistService {
    @Autowired
    private StylistRepository stylistRepository;

    @Override
    public Stylist addStylist(Stylist stylist) {
        return stylistRepository.save(stylist);
    }

    @Override
    public void delete(Stylist stylist) {
        stylistRepository.delete(stylist);
    }

    @Override
    public Stylist getById(Integer id) {
        return stylistRepository.findById(id).orElse(null);
    }

    @Override
    public List<Stylist> getAllStylists() {
        return (List<Stylist>) stylistRepository.findAll();
    }

    @Override
    public Stylist updateStylist(Stylist stylist) {
        return stylistRepository.save(stylist);
    }
}
