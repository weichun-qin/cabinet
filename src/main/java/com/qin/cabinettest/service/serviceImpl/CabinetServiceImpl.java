package com.qin.cabinettest.service.serviceImpl;

import com.qin.cabinettest.mapper.CabinetMapper;
import com.qin.cabinettest.model.Cabinet;
import com.qin.cabinettest.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CabinetServiceImpl implements CabinetService{

    @Autowired
    private CabinetMapper cbm;

    @Override
    public int update(Cabinet data) {
        return cbm.updateByCode(data);
    }
}
