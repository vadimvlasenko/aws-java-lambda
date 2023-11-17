package com.test.service;

import com.test.model.SponsorModel;
import com.test.exception.SponsorNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SponsorService {

    private List<SponsorModel> sponsors = new ArrayList<>();

    public List<SponsorModel> getSponsors() {
        return Collections.unmodifiableList(sponsors);
    }
    
    public SponsorModel getSponsorById(String id) {
        return sponsors.stream()
                .filter(sponsor -> sponsor.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new SponsorNotFoundException("Cannot find sponsor with provided ID"));
    }
    
    public void createSponsor(SponsorModel sponsor) {
        sponsors.add(sponsor);
    }
}
