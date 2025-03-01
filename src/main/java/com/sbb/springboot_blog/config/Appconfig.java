package com.sbb.springboot_blog.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
    날짜 : 2025.03.01 (토)
    이름 : 김민희
    내용 : ModelMapper 설정을 통해 DTO와 Entity 간의 변환을 효율적으로 처리하기 위한 설정
 */

@Configuration
public class Appconfig {

    @Bean
    public ModelMapper modelMapper(){

        // DTO와 Entity 간 변환을 위한 ModelMapper 설정
        ModelMapper modelMapper = new ModelMapper(); // 이 객체(modelMapper)가 DTO와 Entity 간 변환을 담당
        modelMapper.getConfiguration()
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)

                // 필드 매핑 전략 - 엄격(STRICT) : 필드 이름이 정확히 일치해야만 매핑되도록 설정
                .setMatchingStrategy(MatchingStrategies.STRICT) // 다른 전략 : LOOSE(느슨한) / STANDARD(표준)

                .setFieldMatchingEnabled(true);
        return modelMapper;
    }
}
