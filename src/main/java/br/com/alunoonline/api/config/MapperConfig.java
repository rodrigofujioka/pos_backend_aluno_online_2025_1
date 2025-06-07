package br.com.alunoonline.api.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Define a estratégia de correspondência mais rígida
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT) // ou LOOSE para mais flexibilidade
                .setSkipNullEnabled(true)                       // ignora valores nulos durante o mapeamento
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        return modelMapper;
    }
}
