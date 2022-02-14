package com.demo.contacts.service.mapper;

import com.demo.contacts.model.ChangeHistory;
import com.demo.contacts.service.dto.ChangeHistoryDto;
import org.springframework.stereotype.Service;

@Service
public class ChangeHistoryMapper extends ModelEntityMapper<ChangeHistory, ChangeHistoryDto> {

    public ChangeHistory toModel(ChangeHistoryDto dto) {
        ChangeHistory model = super.toModel(dto, ChangeHistory.class);
        model.setField(dto.getField());
        model.setOldValue(dto.getOldValue());
        model.setNewValue(dto.getNewValue());
        model.setPerformedBy(dto.getPerformedBy());
        model.setDate(dto.getDate());

        return model;
    }

    public ChangeHistoryDto toDto(ChangeHistory model) {
        ChangeHistoryDto dto = super.toDto(model, ChangeHistoryDto.class);
        dto.setField(model.getField());
        dto.setOldValue(model.getOldValue());
        dto.setNewValue(model.getNewValue());
        dto.setPerformedBy(model.getPerformedBy());
        dto.setDate(model.getDate());

        return dto;
    }
}