package com.shopping.mapper;

import org.apache.ibatis.annotations.Param;

public interface DictionaryMapper {

    public String selectDictValueByKey(@Param("dictKey") String dictKey);
}
