package com.qin.cabinettest.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qin.cabinettest.model.Cabinet;

@Service
@Mapper
public interface CabinetMapper {
    /**
     * 根据code更改机柜信息
     * @return
     */
	@Update("UPDATE cc_ci_short_attr_0 SET CLASS_ID=#{data.classname},SV_1=#{data.name},SV_2=#{data.belong},SV_3=#{data.unitType},SV_4=#{data.uBit}WHERE SV_0=#{data.code}")
    int updateByCode(@Param("data") Cabinet data);
}
