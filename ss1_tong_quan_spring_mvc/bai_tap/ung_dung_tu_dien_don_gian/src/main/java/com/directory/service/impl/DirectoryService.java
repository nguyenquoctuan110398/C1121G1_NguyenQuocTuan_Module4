package com.directory.service.impl;

import com.directory.service.IDirectoryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class DirectoryService implements IDirectoryService {
    @Override
    public String result(String englishWord) {

        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("Hello", "Xin chào");
        stringMap.put("Car", "Ô tô");
        stringMap.put("Dog", "Con chó");
        stringMap.put("Cat", "Con mèo");
        stringMap.put("How", "Thế nào");
        stringMap.put("Boy", "Nam");
        stringMap.put("Girl", "Nữ");

        Set<String> stringSet = stringMap.keySet();

        for (String str: stringSet) {
            if (str.equals(englishWord)){
                return stringMap.get(str);
            }
        }
        return "Không tìm thấy";
    }
}
