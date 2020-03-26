package com.kodilla.medicalclinic.client;

import com.kodilla.medicalclinic.domain.dto.Icd10Dto;
import com.kodilla.medicalclinic.domain.dto.IcdDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class IcdClient {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${icd10.api.endpoint.prod}")
    private String icd10ApiEndpoint;

    @Value("${icd10.token}")
    private String icd10Token;

    @Value("${icd10.codes}")
    private String icd10Codes;


    public List<IcdDtoResponse> getIcd10Codes() {

        URI url = UriComponentsBuilder.fromHttpUrl(icd10ApiEndpoint + "/getcodes")
                .queryParam("q", icd10Codes)
                .queryParam("rt", "json")
                .queryParam("token", icd10Token).build().encode().toUri();

//        IcdDtoResponse[] icd10Response = restTemplate.getForObject(url, IcdDtoResponse[].class);
        IcdDtoResponse icd10Response = restTemplate.getForObject(url, IcdDtoResponse.class);


        if (icd10Response != null) {
            return Arrays.asList(icd10Response);
        }
        return new ArrayList<>();


//        Icd10Dto[] icd10Response = restTemplate.getForObject(
//                icd10ApiEndpoint + "/getcodes?q=" + icd10Codes + " &rt=json&token=" + icd10Token,
//                Icd10Dto.class);

    }
}
