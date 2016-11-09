package org.odobd.odonates.model;

/**
 * Created by borhan on 11/9/16.
 */

public class Species {
    private String suborder,
            family,
            genus,
            specificname,
            scientist,
            year,
            commonname,
            IUCN_status,
            habitat,
            system,
            distribution,
            abundance,
            worldwide_distribution,
            flightseason,
            description,
            desmale,
            desfemale,
            similar,
            identification,
            COI_gene,
            co1_protein;

    public Species() {
    }

    public Species(String suborder,
                   String family,
                   String genus,
                   String specificname,
                   String scientist,
                   String year,
                   String commonname,
                   String IUCN_status,
                   String habitat,
                   String system,
                   String distribution,
                   String abundance,
                   String worldwide_distribution,
                   String flightseason,
                   String description,
                   String desmale,
                   String desfemale,
                   String similar,
                   String identification,
                   String COI_gene,
                   String co1_protein) {
        this.suborder = suborder;
        this.family = family;
        this.genus = genus;
        this.specificname = specificname;
        this.scientist = scientist;
        this.year = year;
        this.commonname = commonname;
        this.IUCN_status = IUCN_status;
        this.habitat = habitat;
        this.system = system;
        this.distribution = distribution;
        this.abundance = abundance;
        this.worldwide_distribution = worldwide_distribution;
        this.flightseason = flightseason;
        this.description = description;
        this.desmale = desmale;
        this.desfemale = desfemale;
        this.similar = similar;
        this.identification = identification;
        this.COI_gene = COI_gene;
        this.co1_protein = co1_protein;
    }

    public String getSuborder() {
        return suborder;
    }

    public String getFamily() {
        return family;
    }

    public String getGenus() {
        return genus;
    }

    public String getSpecificname() {
        return specificname;
    }

    public String getScientist() {
        return scientist;
    }

    public String getYear() {
        return year;
    }

    public String getCommonname() {
        return commonname;
    }

    public String getIUCN_status() {
        return IUCN_status;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getSystem() {
        return system;
    }

    public String getDistribution() {
        return distribution;
    }

    public String getAbundance() {
        return abundance;
    }

    public String getWorldwide_distribution() {
        return worldwide_distribution;
    }

    public String getFlightseason() {
        return flightseason;
    }

    public String getDescription() {
        return description;
    }

    public String getDesmale() {
        return desmale;
    }

    public String getDesfemale() {
        return desfemale;
    }

    public String getSimilar() {
        return similar;
    }

    public String getIdentification() {
        return identification;
    }

    public String getCOI_gene() {
        return COI_gene;
    }

    public String getCo1_protein() {
        return co1_protein;
    }
}
