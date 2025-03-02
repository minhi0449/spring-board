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

@Configuration // 이 클래스가 Spring 설정 클래스임을 명시
public class AppConfig {

    // @Bean : Spring 컨테이너에 Bean으로 등록하기 위한 어노테이션 (누락되어 있었음)
    @Bean // 다른 컴포넌트에서 ModelMapper 주입 받을 수 있음
    public ModelMapper modelMapper(){

        // DTO와 Entity 간 변환을 위한 ModelMapper 설정

        // ModelMapper 인스턴스 생성
        ModelMapper modelMapper = new ModelMapper(); // 이 객체(modelMapper)가 DTO와 Entity 간 변환을 담당

        // 도구에 어떤 방식으로 사용할지 설정을 바꾸는 것 (예: 가위로 종이를 자를 때, 자르는 방향을 설정하는 것)
        modelMapper.getConfiguration() // ModelMapper 설정 시작 ↴

                // 필드 접근 수준 : PRIVATE 설정 (즉, ModelMapper가 변환을 할 때, 필드에 직접 접근하려면  private 접근 권한을 가진 필드로만 접근 가능)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)

                // 필드 매핑 전략 - 엄격(STRICT) : 필드 이름이 정확히 일치해야만 매핑되도록 설정
                .setMatchingStrategy(MatchingStrategies.STRICT) // 다른 전략 : LOOSE(느슨한) / STANDARD(표준)

                .setFieldMatchingEnabled(true);
        return modelMapper;
    }
}
